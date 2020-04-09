package com.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.DAO.ScoreDAO;
import com.DAO.UserDAO;
import com.entity.Score;
import com.entity.User;
import com.values.Constant;

/**
 * 单人成绩表数据模型类（用以精确查询个人成绩信息）
 * @author Administrator
 * 各个属性及方法 
 */
public class OneScoreTableModel extends AbstractTableModel{

	public String[] bt=Constant.scoreO;
	public ArrayList<Score> sArray ;
	public Score s;
	public User u;
	public ScoreDAO sdao=new ScoreDAO();
	@Override
	public int getRowCount() {
		return sArray.size();
	}// 获得行的数目

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return bt.length;
	}// 获得列的数目

    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return bt[columnIndex];
    }//获取列名
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	 if (columnIndex < 2 || columnIndex >8) {
             return false;
         } else {
             return true;
         }
    }//当前单元格是否可被编辑
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		  s=sArray.get(rowIndex);
		  u=new UserDAO().list(s.getXh()).get(0); 
		  if (0 == columnIndex)
	            return s.getXh();
	        if (1 == columnIndex)
	            return u.getXm();
	        if (2 == columnIndex)
	            return s.getJava();
	        if (3 == columnIndex)
	            return s.getC();
	        if (4 == columnIndex)
	            return s.getOracle();
	        if (5 == columnIndex)
	            return s.getCpp();
	        if (6 == columnIndex)
	            return s.getMzdsx();
	        if (7 == columnIndex)
	            return s.getJsjwl();
	        if (8 == columnIndex)
	            return s.getCzxt();
	        if (9 == columnIndex)
	            return s.getAvgS();
	        if (10 == columnIndex)
	            return s.getSumS();
	        return null;
	}//获取当前单元格的值
}
