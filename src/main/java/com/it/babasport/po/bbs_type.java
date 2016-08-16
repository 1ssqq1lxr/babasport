package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class bbs_type implements Serializable{
	@Id
	private int id;
	private String name;
	@Column(name="parentId")
	private int parentId;
	private int is_display;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getIs_display() {
		return is_display;
	}
	public void setIs_display(int is_display) {
		this.is_display = is_display;
	}
	
}
