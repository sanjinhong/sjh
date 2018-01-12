package com.beans;

public class Depart {
	private String bmdm;	//部门代码   
	private String dwdm;	//单位代码
	private String bmid;	//部门id
	private String bmmc;	//部门名称
	private String sfjy;	//是否禁用
	private int pxh;		//排序号
	private String fbmdm;   //父部门代码
	

	public Depart() {
		super();
	}

	public Depart(String bmdm, String dwdm, String bmid, String bmmc, String sfjy, int pxh,String fbmdm) {
		super();
		this.bmdm = bmdm;
		this.dwdm = dwdm;
		this.bmid = bmid;
		this.bmmc = bmmc;
		this.sfjy = sfjy;
		this.pxh = pxh;
		this.fbmdm = fbmdm;
	}

	public String getFbmdm() {
		return fbmdm;
	}



	public void setFbmdm(String fbmdm) {
		this.fbmdm = fbmdm;
	}

	public String getBmdm() {
		return bmdm;
	}

	public void setBmdm(String bmdm) {
		this.bmdm = bmdm;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getBmmc() {
		return bmmc;
	}

	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}

	public String getSfjy() {
		return sfjy;
	}

	public void setSfjy(String sfjy) {
		this.sfjy = sfjy;
	}

	public int getPxh() {
		return pxh;
	}

	public void setPxh(int pxh) {
		this.pxh = pxh;
	}
	
}
