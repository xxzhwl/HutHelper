package com.panel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.*;
import java.text.*;
/**
 * ��ҳ���ࣨJPanel��
 * @author Administrator
 * �������   ͨ��ʵ��Runnable�ӿ��е�run()������ʵ�ֶ�̬��ʾʱ��Ĺ���
 */
public class MainU extends JPanel implements Runnable{
	public  ImageIcon bg;
	public  JPanel bt;
	public  JLabel bgl,textHeader,time,xx;
	public  SimpleDateFormat sdf;
	public Font fnA = new Font("΢���ź�",Font.PLAIN,30);
	public MainU(){
		bg=new ImageIcon("pic/bg.jpg");
		bgl=new JLabel(bg);
		bt=new JPanel();
		time=new JLabel();
		textHeader=new JLabel("��ӭ������������ ");
		add(bt,BorderLayout.NORTH);
		bt.add(textHeader);
		bt.add(time);
		add(bgl,BorderLayout.CENTER);
	}
	@Override
	public void run() {
		while(true)
		 {
			 sdf=new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
			 time.setText(sdf.format(new Date()));
		  try
		  {
		  Thread.sleep(1000); 
		  }
		  catch(Exception e)
		  {
		  time.setText("����!!!");
		  }
		 } 
	}
}

