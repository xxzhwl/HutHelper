package com.panel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.*;
import java.text.*;
/**
 * 主页面类（JPanel）
 * @author Administrator
 * 各类组件   通过实现Runnable接口中的run()方法来实现动态显示时间的功能
 */
public class MainU extends JPanel implements Runnable{
	public  ImageIcon bg;
	public  JPanel bt;
	public  JLabel bgl,textHeader,time,xx;
	public  SimpleDateFormat sdf;
	public Font fnA = new Font("微软雅黑",Font.PLAIN,30);
	public MainU(){
		bg=new ImageIcon("pic/bg.jpg");
		bgl=new JLabel(bg);
		bt=new JPanel();
		time=new JLabel();
		textHeader=new JLabel("欢迎来到工大助手 ");
		add(bt,BorderLayout.NORTH);
		bt.add(textHeader);
		bt.add(time);
		add(bgl,BorderLayout.CENTER);
	}
	@Override
	public void run() {
		while(true)
		 {
			 sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			 time.setText(sdf.format(new Date()));
		  try
		  {
		  Thread.sleep(1000); 
		  }
		  catch(Exception e)
		  {
		  time.setText("错误!!!");
		  }
		 } 
	}
}

