package com.DAO;
import java.util.ArrayList;


import com.entity.User;

public interface UDAO {
	//增加
    public void add(User user);
    //管理员修改
    public void updateM(User user);
    //删除
    public void delete(String id);
    //获取
    public User get(String id);
    //精确查询
    public ArrayList<User> list(String id);
	//按类查找
    public ArrayList<User> listBylb(String lb);

}
