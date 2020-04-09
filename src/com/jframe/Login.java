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
 * 登陆窗口（JFrame类）
 * @author Administrator
 * 作为登陆界面，拥有各项组件及对应的监听事件
 * 可以根据用户的类别直接区分登陆用户为什么，无需用户选择
 * 拥有保存当前用户密码 以供下次直接登陆 以及显示密码的功能
 */
public class Login extends JFrame implements ActionListener{
	private static ImageIcon pic;
	private JLabel lid=new JLabel ("   学   号:");
	private JLabel lpsw=new JLabel("   密   码:");
	private JLabel mainpic=new JLabel();
	private JTextField idf=new JTextField();
	private JPasswordField pswf=new JPasswordField();
	private JTextField showPswf=new JTextField();
	private JButton commit=new JButton("登陆");
	private JButton cancle=new JButton("取消");
	private JCheckBox remember=new JCheckBox("保存密码");
	private JCheckBox showPsw=new JCheckBox("显示密码");
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
		super("登陆");
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
		}//根据本地log文件保留数据判断是否开启了保存密码的功能，若对应值为1则填写已保存信息  为0则为空
				
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==commit) {//登陆
			 id=idf.getText();
			 psw=String.valueOf(pswf.getPassword());
			 if((id.equals(""))||(psw.equals("")))
			 {
				 JOptionPane.showMessageDialog(null,"请输入信息");
			 }else {
					UserDAO udao=new UserDAO();
					ArrayList<User> alu=udao.list(id);
						if(alu.isEmpty()) {
							JOptionPane.showMessageDialog(null,"无此学号");
						}else {
							u=alu.get(0);
						 if(u.getXh().equals(id)) {
						if(u.getMm().equals(psw)) {
							 if(remember.isSelected()) {//记住密码
								 try {				 	
										FileWriter fw=new FileWriter(f);
										BufferedWriter bw=new BufferedWriter(fw);
										String line=1+id+" "+psw;
										bw.write(line);
										bw.newLine();
										bw.flush();
										fw.close();
										bw.close();
										JOptionPane.showMessageDialog(null,"登陆成功");
										dispose();
										new MainWindow(u);
									}
									catch(IOException ex) {
										ex.printStackTrace();
									}
							 }
							 else if(!remember.isSelected()){//不记住密码
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
										JOptionPane.showMessageDialog(null,"登陆成功");
										dispose();
										new MainWindow(u);
									}
									catch(IOException ex) {
										ex.printStackTrace();
									}
							 }
						 }else {
							 JOptionPane.showMessageDialog(null,"密码错误");
						 }
					 }}
				
		}}
			 else if(e.getSource()==cancle){//退出
			System.exit(0);
		}
			
		if((e.getSource()==showPsw)&&(showPsw.isSelected())) {//显示密码
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