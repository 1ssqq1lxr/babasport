package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class bbs_color implements Serializable{
	@Id
	private int id;
	@Column( name="parentId")
	private int parentId;
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
	public int getImg_url() {
		return img_url;
	}
	public void setImg_url(int img_url) {
		this.img_url = img_url;
	}
	private String name;
	private int img_url;
}
