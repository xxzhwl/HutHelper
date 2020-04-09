package com.panel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.DAO.ScoreDAO;
import com.DAO.UserDAO;
import com.entity.Score;
import com.entity.User;
import com.model.OneScoreTableModel;
import com.model.ScoreTableModel;
import com.values.Constant;
/**
 * 成绩展示面板
 * @author Administrator
 * 当用户查看个人成绩时候 使用了此类 
 * 当管理员管理所有成绩信息时候也使用了此类
 */
public class ScoreShow extends JPanel {
	public String[] bt2=Constant.scoreO;
	public Font fnA = new Font("微软雅黑",Font.PLAIN,18);
	public JScrollPane jspPanel;
	public JTable jtbl;
	public User ur;
	ScoreTableModel tm;
	OneScoreTableModel ostm;
	Score s;
	public ScoreShow() { 
		   }
	public ScoreShow(String zy) {
	tm=new ScoreTableModel();
	tm.sArray=new ScoreDAO().listByMajor(zy);
    jtbl=new JTable(tm);
	jtbl.setRowHeight(50);
	jtbl.setFont(fnA);
	jspPanel=new JScrollPane(jtbl);
	jspPanel.setBounds(0, 0, 1000, 700);
	setLayout(null);
	add(jspPanel);
	}//根据学院+专业获取某个专业的所有成绩信息  按总成绩排名
	
	public ScoreShow(String zy,String bj) {
	tm=new ScoreTableModel();
	tm.sArray=new ScoreDAO().listByClass(zy, bj);
    jtbl=new JTable(tm);
	jtbl.setRowHeight(50);
	jtbl.setFont(fnA);
	jspPanel=new JScrollPane(jtbl);
	jspPanel.setBounds(0, 0, 1000, 700);
	setLayout(null);
	add(jspPanel);
	}//根据学院+专业+班级获取某个班的所有成绩信息 按总成绩排名

	public ScoreShow(User u) {
	ostm=new OneScoreTableModel();
	ostm.sArray=new ScoreDAO().list(u.getXh());
	jtbl=new JTable(ostm);
	jtbl.setRowHeight(50);
	jtbl.setFont(fnA);
	jspPanel=new JScrollPane(jtbl);
	jspPanel.setBounds(0, 0, 1040, 680);
	setLayout(null);
	add(jspPanel);
	}//根据具体学号获取某个用户的所有成绩信息 

}
