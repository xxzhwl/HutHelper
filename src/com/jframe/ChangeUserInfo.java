package com.jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import com.panel.CreateNewUser;
import com.values.Constant;
import com.DAO.UserDAO;
import com.entity.*;

/**
 * 修改个人信息类（JDialog类窗口）
 * @author Administrator
 *拥有各类组件及监听事件 ，分不同类别用户访问时展示的界面也不同
 */

public class ChangeUserInfo extends JDialog implements ActionListener{
	public JLabel lyhm,lxb,lsjhm,lshow,bjq,lnl;
	public String yhm,sql,xb,sjhm,show,nl;
	public JTextField tyhm,tsjhm;
	public JTextArea tshow;
	public JComboBox jxb,jnl; 
	public ImageIcon bji;
	public JButton commit,commit2;
	public Font fnA = new Font("微软雅黑",Font.PLAIN,24);
	public String[] age;
	public String s;
	public User u;
	UserDAO udao;
	CreateNewUser cnu;
	ArrayList<User> ArrayU;
	public ChangeUserInfo(User us) {
		setModal(true);//设置模态
		u=us;
		bji=new ImageIcon("pic/1.jpg");
		bjq=new JLabel(bji);
		bjq.setLayout(null);
		
		if(u.lb.equals("普通用户")) {
			sjhm=u.getSjhm();
			yhm=u.getYhm();
			show=u.getMs();
			age=new String[100];
			for(int i=0;i<100;i++) {
				age[i]=String.valueOf(i);
			}
			setBounds(700,400,500,600);
			lyhm=new JLabel("用户名:");
			lyhm.setBounds(10,10,100,30);
			lyhm.setForeground(Color.WHITE);
			lyhm.setFont(fnA);
			tyhm=new JTextField(yhm);
			tyhm.setBounds(120, 10,300, 30);
			tyhm.setForeground(Color.BLACK);
			tyhm.setFont(fnA);
			lsjhm=new JLabel("手   机:");
			lsjhm.setBounds(10,215,100,30);
			lsjhm.setForeground(Color.WHITE);
			lsjhm.setFont(fnA);
			tsjhm=new JTextField(sjhm);
			tsjhm.setBounds(120, 215, 300,30); 
			tsjhm.setForeground(Color.BLACK);
			tsjhm.setFont(fnA);	
			lnl=new JLabel("年   龄:");
			lnl.setBounds(10,140,100,30);    
			lnl.setForeground(Color.WHITE);
			lnl.setFont(fnA);
			jnl=new JComboBox(age);
			jnl.setSelectedItem(u.getNl());
			jnl.setBounds(120,140,300,30); 
			jnl.setForeground(Color.BLACK);
			jnl.setFont(fnA);
			lxb=new JLabel("性   别:");
			lxb.setBounds(10,75,100,30);
			lxb.setForeground(Color.WHITE);
			lxb.setFont(fnA);
			jxb=new JComboBox(Constant.sex);
			jxb.setSelectedItem(u.getXb());
			jxb.setBounds(120, 75, 300,30);
			jxb.setForeground(Color.BLACK);
			jxb.setFont(fnA);
			lshow=new JLabel("描   述:");
			lshow.setBounds(10,290,100,30);
			lshow.setForeground(Color.WHITE);
			lshow.setFont(fnA);
			tshow=new JTextArea();
			tshow.setText(show);
			tshow.setBounds(120,290,300,100);
			tshow.setForeground(Color.BLACK);
			tshow.setFont(fnA);
			tshow.setLineWrap(true);
			commit=new JButton("提交");
			commit.setFont(fnA);
			bjq.add(lyhm);
			bjq.add(tyhm);
			bjq.add(lxb);
			bjq.add(jxb);
			bjq.add(lsjhm);
			bjq.add(tsjhm);
			bjq.add(lshow);
			bjq.add(tshow);
			bjq.add(lnl);
			bjq.add(jnl);
			add(commit,BorderLayout.SOUTH);
			commit.addActionListener(this);
		}//如果是普通用户访问当前页面，则只允许修改部分信息
		
		else if(u.lb.equals("管理员")){
			String cz = JOptionPane.showInputDialog("请输入你要修改的学号:");
			s=cz;
			udao=new UserDAO();
			ArrayList<User> ArrayU=udao.list(cz);
			if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"请输入信息");
			}else if(ArrayU.isEmpty()){
				JOptionPane.showMessageDialog(null,"未找到该用户");}
				else {
					commit2=new JButton("提交");
					commit2.setFont(fnA);			
					setBounds(700,400,1000,800);
					u=udao.get(cz);
					cnu=new CreateNewUser();
					cnu.jtfs[0].setText(u.xh);
					cnu.jtfs[1].setText(u.xm);
					cnu.jtfs[2].setText(u.yhm);
					cnu.jtfs[3].setText(u.mm);
					cnu.jtfs[4].setText(u.sjhm);
					cnu.jcbs[0].setSelectedItem(u.nl);
					cnu.jcbs[1].setSelectedItem(u.bj);
					cnu.jcbs[2].setSelectedItem(u.xy);
					cnu.jcbs[3].setSelectedItem(u.zy);
					cnu.jcbs[4].setSelectedItem(u.xb);
					cnu.jcbs[5].setSelectedItem(u.lb);
					cnu.jtams.setText(u.getMs());
					bjq.add(cnu);
					add(commit2,BorderLayout.SOUTH);
					commit2.addActionListener(this);
				}
		}//如果是管理员访问当前页面，则允许修改几乎所有信息
		add(bjq);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==commit) {
			 yhm=tyhm.getText();
			 sjhm=tsjhm.getText();
			 xb=jxb.getSelectedItem().toString();
			 show=tshow.getText();
			 nl=jnl.getSelectedItem().toString();
			 udao=new UserDAO();
			 u.setYhm(yhm);
			 u.setSjhm(sjhm);
			 u.setXb(xb);
			 u.setMs(show);
			 u.setNl(nl);
			 udao.updateM(u);
			 JOptionPane.showMessageDialog(null,"修改成功");
		}//普通用户确认修改
		else if(e.getSource()==commit2){
			udao=new UserDAO();
			u=cnu.getU();
			u.setTx(udao.get(s).getTx());
			ArrayU=udao.list(u.getXh());
			if(u.xh.equals("")||u.xm.equals("")||u.yhm.equals("")||u.mm.equals("")||u.nl.equals("")||u.bj.equals("")||u.zy.equals("")||u.xy.equals("")||u.xb.equals("")||u.lb.equals("")) {
				JOptionPane.showMessageDialog(null,"有必填项未填写");
			}else {
				udao.updateM(u);
				JOptionPane.showMessageDialog(null,"修改成功");
				
			}
		}//管理员确认修改

	}	
}
