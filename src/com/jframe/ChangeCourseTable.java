package com.jframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.DAO.CourseDAO;
import com.entity.Course;
import com.panel.MW_C_CourseTable;
import com.values.Constant;
/**
 * 改变成绩表类（JDialog类窗口）
 * @author Administrator
 * 各项组件及对应的监听事件
 */
public class ChangeCourseTable extends JDialog implements ActionListener{
	public JLabel lkcm;//课程名
	public JButton commit;//提交按钮
	public JComboBox jcbkc;//一组可选课程
	Course cs;
	MW_C_CourseTable mwct;
	CourseDAO cdao;
	int r,cl;
	public ChangeCourseTable(int row,int col,Course c,MW_C_CourseTable ct) {
		cs=c;
		mwct=ct;
		r=row;
		cl=col;//将四个参数分别赋给r,cl,cs,mwct以便操作
		
		lkcm = new JLabel("课程：");
		jcbkc = new JComboBox(Constant.kc);
		commit =new JButton("确认修改");
		
		lkcm.setBounds(5, 10, 70, 30);
		jcbkc.setBounds(80, 10, 200, 30);
		commit.setBounds(300,10,150,30);
		
		jcbkc.setSelectedItem(ct.jtbl.getValueAt(row, col));//将下拉列表中的值先设为之前存放的课程名
		commit.addActionListener(this);
		
		add(lkcm);
		add(jcbkc);
		add(commit);

		setLayout(null);
		setBounds(400,400,470,100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cdao=new CourseDAO();
		cdao.update(r, cl,(String)jcbkc.getSelectedItem(), cs);//更新当前单元格的课程信息
		mwct.jtbl.updateUI();//刷新表
		dispose();
	}
	
}
