//package com.jframe;
package com.start;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.jframe.Login;
/**
 * �����ȫ����ʽ
 * @author Administrator
 */
public class StartStyle {
	public static void main(String args[])  
    {  
        java.awt.EventQueue.invokeLater(new Runnable()  
        {  
            public void run()  
            {  
                try  
                {  
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //��������������ʾ�������ʹ��ϵͳ���  
                    FontUIResource f = new FontUIResource("΢���ź�", 0,18); // ���壬��ʽ��������б�壬�Ӵ֣����ֺ�  
                    java.util.Enumeration keys = UIManager.getDefaults().keys();  
                    while (keys.hasMoreElements())  
                    {  
                        Object key = keys.nextElement();  
                        Object value = UIManager.get(key);  
                        if (value instanceof javax.swing.plaf.FontUIResource)  
                            UIManager.put(key, f);  
                    }  
                } catch (Exception e)  
                {  
                   e.printStackTrace();  
                }//ʹ��Windows���  
                Login l=new Login();
            }  
        });  
    } 
}
