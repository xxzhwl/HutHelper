package com.DAO;
import java.util.ArrayList;


import com.entity.User;

public interface UDAO {
	//����
    public void add(User user);
    //����Ա�޸�
    public void updateM(User user);
    //ɾ��
    public void delete(String id);
    //��ȡ
    public User get(String id);
    //��ȷ��ѯ
    public ArrayList<User> list(String id);
	//�������
    public ArrayList<User> listBylb(String lb);

}
