package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class bbs_brand implements Serializable{
	
//	@Id  
//	@Column(name = "Id")  
//	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Id
	private int id;
	@Column
	private String name;	
	@Column
	private String description;
	@Column
	private String img_url;
	@Column
	private String sort;
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Column
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getIs_display() {
		return is_display;
	}
	public void setIs_display(int is_display) {
		this.is_display = is_display;
	}

}

