package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Score;

public class ScoreDAO implements SDAO{
	
	public ScoreDAO() {
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
	public void add(Score score) {
		// TODO Auto-generated method stub
		String sql = "insert into score values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);) {
        	ps.setString(1, score.xh);
        	ps.setInt(2, score.java);
            ps.setInt(3, score.c);
            ps.setInt(4, score.oracle);
            ps.setInt(5, score.cpp);
            ps.setInt(6, score.mzdsx);
            ps.setInt(7, score.jsjwl);
            ps.setInt(8, score.czxt);
            ps.setInt(9, score.avgS);
            ps.setInt(10, score.sumS);
            ps.setString(11, score.bj);
            ps.setString(12, score.zy);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(Score score) {
		// TODO Auto-generated method stub
		 String sql = "update score set java = ? , c = ? , oracle = ? , cpp = ? , mzdsx = ? , jsjwl = ? , czxt = ? , zcj = ? , pjf = ? where xh = ?";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	            ps.setInt(1, score.java);
	            ps.setInt(2, score.c);
	            ps.setInt(3, score.oracle);
	            ps.setInt(4, score.cpp);
	            ps.setInt(5, score.mzdsx);
	            ps.setInt(6, score.jsjwl);
	            ps.setInt(7, score.czxt);
	            ps.setInt(8, score.getSumS());
	            ps.setInt(9, score.getAvgS());
	            ps.setString(10, score.xh);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		try (Connection c = getConnection(); Statement s = c.createStatement();) {
			  
            String sql = "delete from score where xh = " + id;
  
            s.executeUpdate(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
	}

	@Override
	public Score get(String id) {
		Score score = null; 
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from score where xh = " +id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
  	            score =new Score(rs.getString("xh"),rs.getInt("java"),rs.getInt("c"),rs.getInt("oracle"),rs.getInt("cpp"),rs.getInt("mzdsx"),rs.getInt("jsjwl"),rs.getInt("czxt"),rs.getInt("pjf"),rs.getInt("zcj"),rs.getString("bj"),rs.getString("zy"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }	
        return score;
	}

	@Override
	public ArrayList<Score> list() {
		ArrayList<Score> score = new ArrayList<Score>();
		  
        String sql = "select * from score ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
           
            ResultSet rs = ps.executeQuery();
  	            while (rs.next()) {
  	  	            Score sr =new Score(rs.getString("xh"),rs.getInt("java"),rs.getInt("c"),rs.getInt("oracle"),rs.getInt("cpp"),rs.getInt("mzdsx"),rs.getInt("jsjwl"),rs.getInt("czxt"),rs.getInt("pjf"),rs.getInt("zcj"),rs.getString("bj"),rs.getString("zy"));
            	score.add(sr);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return score;
	}
	@Override
	public ArrayList<Score> list(String id) {
		ArrayList<Score> score = new ArrayList<Score>();
		if(get(id)!=null)
		{
			score.add(get(id));
		}
		return score;
	}

	@Override
	public ArrayList<Score> listByClass(String zy,String bj) {
		ArrayList<Score> score = new ArrayList<Score>();
		  
        String sql = "select * from score where zy="+"'"+zy+"'"+"and bj="+bj+" order by zcj desc";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
           
            ResultSet rs = ps.executeQuery();
  	            while (rs.next()) {
  	            Score sr =new Score(rs.getString("xh"),rs.getInt("java"),rs.getInt("c"),rs.getInt("oracle"),rs.getInt("cpp"),rs.getInt("mzdsx"),rs.getInt("jsjwl"),rs.getInt("czxt"),rs.getInt("pjf"),rs.getInt("zcj"),rs.getString("bj"),rs.getString("zy"));
            	score.add(sr);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return score;
		
	}

	@Override
	public ArrayList<Score> listByMajor(String zy) {
		ArrayList<Score> score = new ArrayList<Score>();
		  
        String sql = "select * from score where zy="+"'"+zy+"'"+" order by zcj desc";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
           
            ResultSet rs = ps.executeQuery();
  	            while (rs.next()) {
  	  	            Score sr =new Score(rs.getString("xh"),rs.getInt("java"),rs.getInt("c"),rs.getInt("oracle"),rs.getInt("cpp"),rs.getInt("mzdsx"),rs.getInt("jsjwl"),rs.getInt("czxt"),rs.getInt("pjf"),rs.getInt("zcj"),rs.getString("bj"),rs.getString("zy"));
            	score.add(sr);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return score;
		
	}

}
