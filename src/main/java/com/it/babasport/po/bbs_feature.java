package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Id;

public class bbs_feature implements Serializable{
	@Id
	private String id;
	private String name;
	private String is_display;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIs_display() {
		return is_display;
	}
	public void setIs_display(String is_display) {
		this.is_display = is_display;
	}
	
}
