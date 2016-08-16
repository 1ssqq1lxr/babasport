package com.it.babasport.po;

import java.io.Serializable;

public class ColorLoad implements Serializable{
	private int cid;
	private String name;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
