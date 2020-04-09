package com.jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.entity.User;
import com.panel.MW_Comm;
import com.panel.MW_Detail;
import com.panel.MW_Options;
import com.panel.MainU;
/**
 * �����ڣ�JFrame�ࣩ
 * @author Administrator
 * �����������Ӧ�����¼�
 * ��ͬ��½�û����õ��Ľ��治ͬ
 */
public class MainWindow extends JFrame implements ActionListener{
	public JToolBar jtb;                    //��๤����
	public JButton main,detail,options,comm;//��๤�����еİ�ť���������ʸ���ҳ��
	public JPanel jp,jptx;                  //���Ĳ��ֵ���壬�͹�������һ��ͷ�����
	public ImageIcon bg,txi;                //ͼ�꣬һ��Ϊ������һ��Ϊͷ��ͼ
	public JLabel tx;                       //ͷ��label
	public MainU mu=new MainU();            //������
	User u;                                 //������ȡ�û������Դ���
	public MainWindow(User u) {
		super("��������  "+u.getXh());
		this.u=u;
		
		jp=new JPanel();
		jtb=new JToolBar();
		jptx=new JPanel();
		txi= new ImageIcon(u.getTx()); 
		Image img = txi.getImage();  
		img = img.getScaledInstance(65,65, Image.SCALE_DEFAULT);  //����ͷ��ͼƬ��С
		txi.setImage(img);
		tx=new JLabel(txi);
		bg=new ImageIcon("pic/bg.jpg");	
		if(u.lb.equals("��ͨ�û�")) {
		main=new JButton("������");
		detail=new JButton("������Ϣ");
		options=new JButton("ѡ��");
		comm=new JButton("�γ̱�");
		}else {
			main=new JButton("������");
			detail=new JButton("�ɼ�����");
			options=new JButton("ѡ��");
			comm=new JButton("��Ϣ����");
		}
		main.setBackground(new Color(83,123,179));
		jtb.setLayout(new GridLayout(5,1));
		jtb.setBackground(Color.BLACK);
		jptx.setLayout(new BorderLayout());	
		Thread t=new Thread(mu);
		t.start();
		add(jtb,BorderLayout.WEST);
		add(jp=mu,BorderLayout.CENTER);
		jtb.add(jptx);
		jtb.add(main);
		jtb.add(detail);
		jtb.add(comm);
		jtb.add(options);
		jptx.add(tx,BorderLayout.CENTER);
		jtb.setFloatable(false);//�����������ƶ�
		
		detail.addActionListener(this);
		comm.addActionListener(this);
		options.addActionListener(this);
		main.addActionListener(this); //ע�������
		
		setBounds(400,100,bg.getIconWidth()+50,bg.getIconHeight()+50);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������������
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		remove(jp);
		Color c=new Color(83,123,179);
		if(e.getSource()==main) {
			main.setBackground(c);
			options.setBackground(Color.white);
			comm.setBackground(Color.white);
			detail.setBackground(Color.white);
			add(jp=mu,BorderLayout.CENTER);
			Thread t=new Thread(mu);
			t.start();
		}else if(e.getSource()==options) {
			options.setBackground(c);
			main.setBackground(Color.white);
			comm.setBackground(Color.white);
			detail.setBackground(Color.white);
			add(jp=new MW_Options(),BorderLayout.CENTER);	
		}else if(e.getSource()==comm) {
			main.setBackground(Color.white);
			options.setBackground(Color.white);
			detail.setBackground(Color.white);
			comm.setBackground(c);
			add(jp=new MW_Comm(u),BorderLayout.CENTER);
		}else if(e.getSource()==detail) {
			main.setBackground(Color.white);
			options.setBackground(Color.white);
			comm.setBackground(Color.white);
			detail.setBackground(c);
			add(jp=new MW_Detail(u,this),BorderLayout.CENTER);
		}
		this.repaint();
		this.validate();
	}//�Թ��������ĸ���ť��Ӽ����¼�  ��Ӧ��Ч�����Ǹı��м���� �Լ� ���а�ť����ɫ ��ǿ����ǰ����ҳ��
}
