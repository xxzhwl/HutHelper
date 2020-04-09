package com.entity;
/**
 * 成绩类
 * @author Administrator
 *属性：七门课程  sumS为总分 avgS为平均分 均采用int类型数据 平均分也取整型
 *方法：getter和setter方法
 */
public class Score {
	public String xh,bj,zy;//成绩中包含个人的学号班级专业
	public int java,c,oracle,cpp,mzdsx,jsjwl,czxt,sumS,avgS;//共七门课程  sumS为总分 avgS为平均分 均采用int类型数据 平均分也取整型
	public int[] a;
	public String[] b;
	public Score(String xh,int java,int c,int oracle,int cpp,int mzdsx,int jsjwl,int czxt,int avgS,int sumS,String bj,String zy) {
		this.xh=xh;
		this.java=java;
		this.c=c;
		this.oracle=oracle;
		this.cpp=cpp;
		this.mzdsx=mzdsx;
		this.jsjwl=jsjwl;
		this.czxt=czxt;
		this.zy=zy;
		this.bj=bj;
		this.avgS=avgS;
		this.sumS=sumS;
		a=new int[7];
		a[0]=java;
		a[1]=c;
		a[2]=oracle;
		a[3]=cpp;
		a[4]=mzdsx;
		a[5]=jsjwl;
		a[6]=czxt;
		b=new String[7];
		b[0]="java";
		b[1]="c语言";
		b[2]="oracle数据库";
		b[3]="c++";
		b[4]="毛泽东思想";
		b[5]="计算机网络";
		b[6]="操作系统";
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
	 * @return the b
	 */
	public String[] getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(String[] b) {
		this.b = b;
	}
	/**
	 * @return the sumS
	 */
	public int  getSumS() {
		return sumS;
	}
	/**
	 * @param sumS the sumS to set
	 */
	public void setSumS(int sumS) {
		this.sumS = sumS;
	}
	/**
	 * @return the a
	 */
	public int[] getA() {
		return a;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(int[] a) {
		this.a = a;
	}
	/**
	 * @return the mzdsx
	 */
	public int getMzdsx() {
		return mzdsx;
	}
	/**
	 * @param mzdsx the mzdsx to set
	 */
	public void setMzdsx(int mzdsx) {
		this.mzdsx = mzdsx;
	}
	/**
	 * @return the jsjwl
	 */
	public int getJsjwl() {
		return jsjwl;
	}
	/**
	 * @param jsjwl the jsjwl to set
	 */
	public void setJsjwl(int jsjwl) {
		this.jsjwl = jsjwl;
	}
	/**
	 * @return the czxt
	 */
	public int getCzxt() {
		return czxt;
	}
	/**
	 * @param czxt the czxt to set
	 */
	public void setCzxt(int czxt) {
		this.czxt = czxt;
	}
	/**
	 * @return the xh
	 */
	public String getXh() {
		return xh;
	}
	/**
	 * @param xh the xh to set
	 */
	public void setXh(String xh) {
		this.xh = xh;
	}
	/**
	 * @return the java
	 */
	public int getJava() {
		return java;
	}
	/**
	 * @param java the java to set
	 */
	public void setJava(int java) {
		this.java = java;
	}
	/**
	 * @return the c
	 */
	public int getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(int c) {
		this.c = c;
	}
	/**
	 * @return the oracle
	 */
	public int getOracle() {
		return oracle;
	}
	/**
	 * @param oracle the oracle to set
	 */
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	/**
	 * @return the cpp
	 */
	public int getCpp() {
		return cpp;
	}
	/**
	 * @param cpp the cpp to set
	 */
	public void setCpp(int cpp) {
		this.cpp = cpp;
	}
	/**
	 * @return the avgS
	 */
	public int getAvgS() {
		return avgS;
	}
	/**
	 * @param avgS the avgS to set
	 */
	public void setAvgS(int avgS) {
		this.avgS = avgS;
	}

}
