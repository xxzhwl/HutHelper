//package com.jframe;
package com.start;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.jframe.Login;
/**
 * 界面的全局样式
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
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //设置整个窗口显示风格，这里使用系统风格  
                    FontUIResource f = new FontUIResource("微软雅黑", 0,18); // 字体，样式（正常，斜体，加粗），字号  
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
                }//使用Windows风格  
                Login l=new Login();
            }  
        });  
    } 
}
