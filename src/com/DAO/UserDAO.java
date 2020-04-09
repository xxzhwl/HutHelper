package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.User;

public class UserDAO implements UDAO{
	
	public UserDAO() {
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }	
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hut-helper?useUnicode=true&characterEncoding=utf8","root", "123456");
        
    }
  
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		int i=(int)( Math.random()*105);
		 String sql = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        try (Connection c = getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);) {
	        	ps.setString(1, user.xh);
	        	ps.setString(2, user.yhm);
	            ps.setString(3, user.xm);
	            ps.setString(4, user.mm);
	            ps.setString(5, user.nl);
	            ps.setString(6, "pic/tx/tx ("+i+").png");
	            ps.setString(7, user.sjhm);
	            ps.setString(8, user.bj);
	            ps.setString(9, user.zy);
	            ps.setString(10, user.xy);
	            ps.setString(11, user.xb);
	            ps.setString(12, user.ms);        
	            ps.setString(13, user.lb);         
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateM(User user) {
		// TODO Auto-generated method stub
		 String sql = "update users set yhm = ? , xm = ? , mm = ? , nl = ? , sjhm = ? , bj = ? , zy = ? , xy = ? , xb = ? , ms = ? , lb = ?  ,tx = ? where xh = ?";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	            ps.setString(1, user.yhm);
	            ps.setString(2, user.xm);
	            ps.setString(3, user.mm);
	            ps.setString(4, user.nl);
	            ps.setString(5, user.sjhm);
	            ps.setString(6, user.bj);
	            ps.setString(7, user.zy);
	            ps.setString(8, user.xy);
	            ps.setString(9, user.xb);
	            ps.setString(10, user.ms);        
	            ps.setString(11, user.lb);
	            ps.setString(12, user.getTx());
	            ps.setString(13, user.xh);            
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		 try (Connection c = getConnection(); Statement s = c.createStatement();) {
			  
	            String sql = "delete from users where xh = " + id;
	  
	            s.executeUpdate(sql);
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	}

	@Override
	public User get(String id) {
		User user = null;
		  
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	            String sql = "select * from users where xh = " +id;
	            ResultSet rs = s.executeQuery(sql);
	            if (rs.next()) {
	            	user=new User(rs.getString("xh"),rs.getString("xm"),rs.getString("mm"),rs.getString("nl"),rs.getString("tx"),rs.getString("sjhm"),rs.getString("bj"),rs.getString("xb"),rs.getString("xy"),rs.getString("yhm"),rs.getString("ms"),rs.getString("lb"),rs.getString("zy"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	}



	@Override
	public ArrayList<User> list(String id) {
		ArrayList<User> users = new ArrayList<User>();
		if(get(id)!=null)
		{
			users.add(get(id));
		}
		return users;
	}

	@Override
	public ArrayList<User> listBylb(String lb) {
		User user = null;
		ArrayList<User> users = new ArrayList<User>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from users where lb = " +"'"+lb+"'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
            	user=new User(rs.getString("xh"),rs.getString("xm"),rs.getString("mm"),rs.getString("nl"),rs.getString("tx"),rs.getString("sjhm"),rs.getString("bj"),rs.getString("xb"),rs.getString("xy"),rs.getString("yhm"),rs.getString("ms"),rs.getString("lb"),rs.getString("zy"));
            	users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return users;
	}
	}
