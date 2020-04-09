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
 * 主窗口（JFrame类）
 * @author Administrator
 * 各项组件及对应监听事件
 * 不同登陆用户所得到的界面不同
 */
public class MainWindow extends JFrame implements ActionListener{
	public JToolBar jtb;                    //左侧工具栏
	public JButton main,detail,options,comm;//左侧工具栏中的按钮，用来访问各个页面
	public JPanel jp,jptx;                  //中心部分的面板，和工具栏中一个头像面板
	public ImageIcon bg,txi;                //图标，一个为背景，一个为头像图
	public JLabel tx;                       //头像label
	public MainU mu=new MainU();            //主界面
	User u;                                 //用来获取用户参数以传递
	public MainWindow(User u) {
		super("工大助手  "+u.getXh());
		this.u=u;
		
		jp=new JPanel();
		jtb=new JToolBar();
		jptx=new JPanel();
		txi= new ImageIcon(u.getTx()); 
		Image img = txi.getImage();  
		img = img.getScaledInstance(65,65, Image.SCALE_DEFAULT);  //缩放头像图片大小
		txi.setImage(img);
		tx=new JLabel(txi);
		bg=new ImageIcon("pic/bg.jpg");	
		if(u.lb.equals("普通用户")) {
		main=new JButton("主界面");
		detail=new JButton("个人信息");
		options=new JButton("选项");
		comm=new JButton("课程表");
		}else {
			main=new JButton("主界面");
			detail=new JButton("成绩管理");
			options=new JButton("选项");
			comm=new JButton("信息管理");
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
		jtb.setFloatable(false);//工具栏不可移动
		
		detail.addActionListener(this);
		comm.addActionListener(this);
		options.addActionListener(this);
		main.addActionListener(this); //注册监听器
		
		setBounds(400,100,bg.getIconWidth()+50,bg.getIconHeight()+50);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置主窗口属性
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
	}//对工具栏中四个按钮添加监听事件  对应的效果就是改变中间面板 以及 所有按钮背景色 以强调当前所在页面
}
