package com.beans;

public class User {

	private String yhdm;	//用户代码
	private String dwdm;	//单位代码
	private String yhid;	//用户账号
	private String yhxm;	//用户姓名
	private String yhkl;	//用户口令
	private String yhxb;	//用户性别
	private String yhbm;	//用户部门
	private String csrq;	//出生日期
	private Integer pxh;	//序列号
	private String sfjy;	//是否禁用

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String yhdm, String dwdm, String yhid, String yhxm, String yhkl, String yhxb, String yhbm, String csrq,
			Integer pxh, String sfjy) {
		super();
		this.yhdm = yhdm;
		this.dwdm = dwdm;
		this.yhid = yhid;
		this.yhxm = yhxm;
		this.yhkl = yhkl;
		this.yhxb = yhxb;
		this.yhbm = yhbm;
		this.csrq = csrq;
		this.pxh = pxh;
		this.sfjy = sfjy;
	}

	public String getYhdm() {
		return yhdm;
	}

	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getYhid() {
		return yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

	public String getYhxm() {
		return yhxm;
	}

	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}

	public String getYhkl() {
		return yhkl;
	}

	public void setYhkl(String yhkl) {
		this.yhkl = yhkl;
	}

	public String getYhxb() {
		return yhxb;
	}

	public void setYhxb(String yhxb) {
		this.yhxb = yhxb;
	}

	public String getYhbm() {
		return yhbm;
	}

	public void setYhbm(String yhbm) {
		this.yhbm = yhbm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public Integer getPxh() {
		return pxh;
	}

	public void setPxh(Integer pxh) {
		this.pxh = pxh;
	}

	public String getSfjy() {
		return sfjy;
	}

	public void setSfjy(String sfjy) {
		this.sfjy = sfjy;
	}

}
