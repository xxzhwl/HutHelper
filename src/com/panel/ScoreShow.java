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
 * �ɼ�չʾ���
 * @author Administrator
 * ���û��鿴���˳ɼ�ʱ�� ʹ���˴��� 
 * ������Ա�������гɼ���Ϣʱ��Ҳʹ���˴���
 */
public class ScoreShow extends JPanel {
	public String[] bt2=Constant.scoreO;
	public Font fnA = new Font("΢���ź�",Font.PLAIN,18);
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
	}//����ѧԺ+רҵ��ȡĳ��רҵ�����гɼ���Ϣ  ���ܳɼ�����
	
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
	}//����ѧԺ+רҵ+�༶��ȡĳ��������гɼ���Ϣ ���ܳɼ�����

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
	}//���ݾ���ѧ�Ż�ȡĳ���û������гɼ���Ϣ 

}
