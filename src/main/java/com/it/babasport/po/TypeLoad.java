package com.it.babasport.po;

import java.io.Serializable;

public class TypeLoad implements Serializable{
	private int tid;
	private String name;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
