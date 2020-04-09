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
 * �ı�ɼ����ࣨJDialog�ര�ڣ�
 * @author Administrator
 * �����������Ӧ�ļ����¼�
 */
public class ChangeCourseTable extends JDialog implements ActionListener{
	public JLabel lkcm;//�γ���
	public JButton commit;//�ύ��ť
	public JComboBox jcbkc;//һ���ѡ�γ�
	Course cs;
	MW_C_CourseTable mwct;
	CourseDAO cdao;
	int r,cl;
	public ChangeCourseTable(int row,int col,Course c,MW_C_CourseTable ct) {
		cs=c;
		mwct=ct;
		r=row;
		cl=col;//���ĸ������ֱ𸳸�r,cl,cs,mwct�Ա����
		
		lkcm = new JLabel("�γ̣�");
		jcbkc = new JComboBox(Constant.kc);
		commit =new JButton("ȷ���޸�");
		
		lkcm.setBounds(5, 10, 70, 30);
		jcbkc.setBounds(80, 10, 200, 30);
		commit.setBounds(300,10,150,30);
		
		jcbkc.setSelectedItem(ct.jtbl.getValueAt(row, col));//�������б��е�ֵ����Ϊ֮ǰ��ŵĿγ���
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
		cdao.update(r, cl,(String)jcbkc.getSelectedItem(), cs);//���µ�ǰ��Ԫ��Ŀγ���Ϣ
		mwct.jtbl.updateUI();//ˢ�±�
		dispose();
	}
	
}
