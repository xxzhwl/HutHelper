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
 * �������¡���������Ϣ��壨��ͨ�û���/�ɼ���������Ա��
 * @author Administrator
 * �û������£�һ��MW_D_Info�ĸ��˻�����Ϣ��� һ��MW_D_Score ���˳ɼ��������  һ���޸Ļ�����Ϣ�İ�ť 
 * ����Ա�����£�һ��MW_D_ScoreBt�ĳɼ���Ϣ�������
 */
public class MW_Detail extends JPanel implements ActionListener{
		public JLabel bjq;
		public MW_D_Info mwdi;
		public MW_D_Score mwds;
		public ImageIcon bji;
		public JButton change;
		public Font fnA = new Font("΢���ź�",Font.PLAIN,24);
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
		if(u.getLb().equals("��ͨ�û�")) {
			mwdi=new MW_D_Info(u,m);
			bjq.add(mwdi);
			mwds=new MW_D_Score(u);
			change=new JButton("�޸�����");
			change.setBounds(10, 600, 220, 120);
			change.setFont(fnA);
			change.addActionListener(this);
			bjq.add(mwds);
			bjq.add(change);
		}else if(u.getLb().equals("����Ա")) {
			sb=new MW_D_ScoreBt();
			bjq.add(sb);
		}
			
		}
			@Override
			public void actionPerformed(ActionEvent e) {			
				JOptionPane.showMessageDialog(null,"�������޸��û������Ա��ֻ����룬���������ϣ������������ҹ���Ա�����޸�");
					new ChangeUserInfo(u);
					bjq.remove(mwdi);
					mwdi=new MW_D_Info(u,m);
					bjq.add(mwdi);
		            bjq.repaint();
		            bjq.validate();
				}			
}
