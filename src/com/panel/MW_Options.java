//package com.jframe;
package com.panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * һ��������壨�Ƚ�ˮ��
 * @author Administrator
 * ���Ǵ�����Ļ�����Ϣ
 */
public class MW_Options extends JPanel{
	public JLabel bjq,pic,Hut,maker,url;
	public ImageIcon bji,pici;
	public Font fnA = new Font("΢���ź�",Font.PLAIN,18);
	public MW_Options () {
		bji=new ImageIcon("pic/1.png");
		bjq=new JLabel(bji);
		bjq.setBounds(0, 0,bji.getIconWidth(),bji.getIconHeight());
		pici=new ImageIcon("pic/2.png");
		pic=new JLabel(pici);
		pic.setBounds(122, 10,pici.getIconWidth(),pici.getIconHeight());
		Hut=new JLabel("�汾���� �� ��     V0.10");
		maker=new JLabel("���������1502-չ����");
		url=new JLabel("������http://www.hut.edu.cn/");
		Hut.setBounds(430,340,265,100);
		maker.setBounds(430,440,265,100);
		url.setBounds(430,540,265,100);
		Hut.setFont(fnA);
		Hut.setForeground(Color.WHITE);
		maker.setFont(fnA);
		maker.setForeground(Color.WHITE);
		url.setFont(fnA);
		url.setForeground(Color.WHITE);
		setLayout(null);
		add(bjq);
		bjq.add(pic);
		bjq.add(Hut);
		bjq.add(maker);
		bjq.add(url);
	}
}
