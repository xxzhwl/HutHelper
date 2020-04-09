package com.panel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jframe.*;
import com.DAO.*;
import com.entity.*;
/**
 * 主窗口下——课程表（用户界面）/信息管理（管理员界面） （JPanel）
 * @author Administrator
 * 用户界面下：单纯的一个课程表 无法修改 
 * 管理员界面下：1.展示所有普通用户的基本信息 2.创建用户，修改用户，删除用户，课程管理四大按钮
 * 当创建用户时 本面板移除所有当前组件，加入CreateNewUser类的对象，以及确认添加和返回的按钮，
 * 当修改用户是 管理员先输入自己的xh来验证 然后输入要更改信息的用户xh 然后弹出ChangeUserInfo的一个窗口 进行修改
 * 当删除用户时 输入所要删除的用户xh来删除用户的所有信息以及其课程信息
 * 当课程管理时 输入一个专业名 移除所有当前组件，加入MW_C_CourseTable的一个面板 以及一个修改按钮，一个返回按钮，一个刷新按钮
 */
public class MW_Comm extends JPanel implements ActionListener,ListSelectionListener{
	public JLabel bjq;                                                              //背景墙
	public ImageIcon bji;                                                           //背景图片
	public JButton createU,changeU,deleteU,courseM,changeCT,back,flash,commitCreate;//所有按钮
	public MW_C_AllInfo ai;                                                         //所有用户信息的面板
	public Font fnA = new Font("微软雅黑",Font.PLAIN,24);                             //字体样式
	public MW_C_CourseTable ct;                                                     //课程表面板
	public CreateNewUser cnu;                                                       //创建用户面板
		   User u,usr;
		   UserDAO udao;
		   ArrayList<User> ArrayU;
		   int row,col;
	public MW_Comm(User us) {
		usr=us;
		ai=new MW_C_AllInfo();
		bji=new ImageIcon("pic/1.png");
		bjq=new JLabel(bji);
		bjq.setBounds(0, 0,bji.getIconWidth(),bji.getIconHeight());
		add(bjq);
		if(us.getLb().equals("普通用户")) {
			UserDAO udao=new UserDAO();
			User u=new User();
			u=udao.list(us.getXh()).get(0);
			String zy=u.getZy();
			ct=new MW_C_CourseTable(zy);
			ct.setBounds(10,10,1043,730);
			bjq.add(ct);
			ct.jtbl.setEnabled(false);                                               //用户界面下：单纯的一个课程表 无法修改 
		}else {
			bjq.add(ai);
			changeU=new JButton("修改用户");
			changeU.setBounds(800, 100, 245, 120);		
			createU=new JButton("创建用户");
			createU.setBounds(800, 250, 245, 120);				
			deleteU=new JButton("删除用户");
			deleteU.setBounds(800, 400, 245, 120);
			courseM=new JButton("课表管理");
			courseM.setBounds(800, 550, 245, 120);
			changeU.setFont(fnA);
			createU.setFont(fnA);
			deleteU.setFont(fnA);
			courseM.setFont(fnA);
			changeU.addActionListener(this);
			createU.addActionListener(this);
			deleteU.addActionListener(this);
			courseM.addActionListener(this);
			bjq.add(changeU);
			bjq.add(createU);
			bjq.add(deleteU);
			bjq.add(courseM);
		}
		setLayout(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==changeU) {
			String cz = JOptionPane.showInputDialog("(若要修改其他用户信息,需要记录你的账户)请输入你的学号:");
			UserDAO udao=new UserDAO();
			ArrayList<User> ArrayU=udao.list(cz);
            if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"请输入信息");
			}else if(ArrayU.isEmpty()){
				JOptionPane.showMessageDialog(null,"未找到该用户");
			}else if(!cz.equals(usr.getXh())){
				JOptionPane.showMessageDialog(null,"(若要修改其他用户信息,需要记录你的账户)请输入你的学号:");
			}else{
				new ChangeUserInfo(ArrayU.get(0));
	            bjq.remove(ai);
	            ai=new MW_C_AllInfo();
	            bjq.add(ai);
	            bjq.repaint();
	            bjq.validate();
			}
		}//修改用户
		
		else if(e.getSource()==createU) {
			cnu=new CreateNewUser();
			commitCreate=new JButton("确认添加");
			commitCreate.setBounds(314, 675, 220, 60);
			commitCreate.setFont(fnA);
			commitCreate.addActionListener(this);
			back=new JButton("返回");
			back.setBounds(554, 675, 220, 60);
			back.setFont(fnA);
			back.addActionListener(this);
			bjq.removeAll();
			bjq.add(cnu);
            bjq.add(commitCreate);
            bjq.add(back);
            bjq.repaint();
		}//创建新用户
		
		else if(e.getSource()==deleteU) {
			String cz = JOptionPane.showInputDialog("请输入你要删除的学号:");
			ScoreDAO sdao=new ScoreDAO();
			UserDAO udao=new UserDAO();
			ArrayList<User> ArrayU=udao.list(cz);
            if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"请输入信息");
			}else if(ArrayU.isEmpty()){
				JOptionPane.showMessageDialog(null,"未找到该用户");
			}else {
			sdao.delete(cz);//先删除此用户的成绩信息
			udao.delete(cz);//后删除此用户的所有信息
            bjq.remove(ai);
            ai=new MW_C_AllInfo();
            bjq.add(ai);
            bjq.repaint();
            bjq.validate();
			}
		}//删除用户
		
		else if(e.getSource()==courseM) {
			String cz = JOptionPane.showInputDialog("请输入你要查找的专业:");
			CourseDAO cdao=new CourseDAO();
			ArrayList<Course> ArrayC=cdao.list(cz);
            if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"请输入信息");
			}else if(ArrayC.isEmpty()){
				JOptionPane.showMessageDialog(null,"未找到该专业");
			}else{
				ct=new MW_C_CourseTable(cz);
				ct.jtbl.getSelectionModel().addListSelectionListener(this);
				ct.setBounds(10,10,1043,630);
				bjq.removeAll();
				changeCT=new JButton("修改");
				changeCT.setBounds(314, 675, 220, 60);
				changeCT.setFont(fnA);
				changeCT.addActionListener(this);
				back=new JButton("返回");
				back.setBounds(554, 675, 220, 60);
				back.setFont(fnA);
				back.addActionListener(this);
				flash=new JButton("刷新");
				flash.setBounds(794, 675, 100, 60);
				flash.setFont(fnA);
				flash.addActionListener(this);
	            bjq.add(ct);
	            bjq.add(changeCT);
	            bjq.add(back);
	            bjq.add(flash);
	            bjq.repaint();
	            bjq.validate();
	            ct.jtbl.updateUI();
			}
		}//课程管理
		else if(e.getSource()==changeCT) {
			Course c=new CourseDAO().list(ct.bt.getText()).get(0);
			new ChangeCourseTable(row,col,c,ct);
		}//修改课程按钮（在经过课程管理按钮之后的面板中添加）
		else if(e.getSource()==back) {
			bjq.removeAll();
			ai=new MW_C_AllInfo();
			bjq.add(ai);
			bjq.add(changeU);
			bjq.add(createU);
			bjq.add(deleteU);
			bjq.add(courseM);
			bjq.repaint();
	        bjq.validate();
		}//返回按钮（在经过课程管理或者添加用户按钮之后的面板中添加）
		else if(e.getSource()==commitCreate) {
			udao=new UserDAO();
	  		ScoreDAO sdao=new ScoreDAO();
	  		Score s ;
			u=cnu.getU();
			ArrayU=udao.list(u.getXh());
			if(u.xh.equals("")||u.xm.equals("")||u.yhm.equals("")||u.mm.equals("")||u.nl.equals("")||u.bj.equals("")||u.zy.equals("")||u.xy.equals("")||u.xb.equals("")||u.lb.equals("")) 
			{
				JOptionPane.showMessageDialog(null,"有必填项未填写");
			}else 	if(!ArrayU.isEmpty()) {
				JOptionPane.showMessageDialog(null,"已有该用户");
			}else {
				JOptionPane.showMessageDialog(null,"添加成功");
				udao.add(cnu.getU());
				s=new Score(u.getXh(),0,0,0,0,0,0,0,0,0,u.getBj(),u.getZy());
				sdao.add(s);
			}//在创建新用户的同时也将其成绩信息先全部初始化为0，以供日后修改
		}//确认创建新用户
		else if(e.getSource()==flash) {
			ct=new MW_C_CourseTable(ct.bt.getText());
			ct.jtbl.getSelectionModel().addListSelectionListener(this);
			ct.setBounds(10,10,1043,630);
			bjq.removeAll();
			changeCT=new JButton("修改");
			changeCT.setBounds(314, 675, 220, 60);
			changeCT.setFont(fnA);
			changeCT.addActionListener(this);
			back=new JButton("返回");
			back.setBounds(554, 675, 220, 60);
			back.setFont(fnA);
			back.addActionListener(this);
			flash=new JButton("刷新");
			flash.setBounds(794, 675, 100, 60);
			flash.setFont(fnA);
			flash.addActionListener(this);
            bjq.add(ct);
            bjq.add(changeCT);
            bjq.add(back);
            bjq.add(flash);
            bjq.repaint();
            bjq.validate();
		}//修改课程，在修改某单元格课程之后刷新表格
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		 row=ct.jtbl.getSelectedRow();
		 col=ct.jtbl.getSelectedColumn();
	}//用来获取当前选中单元格的行列值
}
