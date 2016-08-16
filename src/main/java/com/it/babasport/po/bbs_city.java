package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Id;

public class bbs_city implements Serializable{
	@Id
	private int cid;
	private String name;
	private int pid;
	public int getCid() {
		return cid;
	}
	public String getName() {
		return name;
	}
	public int getPid() {
		return pid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
