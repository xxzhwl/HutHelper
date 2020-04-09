package com.panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.DAO.ScoreDAO;
import com.entity.Score;
import com.entity.User;
import com.jframe.ScoreDetail;
/**
 * �������¡����û���Ϣ����ĳɼ�������壨JPanel��
 * @author Administrator
 * ���������һ������¼� ���Բ鿴��ɼ�����
 */
public class MW_D_Score extends JPanel implements ActionListener{
	public JPanel pbt,pnr;
	public JLabel lbt;
	public JLabel[] lcj;
	public JProgressBar[] pb; //������ 
	public JButton scoretable;
	public ScoreDetail sd;
	public Font fnA = new Font("΢���ź�",Font.PLAIN,24);
	String[] scj;
	int[] cj=null;
	ScoreDAO sdao;
	ArrayList<Score> arrayS;
	Score s;
	User u;
	public MW_D_Score(User us) {
		u=us;
		pbt=new JPanel();
		pnr=new JPanel();
		lbt=new JLabel("�ɼ�����");
		lbt.setFont(fnA);
		lbt.setForeground(Color.WHITE);		
		pbt.setBounds(0, 0, 540, 50);
		pnr.setBounds(0, 50, 540, 715);
		pnr.setBackground(Color.WHITE);
		pnr.setLayout(null);
		sdao=new ScoreDAO();
		arrayS=sdao.list(us.getXh());
		if(!arrayS.isEmpty()) {
			s=arrayS.get(0);
			cj=s.getA();
			scj=s.getB();
			lcj=new JLabel[cj.length];
	        pb = new JProgressBar [cj.length];
	        scoretable=new JButton("�ɼ�����");
			scoretable.setBounds(320, 545, 220, 120);
			scoretable.setFont(fnA);
			for(int i=0;i<cj.length;i++) {
				lcj[i]=new JLabel();
				lcj[i].setText(scj[i]);
				lcj[i].setBounds(3, 3+(i*67), 147, 60);
				lcj[i].setFont(fnA);
				lcj[i].setForeground(Color.WHITE);
				pb[i]=new JProgressBar();
				pb[i].setMaximum(100);
			    pb[i].setValue(cj[i]);
			    pb[i].setStringPainted(true);
			    pb[i].setBounds(150,3+(i*67), 380, 60);//�Խ�������ʽչʾ�ɼ�����״��
			    pnr.add(lcj[i]);
			    pnr.add(pb[i]); 
			}
			    pnr.add(scoretable);
			    scoretable.addActionListener(this);
		        pnr.setBackground(null);
		        pnr.setOpaque(false);
		}else {
			JLabel x=new JLabel("Ŀǰ�޳ɼ���Ϣ");
			x.setBounds(170, 10, 300, 300);
			x.setFont(fnA);
			x.setForeground(Color.BLACK);
			pnr.add(x); 
		}
		pbt.add(lbt);
        pbt.setBackground(null);  
        pbt.setOpaque(false);
		add(pbt);
		add(pnr);
		setLayout(null);
		setBounds(500,5,540,715);
		setBackground(null);  
        setOpaque(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		sd=new ScoreDetail(u.getXh());
		sd.ss.jtbl.setEnabled(false);
	}
}
