package com.panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.entity.User;
import com.jframe.ChangeUserInfo;
import com.jframe.MainWindow;
import com.jframe.ScoreDetail;
/**
 * 主窗口下——个人信息面板（普通用户）/成绩管理（管理员）
 * @author Administrator
 * 用户界面下：一个MW_D_Info的个人基本信息面板 一个MW_D_Score 个人成绩概览面板  一个修改基本信息的按钮 
 * 管理员界面下：一个MW_D_ScoreBt的成绩信息管理面板
 */
public class MW_Detail extends JPanel implements ActionListener{
		public JLabel bjq;
		public MW_D_Info mwdi;
		public MW_D_Score mwds;
		public ImageIcon bji;
		public JButton change;
		public Font fnA = new Font("微软雅黑",Font.PLAIN,24);
		public MW_D_ScoreBt sb;
		User u;
		MainWindow m;
		public MW_Detail(User us,MainWindow mw) {
			setLayout(null);
			u=us;
			m=mw;
			bji=new ImageIcon("pic/1.png");
			bjq=new JLabel(bji);
			bjq.setBounds(0, 0,bji.getIconWidth(),bji.getIconHeight());
			add(bjq);
		if(u.getLb().equals("普通用户")) {
			mwdi=new MW_D_Info(u,m);
			bjq.add(mwdi);
			mwds=new MW_D_Score(u);
			change=new JButton("修改资料");
			change.setBounds(10, 600, 220, 120);
			change.setFont(fnA);
			change.addActionListener(this);
			bjq.add(mwds);
			bjq.add(change);
		}else if(u.getLb().equals("管理员")) {
			sb=new MW_D_ScoreBt();
			bjq.add(sb);
		}
			
		}
			@Override
			public void actionPerformed(ActionEvent e) {			
				JOptionPane.showMessageDialog(null,"您仅可修改用户名，性别，手机号码，描述的资料，其余资料请找管理员进行修改");
					new ChangeUserInfo(u);
					bjq.remove(mwdi);
					mwdi=new MW_D_Info(u,m);
					bjq.add(mwdi);
		            bjq.repaint();
		            bjq.validate();
				}			
}
