package com.entity;
/**
 * �γ���
 * @author Administrator
 *���ԣ��γ����Ե�רҵ���γ�����
 *������getter��setter����
 */
public class Course {
	public String zy; //�γ����Ե�רҵ
	public String[] kc;//���пγ̷ŵ�һ��������
	public Course(String zy,String[] kc) {
		this.zy=zy;
		this.kc=kc;
	}
	/**
	 * @return the zy
	 */
	public String getZy() {
		return zy;
	}
	/**
	 * @param zy the zy to set
	 */
	public void setZy(String zy) {
		this.zy = zy;
	}
	/**
	 * @return the kc
	 */
	public String[] getKc() {
		return kc;
	}
	/**
	 * @param kc the kc to set
	 */
	public void setKc(String[] kc) {
		this.kc = kc;
	}

}
