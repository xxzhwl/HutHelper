package com.jframe;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.DAO.ScoreDAO;
import com.DAO.UserDAO;
import com.entity.Score;
import com.panel.ScoreShow;
/**
 * 成绩总览（JDialog类）
 * @author Administrator
 * 各项组件
 */
public class ScoreDetail extends JDialog{
	public Font fnA = new Font("微软雅黑",Font.PLAIN,18);
	public JPanel pbt,pnr;
	public JLabel lbt;
	public ScoreShow ss;
	public ScoreDetail(String id) {
		setModal(true);
		setBounds(500,10,1055,400);
		UserDAO uDAO=new UserDAO();
		ss=new ScoreShow(uDAO.get(id));
		ss.setBounds(0,0,1055,400);
		ss.jtbl.setEnabled(false);
		pbt=new JPanel();
		pnr=new JPanel();
		lbt=new JLabel("成绩");
		lbt.setFont(fnA);
		add(pbt,BorderLayout.NORTH);
		add(pnr);
		pbt.add(lbt);
		pnr.setLayout(null);
		pnr.add(ss);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
