package com.panel;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.DAO.UserDAO;
import com.entity.User;
import com.values.Constant;
/**
 * �������¡�������Աֱ�Ӳ鿴�����û���Ϣ����壨JPanle��
 * @author Administrator
 * �Ա����ʽ��ʾ�����û��Ļ�����Ϣ
 */
public class MW_C_AllInfo extends JPanel{
	public  JPanel pbt,pnr;
	public  JLabel lbt;
	public  JTable jtbl;
	public  JScrollPane jspPanel;
	public  Font fnA = new Font("΢���ź�",Font.PLAIN,32);
			User ur;
			ArrayList<User> urArray;
			UserDAO udao;
			Object[][] userData;
		public MW_C_AllInfo() {
			udao=new UserDAO();
			urArray=udao.listBylb("��ͨ�û�");	
			int totalEmps=urArray.size();
		    userData=new Object[totalEmps][Constant.strCols.length];
			ur=null;
			for(int i=0;i<userData.length;i++) {
				ur=urArray.get(i);
				userData[i][0]=ur.getXh();
				userData[i][1]=ur.getXm();
				userData[i][2]=ur.getYhm();					
				userData[i][3]=ur.getNl();
				userData[i][4]=ur.getSjhm();
				userData[i][5]=ur.getXb();
				userData[i][6]=ur.getXy();
				userData[i][7]=ur.getZy();
				userData[i][8]=ur.getBj();
			}
			pbt=new JPanel();
			pnr=new JPanel();
			lbt=new JLabel("��Ϣ����");
			jtbl=new JTable(userData,Constant.strCols);
			jtbl.setRowHeight(50);
			jtbl.setPreferredScrollableViewportSize(new Dimension(750,590));
			jspPanel=new JScrollPane(jtbl);
			lbt.setFont(fnA);
			lbt.setForeground(Color.WHITE);
			pbt.setBounds(0, 0,780, 50);
			pnr.setBounds(0,50,780,650);
			pbt.add(lbt);
			pnr.add(jspPanel);
	        pbt.setBackground(null);  
	        pbt.setOpaque(false);
			add(pbt);
			add(pnr);
			setBounds(10,10,780,1000);
			setLayout(null);
			setBackground(null);  
	        setOpaque(false);
		}
	
}
