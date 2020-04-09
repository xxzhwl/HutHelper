package com.panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.DAO.ScoreDAO;
import com.DAO.UserDAO;
import com.entity.Score;
import com.entity.User;
import com.values.Constant;
/**
 * 创建新用户类（JPanel类）
 * @author Administrator
 * 各个组件及监听事件
 */
public class CreateNewUser extends JPanel implements ItemListener{
	public  JLabel[] xx;
	public  String[] sxx=Constant.stu;
	public  JComboBox<String> jcbnl,jcbbj,jcbzy,jcbxy,jcbxb,jcblb;
	public  JComboBox<String>[] jcbs;
	public  JTextField[] jtfs;
	public  JTextArea jtams;
	public  String[] age;
	public  Font fnA = new Font("微软雅黑",Font.PLAIN,24);
			DefaultComboBoxModel CSTzy = new DefaultComboBoxModel(Constant.zy1);
			DefaultComboBoxModel EAEzy = new DefaultComboBoxModel(Constant.zy2);
	  		UserDAO udao;
	  		User u;	  		
	public CreateNewUser() {
		udao=new UserDAO();
		xx=new JLabel[sxx.length];

		for(int i=0;i<sxx.length;i++) {
			xx[i]=new JLabel(sxx[i]+"*");
			xx[i].setBounds(0,50*i, 100,45);
			xx[i].setFont(fnA);
			xx[i].setForeground(Color.WHITE);
			add(xx[i]);
		}
		xx[4].setText(sxx[4]);
		xx[11].setText(sxx[11]);
		
		age=new String[101];
		age[0]="";
		for(int i=1;i<100;i++) {
			age[i]=String.valueOf(i);
		}
		
		jcbnl=new JComboBox<String>(age);
		jcbxy=new JComboBox<String>(Constant.xy);
		jcbzy=new JComboBox<String>(Constant.zy1);
		jcbbj=new JComboBox<String>(Constant.bj);		
		jcbxb=new JComboBox<String>(Constant.sex);
		jcblb=new JComboBox<String>(Constant.slb);
		jcbs =new JComboBox[] {jcbnl,jcbbj,jcbxy,jcbzy,jcbxb,jcblb};
		for(int i=0;i<jcbs.length;i++) {
			jcbs[i].setBounds(130,50*i+260, 300,40);
			add(jcbs[i]);
		}
		
		jtfs=new JTextField[sxx.length-jcbs.length-1];
		for(int i=0;i<jtfs.length;i++) {
			jtfs[i]=new JTextField();
			jtfs[i].setBounds(130,50*i,300,40);
			add(jtfs[i]);
		}
		jtams=new JTextArea();
		jtams.setBounds(130, 560, 300, 100);
		jcbs[2].addItemListener(this);
		
		add(jtams);
		setLayout(null);
		setBackground(null);  
		setBounds(10,10,1040,800);		
        setOpaque(false);
	}
	public User getU() {
		u=new User();
		u.setXh(jtfs[0].getText());
		u.setXm(jtfs[1].getText());
		u.setYhm(jtfs[2].getText());
		u.setMm(jtfs[3].getText());
		u.setSjhm(jtfs[4].getText());
		u.setNl((String)jcbs[0].getSelectedItem());
		u.setBj((String)jcbs[1].getSelectedItem());
		u.setXy((String)jcbs[2].getSelectedItem());
		u.setZy((String)jcbs[3].getSelectedItem());
		u.setXb((String)jcbs[4].getSelectedItem());
		u.setLb((String)jcbs[5].getSelectedItem());
		u.setMs(jtams.getText());
		return u;
	}//用来获取当前创建新用户的所有信息
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jcbs[2]) {
			if(jcbs[2].getSelectedItem().equals("计算机学院")) {
				jcbs[3].setModel(CSTzy);
			}else if(jcbs[2].getSelectedItem().equals("电气学院")) {
				jcbs[3].setModel(EAEzy);
			}
		}//将学院列表与专业列表级联
	}
}
