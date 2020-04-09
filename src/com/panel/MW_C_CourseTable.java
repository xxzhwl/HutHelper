package com.panel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

import com.DAO.CourseDAO;
import com.entity.Course;
import com.model.CourseTableModel;
import com.values.Constant;
/**
 * 主窗口下——管理员查看课程表类（JPanel）
 * @author Administrator
 * 管理员在主窗口Comm面板下进入此面板查看某个专业的课程表信息
 */
public class MW_C_CourseTable extends JPanel {
	public  Font fnA = new Font("微软雅黑",Font.PLAIN,18);
	public JPanel JPtime,JPbt;
	public JLabel bt;
	public JTable jtbl;
	public JButton[] jbtns;
	ArrayList<Course> crarry;
	CourseDAO cdao;
	Course crs;
	Object[][] CourseData=new Object[Constant.time.length][Constant.weekday.length];
	public MW_C_CourseTable(String zy) {
		CourseTableModel ctm=new CourseTableModel();
		ctm.cArray=new CourseDAO().list(zy);
		jtbl=new JTable(ctm);
		JPtime=new JPanel();
		JPbt=new JPanel();
		bt=new JLabel(zy);
		JScrollPane jspPanel=new JScrollPane(jtbl);
		bt.setFont(fnA);
		jtbl.setRowHeight(136);
		jtbl.setFont(fnA);
		JPbt.setBounds(0, 0, 1000, 50);
		JPtime.setBounds(10,50, 1000,625);
		JPtime.setLayout(null);
		jspPanel.setBounds(0, 0, 1000, 600);
		JPbt.add(bt);
		JPtime.add(jspPanel);
		add(JPtime);
		add(JPbt);
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(zy));
	}

}
