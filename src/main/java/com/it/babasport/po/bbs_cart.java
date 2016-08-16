package com.it.babasport.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class bbs_cart implements Serializable {
	@Id
	private int id;
	@Column(name="buyerId")
	private String buyerId;
	private int total_quantity;
	private Date dd_time; 
	public Date getDd_time() {
		return dd_time;
	}
	public void setDd_time(Date dd_time) {
		this.dd_time = dd_time;
	}
	public int getId() {
		return id;
	}
	public String getBuyerId() {
		return buyerId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public int getTotal_quantity() {
		return total_quantity;
	}
	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}
	
	
}
