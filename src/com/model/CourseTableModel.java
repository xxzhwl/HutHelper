package com.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.entity.Course;
import com.values.Constant;

/**
 * �γ̱�������Ϣģ��
 * @author Administrator
 * ���õ�ǰ����һ�������뷽��
 */
public class CourseTableModel extends AbstractTableModel{
	public String[] weekday=Constant.weekday;
	String[][] s;
	public ArrayList<Course> cArray ;
	@Override
	public int getRowCount() {
		return 4;
	}// ����е���Ŀ

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return weekday.length;
	}// ����е���Ŀ

    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return weekday[columnIndex];
    }//��ȡ����
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	 if (columnIndex < 1) {
             return false;
         } else {
             return true;
         }
    }//��ǰ��Ԫ���Ƿ�ɱ��༭
    
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
	}//��ȡ��ǰ��Ԫ���ֵ
}
	

