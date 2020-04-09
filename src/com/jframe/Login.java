package com.jframe;

import javax.swing.*;
import com.DAO.UserDAO;
import com.entity.User;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
/**
 * ��½���ڣ�JFrame�ࣩ
 * @author Administrator
 * ��Ϊ��½���棬ӵ�и����������Ӧ�ļ����¼�
 * ���Ը����û������ֱ�����ֵ�½�û�Ϊʲô�������û�ѡ��
 * ӵ�б��浱ǰ�û����� �Թ��´�ֱ�ӵ�½ �Լ���ʾ����Ĺ���
 */
public class Login extends JFrame implements ActionListener{
	private static ImageIcon pic;
	private JLabel lid=new JLabel ("   ѧ   ��:");
	private JLabel lpsw=new JLabel("   ��   ��:");
	private JLabel mainpic=new JLabel();
	private JTextField idf=new JTextField();
	private JPasswordField pswf=new JPasswordField();
	private JTextField showPswf=new JTextField();
	private JButton commit=new JButton("��½");
	private JButton cancle=new JButton("ȡ��");
	private JCheckBox remember=new JCheckBox("��������");
	private JCheckBox showPsw=new JCheckBox("��ʾ����");
	private JPanel jp1=new JPanel();
	private JPanel jp2=new JPanel();
	private JPanel jp3=new JPanel();
	private JPanel jp4=new JPanel();
	private JPanel jp5=new JPanel();
	private String id,psw;
	private FileReader fr;
	private BufferedReader br;
	private File f=new File("log/log.txt");
	private User u;
	public Login() {
		super("��½");
		pic=new ImageIcon("pic/Mainpic.png");
		int w=pic.getIconWidth();
		int h=pic.getIconHeight();
		mainpic.setSize(w,h);
		setBounds(600,300,w,h+140);
		mainpic.setIcon(pic);
		add(mainpic,BorderLayout.NORTH);
		add(jp1,BorderLayout.CENTER);
		add(jp2,BorderLayout.SOUTH);
		jp1.setLayout(new GridLayout(1,2));
		jp3.setLayout(new GridLayout(2,1));
		jp4.setLayout(new GridLayout(2,1));
		jp3.add(lid);
		jp3.add(lpsw);
		jp4.add(idf);
		jp4.add(pswf);
		jp1.add(jp3);
		jp1.add(jp4);
		jp1.add(jp5);
		jp5.add(remember);
		jp5.add(showPsw);
		jp2.add(commit);
		jp2.add(cancle);
		commit.addActionListener(this);
		cancle.addActionListener(this);
		showPsw.addActionListener(this);		
		try{
			if(!f.exists()) {
				idf.setText("");
				pswf.setText("");
			}else{
				fr=new FileReader(f);
				br=new BufferedReader(fr);
				String line=null;
				String uname=null;
				String pswd=null;
				line = br.readLine ();
				int x=line.indexOf(" ");
				uname=line.substring(1, x);		
				pswd=line.substring(x+1);
				if((line.charAt(0)=='1'))
				{
					idf.setText(uname);
					pswf.setText(pswd);
					remember.setSelected(true);
				}else if((line.charAt(0)=='0')) {
					idf.setText("");
					pswf.setText("");
					remember.setSelected(false);
				}
				fr.close();
				br.close();
			}
		}
		catch(IOException e) {
		}//���ݱ���log�ļ����������ж��Ƿ����˱�������Ĺ��ܣ�����ӦֵΪ1����д�ѱ�����Ϣ  Ϊ0��Ϊ��
				
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==commit) {//��½
			 id=idf.getText();
			 psw=String.valueOf(pswf.getPassword());
			 if((id.equals(""))||(psw.equals("")))
			 {
				 JOptionPane.showMessageDialog(null,"��������Ϣ");
			 }else {
					UserDAO udao=new UserDAO();
					ArrayList<User> alu=udao.list(id);
						if(alu.isEmpty()) {
							JOptionPane.showMessageDialog(null,"�޴�ѧ��");
						}else {
							u=alu.get(0);
						 if(u.getXh().equals(id)) {
						if(u.getMm().equals(psw)) {
							 if(remember.isSelected()) {//��ס����
								 try {				 	
										FileWriter fw=new FileWriter(f);
										BufferedWriter bw=new BufferedWriter(fw);
										String line=1+id+" "+psw;
										bw.write(line);
										bw.newLine();
										bw.flush();
										fw.close();
										bw.close();
										JOptionPane.showMessageDialog(null,"��½�ɹ�");
										dispose();
										new MainWindow(u);
									}
									catch(IOException ex) {
										ex.printStackTrace();
									}
							 }
							 else if(!remember.isSelected()){//����ס����
								 try {	
									 	File f=new File("log/log.txt");
										FileWriter fw=new FileWriter(f);
										BufferedWriter bw=new BufferedWriter(fw);
										String line=0+id+" "+psw;
										bw.write(line);
										bw.newLine();
										bw.flush();
										fw.close();
										bw.close();
										JOptionPane.showMessageDialog(null,"��½�ɹ�");
										dispose();
										new MainWindow(u);
									}
									catch(IOException ex) {
										ex.printStackTrace();
									}
							 }
						 }else {
							 JOptionPane.showMessageDialog(null,"�������");
						 }
					 }}
				
		}}
			 else if(e.getSource()==cancle){//�˳�
			System.exit(0);
		}
			
		if((e.getSource()==showPsw)&&(showPsw.isSelected())) {//��ʾ����
				psw=String.valueOf(pswf.getPassword());
				jp4.remove(pswf);
				showPswf.setText(psw);
				jp4.add(showPswf);
				jp4.repaint();
				jp4.validate();
			}else {
					if((e.getSource()==showPsw)){
						psw=String.valueOf(pswf.getPassword());
						jp4.remove(showPswf);
						pswf.setText(psw);
						jp4.add(pswf);
						jp4.repaint();
						jp4.validate();
				} 
			}
	}
}