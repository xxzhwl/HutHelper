package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Course;

public class CourseDAO implements CDAO{

	public CourseDAO() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }	
	}//加载驱动
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hut-helper?useUnicode=true&characterEncoding=utf8","root", "123456");   
    }//创建连接

	@Override
	public void update(int row, int col, String kc,Course course) {
		// TODO Auto-generated method stub
		String sql="update course_table set ?"+"_"+"?="+"? where zy= " + "'" + course.zy + "'";
		 try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
     	ps.setInt(1,col);
     	ps.setInt(2,row+1);
     	ps.setString(3,kc);
        ps.executeUpdate();
         }
      catch (SQLException e) { 
         e.printStackTrace();
     }
	}//修改课程表


	
	@Override
	public ArrayList<Course> list(String zy) {
		ArrayList<Course> course = new ArrayList<Course>();
        String sql = "select * from course_table where zy= " + "'" + zy + "'";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {         
            ResultSet rs = ps.executeQuery();
            Course cs;
            String[] kc=new String[24];
  	            while (rs.next()) {
  	            for(int i=0;i<24;i++) {
					kc[i]=rs.getString(i+2);
				}
  	            cs=new Course(rs.getString("zy"),kc);  	  
				course.add(cs);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return course;
	}//获取课程表


}
	

