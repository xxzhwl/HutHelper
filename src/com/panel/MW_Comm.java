package com.panel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jframe.*;
import com.DAO.*;
import com.entity.*;
/**
 * �������¡����γ̱��û����棩/��Ϣ��������Ա���棩 ��JPanel��
 * @author Administrator
 * �û������£�������һ���γ̱� �޷��޸� 
 * ����Ա�����£�1.չʾ������ͨ�û��Ļ�����Ϣ 2.�����û����޸��û���ɾ���û����γ̹����Ĵ�ť
 * �������û�ʱ ������Ƴ����е�ǰ���������CreateNewUser��Ķ����Լ�ȷ����Ӻͷ��صİ�ť��
 * ���޸��û��� ����Ա�������Լ���xh����֤ Ȼ������Ҫ������Ϣ���û�xh Ȼ�󵯳�ChangeUserInfo��һ������ �����޸�
 * ��ɾ���û�ʱ ������Ҫɾ�����û�xh��ɾ���û���������Ϣ�Լ���γ���Ϣ
 * ���γ̹���ʱ ����һ��רҵ�� �Ƴ����е�ǰ���������MW_C_CourseTable��һ����� �Լ�һ���޸İ�ť��һ�����ذ�ť��һ��ˢ�°�ť
 */
public class MW_Comm extends JPanel implements ActionListener,ListSelectionListener{
	public JLabel bjq;                                                              //����ǽ
	public ImageIcon bji;                                                           //����ͼƬ
	public JButton createU,changeU,deleteU,courseM,changeCT,back,flash,commitCreate;//���а�ť
	public MW_C_AllInfo ai;                                                         //�����û���Ϣ�����
	public Font fnA = new Font("΢���ź�",Font.PLAIN,24);                             //������ʽ
	public MW_C_CourseTable ct;                                                     //�γ̱����
	public CreateNewUser cnu;                                                       //�����û����
		   User u,usr;
		   UserDAO udao;
		   ArrayList<User> ArrayU;
		   int row,col;
	public MW_Comm(User us) {
		usr=us;
		ai=new MW_C_AllInfo();
		bji=new ImageIcon("pic/1.png");
		bjq=new JLabel(bji);
		bjq.setBounds(0, 0,bji.getIconWidth(),bji.getIconHeight());
		add(bjq);
		if(us.getLb().equals("��ͨ�û�")) {
			UserDAO udao=new UserDAO();
			User u=new User();
			u=udao.list(us.getXh()).get(0);
			String zy=u.getZy();
			ct=new MW_C_CourseTable(zy);
			ct.setBounds(10,10,1043,730);
			bjq.add(ct);
			ct.jtbl.setEnabled(false);                                               //�û������£�������һ���γ̱� �޷��޸� 
		}else {
			bjq.add(ai);
			changeU=new JButton("�޸��û�");
			changeU.setBounds(800, 100, 245, 120);		
			createU=new JButton("�����û�");
			createU.setBounds(800, 250, 245, 120);				
			deleteU=new JButton("ɾ���û�");
			deleteU.setBounds(800, 400, 245, 120);
			courseM=new JButton("�α����");
			courseM.setBounds(800, 550, 245, 120);
			changeU.setFont(fnA);
			createU.setFont(fnA);
			deleteU.setFont(fnA);
			courseM.setFont(fnA);
			changeU.addActionListener(this);
			createU.addActionListener(this);
			deleteU.addActionListener(this);
			courseM.addActionListener(this);
			bjq.add(changeU);
			bjq.add(createU);
			bjq.add(deleteU);
			bjq.add(courseM);
		}
		setLayout(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==changeU) {
			String cz = JOptionPane.showInputDialog("(��Ҫ�޸������û���Ϣ,��Ҫ��¼����˻�)���������ѧ��:");
			UserDAO udao=new UserDAO();
			ArrayList<User> ArrayU=udao.list(cz);
            if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"��������Ϣ");
			}else if(ArrayU.isEmpty()){
				JOptionPane.showMessageDialog(null,"δ�ҵ����û�");
			}else if(!cz.equals(usr.getXh())){
				JOptionPane.showMessageDialog(null,"(��Ҫ�޸������û���Ϣ,��Ҫ��¼����˻�)���������ѧ��:");
			}else{
				new ChangeUserInfo(ArrayU.get(0));
	            bjq.remove(ai);
	            ai=new MW_C_AllInfo();
	            bjq.add(ai);
	            bjq.repaint();
	            bjq.validate();
			}
		}//�޸��û�
		
		else if(e.getSource()==createU) {
			cnu=new CreateNewUser();
			commitCreate=new JButton("ȷ�����");
			commitCreate.setBounds(314, 675, 220, 60);
			commitCreate.setFont(fnA);
			commitCreate.addActionListener(this);
			back=new JButton("����");
			back.setBounds(554, 675, 220, 60);
			back.setFont(fnA);
			back.addActionListener(this);
			bjq.removeAll();
			bjq.add(cnu);
            bjq.add(commitCreate);
            bjq.add(back);
            bjq.repaint();
		}//�������û�
		
		else if(e.getSource()==deleteU) {
			String cz = JOptionPane.showInputDialog("��������Ҫɾ����ѧ��:");
			ScoreDAO sdao=new ScoreDAO();
			UserDAO udao=new UserDAO();
			ArrayList<User> ArrayU=udao.list(cz);
            if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"��������Ϣ");
			}else if(ArrayU.isEmpty()){
				JOptionPane.showMessageDialog(null,"δ�ҵ����û�");
			}else {
			sdao.delete(cz);//��ɾ�����û��ĳɼ���Ϣ
			udao.delete(cz);//��ɾ�����û���������Ϣ
            bjq.remove(ai);
            ai=new MW_C_AllInfo();
            bjq.add(ai);
            bjq.repaint();
            bjq.validate();
			}
		}//ɾ���û�
		
		else if(e.getSource()==courseM) {
			String cz = JOptionPane.showInputDialog("��������Ҫ���ҵ�רҵ:");
			CourseDAO cdao=new CourseDAO();
			ArrayList<Course> ArrayC=cdao.list(cz);
            if(cz== null)
            {
               return;
            }else if(cz.isEmpty()) {
				 JOptionPane.showMessageDialog(null,"��������Ϣ");
			}else if(ArrayC.isEmpty()){
				JOptionPane.showMessageDialog(null,"δ�ҵ���רҵ");
			}else{
				ct=new MW_C_CourseTable(cz);
				ct.jtbl.getSelectionModel().addListSelectionListener(this);
				ct.setBounds(10,10,1043,630);
				bjq.removeAll();
				changeCT=new JButton("�޸�");
				changeCT.setBounds(314, 675, 220, 60);
				changeCT.setFont(fnA);
				changeCT.addActionListener(this);
				back=new JButton("����");
				back.setBounds(554, 675, 220, 60);
				back.setFont(fnA);
				back.addActionListener(this);
				flash=new JButton("ˢ��");
				flash.setBounds(794, 675, 100, 60);
				flash.setFont(fnA);
				flash.addActionListener(this);
	            bjq.add(ct);
	            bjq.add(changeCT);
	            bjq.add(back);
	            bjq.add(flash);
	            bjq.repaint();
	            bjq.validate();
	            ct.jtbl.updateUI();
			}
		}//�γ̹���
		else if(e.getSource()==changeCT) {
			Course c=new CourseDAO().list(ct.bt.getText()).get(0);
			new ChangeCourseTable(row,col,c,ct);
		}//�޸Ŀγ̰�ť���ھ����γ̹���ť֮����������ӣ�
		else if(e.getSource()==back) {
			bjq.removeAll();
			ai=new MW_C_AllInfo();
			bjq.add(ai);
			bjq.add(changeU);
			bjq.add(createU);
			bjq.add(deleteU);
			bjq.add(courseM);
			bjq.repaint();
	        bjq.validate();
		}//���ذ�ť���ھ����γ̹����������û���ť֮����������ӣ�
		else if(e.getSource()==commitCreate) {
			udao=new UserDAO();
	  		ScoreDAO sdao=new ScoreDAO();
	  		Score s ;
			u=cnu.getU();
			ArrayU=udao.list(u.getXh());
			if(u.xh.equals("")||u.xm.equals("")||u.yhm.equals("")||u.mm.equals("")||u.nl.equals("")||u.bj.equals("")||u.zy.equals("")||u.xy.equals("")||u.xb.equals("")||u.lb.equals("")) 
			{
				JOptionPane.showMessageDialog(null,"�б�����δ��д");
			}else 	if(!ArrayU.isEmpty()) {
				JOptionPane.showMessageDialog(null,"���и��û�");
			}else {
				JOptionPane.showMessageDialog(null,"��ӳɹ�");
				udao.add(cnu.getU());
				s=new Score(u.getXh(),0,0,0,0,0,0,0,0,0,u.getBj(),u.getZy());
				sdao.add(s);
			}//�ڴ������û���ͬʱҲ����ɼ���Ϣ��ȫ����ʼ��Ϊ0���Թ��պ��޸�
		}//ȷ�ϴ������û�
		else if(e.getSource()==flash) {
			ct=new MW_C_CourseTable(ct.bt.getText());
			ct.jtbl.getSelectionModel().addListSelectionListener(this);
			ct.setBounds(10,10,1043,630);
			bjq.removeAll();
			changeCT=new JButton("�޸�");
			changeCT.setBounds(314, 675, 220, 60);
			changeCT.setFont(fnA);
			changeCT.addActionListener(this);
			back=new JButton("����");
			back.setBounds(554, 675, 220, 60);
			back.setFont(fnA);
			back.addActionListener(this);
			flash=new JButton("ˢ��");
			flash.setBounds(794, 675, 100, 60);
			flash.setFont(fnA);
			flash.addActionListener(this);
            bjq.add(ct);
            bjq.add(changeCT);
            bjq.add(back);
            bjq.add(flash);
            bjq.repaint();
            bjq.validate();
		}//�޸Ŀγ̣����޸�ĳ��Ԫ��γ�֮��ˢ�±��
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		 row=ct.jtbl.getSelectedRow();
		 col=ct.jtbl.getSelectedColumn();
	}//������ȡ��ǰѡ�е�Ԫ�������ֵ
}
