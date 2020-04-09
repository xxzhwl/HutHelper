package com.jframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.DAO.ScoreDAO;
import com.entity.Score;
import com.panel.MW_D_ScoreBt;
/**
 * 修改成绩类(JDialog类窗口)
 * @author Administrator
 *各类组件及监听事件
 */
public class ChangeScore extends JDialog implements ActionListener{
	 JLabel lbjava,lbc,lboracle,lbcpp,lbmzdsx,lbjsjwl,lbczxt;
	 JTextField[] cj;
	 JPanel jp;
	 JButton commit,clear;
	 ScoreDAO sdao;
	 Score sr;
	 int sum=0;
	 MW_D_ScoreBt mwds;
	 private Font fnA = new Font("微软雅黑",Font.PLAIN,18);
	 public ChangeScore(Score s,MW_D_ScoreBt sbt) {
		 sr=s;
		 mwds=sbt;
		 setLayout(null);
		 jp=new JPanel();
		 lbjava=new JLabel("java成绩：");
		 lbc=new JLabel("c语言成绩：");
		 lboracle=new JLabel("Oracle成绩：");
		 lbcpp=new JLabel("C++成绩：");
		 lbmzdsx=new JLabel("毛泽东思想成绩：");
		 lbjsjwl=new JLabel("计算机网络成绩：");
		 lbczxt=new JLabel("操作系统成绩：");
		 commit=new JButton("确认修改");
		 clear=new JButton("清空数据");				 
		 lbjava.setBounds(10,10,150,30);
		 lbc.setBounds(10,60,150,30);
		 lboracle.setBounds(10,110,150,30);
		 lbcpp.setBounds(10,160,150,30);
		 lbmzdsx.setBounds(10,210,150,30);
		 lbjsjwl.setBounds(10,260,150,30);
		 lbczxt.setBounds(10,310,150,30);
		 lbjava.setFont(fnA);
		 lbc.setFont(fnA);
		 lboracle.setFont(fnA);
		 lbcpp.setFont(fnA);
		 lbmzdsx.setFont(fnA);
		 lbjsjwl.setFont(fnA);
		 lbczxt.setFont(fnA);
		 commit.setBounds(410, 70,130, 60);
		 clear.setBounds(410, 215, 130, 60);
		 cj=new JTextField[7];
		 for(int i=0;i<cj.length;i++) {
			 cj[i]=new JTextField();
			 cj[i].setBounds(160, 10+50*i, 150, 30);
			 cj[i].setFont(fnA);
			 add(cj[i]);
		 }
		 cj[0].setText(String.valueOf(s.getJava()));
		 cj[1].setText(String.valueOf(s.getC()));
		 cj[2].setText(String.valueOf(s.getOracle()));
		 cj[3].setText(String.valueOf(s.getCpp()));
		 cj[4].setText(String.valueOf(s.getMzdsx()));
		 cj[5].setText(String.valueOf(s.getJsjwl()));
		 cj[6].setText(String.valueOf(s.getCzxt()));
		 
		 jp.setLayout(null);
		 jp.setBounds(0, 0, 600, 400);
		 add(jp);
		 jp.add(lbjava);
		 jp.add(lbc);
		 jp.add(lboracle);
		 jp.add(lbcpp);
		 jp.add(lbmzdsx);
		 jp.add(lbjsjwl);
		 jp.add(lbczxt);
		 jp.add(commit);
		 jp.add(clear);
		 commit.addActionListener(this);
		 clear.addActionListener(this);
		 setVisible(true);
		 setResizable(false);
		 setBounds(400,400,600,400);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		sdao=new ScoreDAO();
		boolean flag=true;
		if(e.getSource()==commit) {
			for(int i=0;i<cj.length;i++) {
				if(Integer.parseInt(cj[i].getText())>100||Integer.parseInt(cj[i].getText())<0){
					JOptionPane.showMessageDialog(null, "成绩应大于等于0小于等于100");
					flag=false;
				}
			}
			while(flag) {
			sr.setJava(Integer.parseInt(cj[0].getText()));
			sr.setC(Integer.parseInt(cj[1].getText()));
			sr.setOracle(Integer.parseInt(cj[2].getText()));
			sr.setCpp(Integer.parseInt(cj[3].getText()));
			sr.setMzdsx(Integer.parseInt(cj[4].getText()));
			sr.setJsjwl(Integer.parseInt(cj[5].getText()));
			sr.setCzxt(Integer.parseInt(cj[6].getText()));
			sum=sr.getJava()+sr.getC()+sr.getOracle()+sr.getCpp()+sr.getMzdsx()+sr.getJsjwl()+sr.getCzxt();
			sr.setSumS(sum);
			sr.setAvgS(sum/7);
			flag=false;
			}
			sdao.update(sr);
			dispose();
			mwds.ss.jtbl.updateUI();
		}//用来确认修改成绩信息
		
		else if(e.getSource()==clear) {
			for(int i=0;i<cj.length;i++) {
				jp.remove(cj[i]);
				cj[i]=new JTextField();
				cj[i].setBounds(160, 10+50*i, 150, 30);
				cj[i].setFont(fnA);
				cj[i].setText("");
				jp.add(cj[i]);
			 }
			jp.repaint();
			jp.validate();
		}//用来清空当前用户所有成绩信息
	}
}
