package com.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.DAO.UserDAO;
import com.entity.User;
import com.jframe.MainWindow;
/**
 * 主窗口下——普通用户个人信息类（JPanel）
 * @author Administrator
 * 各个组件及监听事件
 */
public class MW_D_Info extends JPanel implements ActionListener{
	public JLabel tx,lyhm,lid,lnl,lrx,lgrxx,lsjhm,lbj,lxb,lxy,lxm;
	public ImageIcon txi,rx;
	public String sql,txlj,yhm,nl,sjhm,bj,xb,xy,xm;
	public Font fnA = new Font("微软雅黑",Font.PLAIN,24);
	public User u;
	public JButton changeTx;
	UserDAO udao;
	MainWindow m;
	public MW_D_Info(User us,MainWindow mw) {
		udao=new UserDAO();
		u=us;
		m=mw;
		xm=u.getXm();
		nl=u.getNl();
		txlj=u.getTx();
		sjhm=u.getSjhm();
		bj=u.getBj();
		xb=u.getXb();
		xy=u.getXy();
		yhm=u.getYhm();
		setLayout(null);
		setBounds(0, 0, 270,550);    	
		txi=new ImageIcon(txlj);
		rx=new ImageIcon("pic/button/rx.png");
		changeTx=new JButton(txi);
		lrx=new JLabel(rx);
		changeTx.setBounds(0,0,120,120);
		lrx.setBounds(10,130,rx.getIconWidth(),rx.getIconHeight());
		lyhm=new JLabel(yhm);
		lyhm.setBounds(130,0,120,122);
		lyhm.setForeground(Color.WHITE);	
		lgrxx=new JLabel("个人信息:");
		lgrxx.setBounds(20+rx.getIconWidth(), 115,100+rx.getIconWidth(), 20+rx.getIconWidth());
		lxm=new JLabel("姓名:"+xm);
		lxm.setBounds(10,150,260,60);
		lxm.setForeground(Color.WHITE);	
		lnl=new JLabel("年龄:"+nl);
		lnl.setBounds(10,250, 260, 60);	
		lsjhm=new JLabel("手机号码:"+sjhm);
		lsjhm.setBounds(10,300, 260, 60);	
		lxy=new JLabel("学院:"+xy);
		lxy.setBounds(10,350, 260, 60);	
		lbj=new JLabel("班级:"+bj);
		lbj.setBounds(10,400, 260, 60);	
		lxb=new JLabel("性别:"+xb);
		lxb.setBounds(10,450, 260, 60);
		lxm.setFont(fnA);
		lyhm.setFont(fnA);
		lgrxx.setFont(fnA);
		lgrxx.setForeground(Color.WHITE);
		lxb.setFont(fnA);
		lxb.setForeground(Color.WHITE);
		lbj.setFont(fnA);
		lbj.setForeground(Color.WHITE);
		lxy.setFont(fnA);
		lxy.setForeground(Color.WHITE);
		lsjhm.setFont(fnA);
		lsjhm.setForeground(Color.WHITE);
		lnl.setFont(fnA);
		lnl.setForeground(Color.WHITE);
		this.setBackground(Color.BLACK);
		lid=new JLabel("学号:"+us.getXh());
		lid.setBounds(10, 200, 260,60);	
		lid.setFont(fnA);
		lid.setForeground(Color.WHITE);
		add(changeTx);
		add(lxm);
		add(lrx);
		add(lyhm);
		add(lid);
		add(lnl);
		add(lgrxx);
		add(lsjhm);
		add(lxy);
		add(lbj);
		add(lxb);
		changeTx.addActionListener(this);
	    setBackground(null);  
	    setOpaque(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {  
        JFileChooser jfc=new JFileChooser();  
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
        jfc.showDialog(new JLabel(), "选择");  
        File file=jfc.getSelectedFile();
        if(file==null||!file.isFile()) {
        	JOptionPane.showMessageDialog(null, "未选择文件");
        }else {
        String name="pic/tx/"+jfc.getSelectedFile().getName();
        u.setTx(name);
        udao.updateM(u);
        JOptionPane.showMessageDialog(null, "修改成功");
        remove(changeTx);
        txlj=name;
        txi=new ImageIcon(txlj);
        changeTx=new JButton(txi);
        changeTx.setBounds(0,0,120,120);
        add(changeTx);
        m.jptx.removeAll();
        txi=new ImageIcon(name);
		Image img = txi.getImage();  
		img = img.getScaledInstance(65,65, Image.SCALE_DEFAULT);  
		txi.setImage(img); 
        tx=new JLabel(txi);
        m.jptx.add(tx,BorderLayout.CENTER);
        m.jptx.repaint();
        m.jptx.validate();
        repaint();
        validate();
        } 
	}
	}  