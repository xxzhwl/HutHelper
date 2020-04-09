package com.DAO;

import java.util.ArrayList;

import com.entity.Score;
public interface SDAO {
	//����һ���û��ĳɼ���Ϣ
    public void add(Score score);
    //�޸�һ���û��ĳɼ���Ϣ
    public void update(Score score);
    //ɾ��һ���û��ĳɼ���Ϣ
    public void delete(String id);
    //��ȡһ���û��ĳɼ���Ϣ
    public Score get(String id);
    //��ѯ
    public ArrayList<Score> list();
    //��ȷ��ѯ
    public ArrayList<Score> list(String id);
    //�����ѯ
    public ArrayList<Score> listByClass(String zy,String bj);
    //��רҵ��ѯ
    public ArrayList<Score> listByMajor(String zy);
}
