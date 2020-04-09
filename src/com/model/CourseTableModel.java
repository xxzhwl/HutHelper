package com.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.entity.Course;
import com.values.Constant;

/**
 * 课程表数据信息模型
 * @author Administrator
 * 设置当前表格的一切属性与方法
 */
public class CourseTableModel extends AbstractTableModel{
	public String[] weekday=Constant.weekday;
	String[][] s;
	public ArrayList<Course> cArray ;
	@Override
	public int getRowCount() {
		return 4;
	}// 获得行的数目

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return weekday.length;
	}// 获得列的数目

    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return weekday[columnIndex];
    }//获取列名
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	 if (columnIndex < 1) {
             return false;
         } else {
             return true;
         }
    }//当前单元格是否可被编辑
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 Course c=cArray.get(0);
		 s=new String[4][6];
		 for(int i=0;i<6;i++) {
			 s[0][i]=c.kc[i];
			 s[1][i]=c.kc[i+6];
			 s[2][i]=c.kc[i+12];
			 s[3][i]=c.kc[i+18];
		 }
		 return s[rowIndex][columnIndex];
	}//获取当前单元格的值
}
	

