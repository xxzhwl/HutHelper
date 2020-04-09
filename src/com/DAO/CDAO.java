package com.DAO;

import java.util.ArrayList;

import com.entity.Course;

public interface CDAO {
    //修改(根据选中课程表中的某个单元格获取行列，当前单元格的课程名，当前课程表四个参数进行修改）
    public void update(int row,int col,String kc,Course course);
    //精确查询 （根据专业名获取）
    public ArrayList<Course> list(String id);
}
