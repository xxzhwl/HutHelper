package com.entity;
/**
 * 课程类
 * @author Administrator
 *属性：课程来自的专业，课程数组
 *方法：getter和setter方法
 */
public class Course {
	public String zy; //课程来自的专业
	public String[] kc;//所有课程放到一个数组里
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
