package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Id;

public class bbs_province implements Serializable{
	@Id
	private int pid;
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
