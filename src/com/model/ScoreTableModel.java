package com.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.DAO.ScoreDAO;
import com.DAO.UserDAO;
import com.entity.Score;
import com.entity.User;
import com.values.Constant;

/**
 * �ɼ�������ģ���ࣨ���Բ�ѯ����רҵ�ɼ���Ϣ��������ɼ���Ϣ��
 * @author Administrator
 * �������Լ����� 
 */

public class ScoreTableModel extends AbstractTableModel {
	private boolean DEBUG = true;
	public String [] bt=Constant.scoreM;
	public ArrayList<Score> sArray = new ScoreDAO().list();
	Score s;
	ScoreDAO sdao;
	@Override
	public int getRowCount() {
		return sArray.size();
	}// ����е���Ŀ

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return bt.length;
	}// ����е���Ŀ

    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return bt[columnIndex];
    }//��ȡ����
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	 if (columnIndex < 3) {
             return false;
         } else {
             return true;
         }
    }//��ǰ��Ԫ���Ƿ�ɱ��༭
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 s=sArray.get(rowIndex);
		 User u=new UserDAO().list(s.getXh()).get(0); 
		  if (0 == columnIndex)
	            return rowIndex+1;
	        if (1 == columnIndex)
	            return s.getXh();
	        if (2 == columnIndex)
	            return u.getXm();
	        if (3 == columnIndex)
	            return s.getJava();
	        if (4 == columnIndex)
	            return s.getC();
	        if (5 == columnIndex)
	            return s.getOracle();
	        if (6 == columnIndex)
	            return s.getCpp();
	        if (7 == columnIndex)
	            return s.getMzdsx();
	        if (8 == columnIndex)
	            return s.getJsjwl();
	        if (9 == columnIndex)
	            return s.getCzxt();
	        if (10 == columnIndex)
	            return s.getSumS();
	        return null;
	}//��ȡ��ǰ��Ԫ���ֵ
}
