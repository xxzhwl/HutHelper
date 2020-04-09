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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.DAO.ScoreDAO;
import com.DAO.UserDAO;
import com.entity.Score;
import com.entity.User;
import com.jframe.ChangeScore;
import com.jframe.ScoreDetail;
import com.values.Constant;
/**
 * 主窗口下——管理员管理成绩类（JPanel）
 * @author Administrator
 * 各个组件及监听事件
 * 可以根据学院+专业获取某个专业的所有成绩信息  按总成绩排名
 * 可以根据学院+专业+班级获取某个班的所有成绩信息 按总成绩排名
 * 可以根据具体学号获取某个用户的所有成绩信息 
 */
public class MW_D_ScoreBt extends JPanel implements ItemListener,ActionListener,ListSelectionListener{
	public  JLabel xy,zy,bj,xh;
	public  JTextField txh;
	public  JButton  commit,change;
	public  JPanel   nr;
	public  ScoreShow ss;
	public  JComboBox<String> jcbnl,jcbbj,jcbzy,jcbxy,jcbxb,jcblb;
	public  Font fnA = new Font("微软雅黑",Font.PLAIN,15);
	public	DefaultComboBoxModel CSTzy = new DefaultComboBoxModel(Constant.zy1);
	public	DefaultComboBoxModel EAEzy = new DefaultComboBoxModel(Constant.zy2);
	Score   s;
	public MW_D_ScoreBt() {
		xy=new JLabel("学院：");
		zy=new JLabel("专业：");
		bj=new JLabel("班级：");
		xh=new JLabel("学号：");
		change=new JButton("修改");
		commit=new JButton("查询");
		jcbxy=new JComboBox<String>(Constant.xy);
		jcbzy=new JComboBox<String>(Constant.zy1);
		jcbbj=new JComboBox<String>(Constant.bj);	
		txh=new JTextField();
		xy.setBounds(30, 10, 50, 30);
		xy.setFont(fnA);
		xy.setForeground(Color.WHITE);
		jcbxy.setBounds(80, 10,130, 30);	
		zy.setBounds(215, 10, 50, 30);
		zy.setFont(fnA);
		zy.setForeground(Color.WHITE);
		jcbzy.setBounds(265, 10, 130, 30);
		bj.setBounds(400, 10, 50, 30);
		bj.setFont(fnA);
		bj.setForeground(Color.WHITE);
		jcbbj.setBounds(455, 10, 130, 30);
		xh.setBounds(590, 10, 50, 30);
		xh.setFont(fnA);
		xh.setForeground(Color.WHITE);
		txh.setBounds(640, 10, 130, 30);
		commit.setBounds(790, 10, 80, 30);
		commit.setFont(fnA);
		change.setBounds(880, 10, 80, 30);
		nr=new JPanel();
		nr.setLayout(null);
		nr.setBackground(null);
		nr.setOpaque(false);
		ss=new ScoreShow();
		nr.add(ss);
		ss.setBackground(null);
		ss.setOpaque(false);
		nr.setBounds(5, 45, 1040, 680);
		ss.setBounds(5, 0, 1040, 680);
		add(xy);
		add(zy);
		add(bj);
		add(xh);
		add(jcbxy);
		add(jcbzy);
		add(jcbbj);
		add(txh);
		add(commit);
		add(change);
		add(nr);
		commit.addActionListener(this);
		change.addActionListener(this);
		jcbxy.addItemListener(this);
		setBounds(5,0,1050,740);
		setLayout(null);
		setBackground(null);
		setOpaque(false);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jcbxy) {
			if(jcbxy.getSelectedItem().equals("计算机学院")) {
				jcbzy.setModel(CSTzy);
			}else if(jcbxy.getSelectedItem().equals("电气学院")) {
				jcbzy.setModel(EAEzy);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int row=ss.jtbl.getSelectedRow();
		try{s=ss.tm.sArray.get(row);
				}
		catch(NullPointerException ee) {
			s=ss.ostm.sArray.get(row);
		};
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==commit) {
			String x,y,z,o;
			x=(String) jcbxy.getSelectedItem();
			y=(String) jcbzy.getSelectedItem();
			z=(String) jcbbj.getSelectedItem();
			o=txh.getText();
			if(x.equals("")&&o.equals("")&&y.equals("")&&z.equals("")) {
				JOptionPane.showMessageDialog(null,"至少填入专业信息或学号进行查询");
			}else	if(!o.equals("")) {
				UserDAO udao=new UserDAO();
				ss=new ScoreShow(udao.get(o));
				ss.jtbl.getSelectionModel().addListSelectionListener(this);
			}else if(!x.equals("")&&o.equals("")&&y.equals("")) {
				JOptionPane.showMessageDialog(null,"至少填入专业信息进行查询");
			}
			else if(!y.equals("")&&o.equals("")&&z.equals("")) {
				ss=new ScoreShow(y);
				ss.jtbl.getSelectionModel().addListSelectionListener(this);
			}
			else if(!y.equals("")&&o.equals("")&&!z.equals("")) {
				ss=new ScoreShow(y,z);
				ss.jtbl.getSelectionModel().addListSelectionListener(this);
			}
			nr.removeAll();
			nr.add(ss);
			ss.setBounds(5, 0, 1040, 680);
			ss.repaint();
			ss.validate();
		}else if(e.getSource()==change) {
			if(s==null) {
				JOptionPane.showMessageDialog(null,"请选中行");
			}else {
			ChangeScore cs=new ChangeScore(s,this);
			}
		}
	}
}
