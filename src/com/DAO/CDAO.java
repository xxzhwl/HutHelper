package com.DAO;

import java.util.ArrayList;

import com.entity.Course;

public interface CDAO {
    //�޸�(����ѡ�пγ̱��е�ĳ����Ԫ���ȡ���У���ǰ��Ԫ��Ŀγ�������ǰ�γ̱��ĸ����������޸ģ�
    public void update(int row,int col,String kc,Course course);
    //��ȷ��ѯ ������רҵ����ȡ��
    public ArrayList<Course> list(String id);
}
