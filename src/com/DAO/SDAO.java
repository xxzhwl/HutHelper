package com.DAO;

import java.util.ArrayList;

import com.entity.Score;
public interface SDAO {
	//增加一个用户的成绩信息
    public void add(Score score);
    //修改一个用户的成绩信息
    public void update(Score score);
    //删除一个用户的成绩信息
    public void delete(String id);
    //获取一个用户的成绩信息
    public Score get(String id);
    //查询
    public ArrayList<Score> list();
    //精确查询
    public ArrayList<Score> list(String id);
    //按班查询
    public ArrayList<Score> listByClass(String zy,String bj);
    //按专业查询
    public ArrayList<Score> listByMajor(String zy);
}
