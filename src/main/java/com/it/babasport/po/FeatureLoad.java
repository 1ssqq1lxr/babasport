package com.it.babasport.po;

import java.io.Serializable;

public class FeatureLoad implements Serializable{
	private int fid;
	private String name;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
