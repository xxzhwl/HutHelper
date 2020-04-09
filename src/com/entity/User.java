package com.entity;
/**
 * 用户类
 * @author Administrator
 *属性：姓名，密码，用户名，学号，年龄，头像路径，手机号码，班级，性别，专业，学院，个人描述，登陆类型；
 *方法：getter和setter方法
 */
public class User {
	public String xm,mm,sjhm,bj,xb,xy,yhm,ms,xh,nl,tx,lb,zy;
	public User(String xh,String xm,String mm,String nl,String tx,String sjhm,String bj,String xb,String xy,String yhm,String ms,String lb,String zy) {
		this.xm=xm;
		this.mm=mm;
		this.sjhm=sjhm;
		this.bj=bj;
		this.xb=xb;
		this.xy=xy;
		this.yhm=yhm;
		this.ms=ms;
		this.nl=nl;
		this.xh=xh;
		this.tx=tx;
		this.lb=lb;
		this.zy=zy;
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
	public User() {
		
	}
	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}
	/**
	 * @param xm the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * @return the mm
	 */
	public String getMm() {
		return mm;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setMm(String mm) {
		this.mm = mm;
	}
	/**
	 * @return the sjhm
	 */
	public String getSjhm() {
		return sjhm;
	}
	/**
	 * @param sjhm the sjhm to set
	 */
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	/**
	 * @return the bj
	 */
	public String getBj() {
		return bj;
	}
	/**
	 * @param bj the bj to set
	 */
	public void setBj(String bj) {
		this.bj = bj;
	}
	/**
	 * @return the xb
	 */
	public String getXb() {
		return xb;
	}
	/**
	 * @param xb the xb to set
	 */
	public void setXb(String xb) {
		this.xb = xb;
	}
	/**
	 * @return the xy
	 */
	public String getXy() {
		return xy;
	}
	/**
	 * @param xy the xy to set
	 */
	public void setXy(String xy) {
		this.xy = xy;
	}
	/**
	 * @return the yhm
	 */
	public String getYhm() {
		return yhm;
	}
	/**
	 * @param yhm the yhm to set
	 */
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	/**
	 * @return the ms
	 */
	public String getMs() {
		return ms;
	}
	/**
	 * @param ms the ms to set
	 */
	public void setMs(String ms) {
		this.ms = ms;
	}
	/**
	 * @return the nl
	 */
	public String getNl() {
		return nl;
	}
	/**
	 * @param nl the nl to set
	 */
	public void setNl(String nl) {
		this.nl = nl;
	}
	/**
	 * @return the xh
	 */
	public String getXh() {
		return xh;
	}
	/**
	 * @param string the xh to set
	 */
	public void setXh(String string) {
		this.xh = string;
	}
	
	public String getTx() {
		return tx;
	}
	/**
	 * @param string the xh to set
	 */
	public void setTx(String string) {
		this.tx = string;
	}
	
	
	public String getLb() {
		return lb;
	}
	/**
	 * @param string the xh to set
	 */
	public void setLb(String string) {
		this.lb = string;
	}
}
