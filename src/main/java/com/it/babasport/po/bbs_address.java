package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class bbs_address implements Serializable{
	@Id
	private int id;
	@Column(name="buyerId")
	private String buyerId;
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	private String username;
	private String province;
	private String address;
	@Transient
	private String provinceName;
	@Transient
	private String cityName;
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String city;
	private String phone;
	@Column(name="isDef")
	private int isDef;
	@Column(name="statusAddr")
	private int statusAddr;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getPhone() {
		return phone;
	}
	public int getIsDef() {
		return isDef;
	}
	public int getStatusAddr() {
		return statusAddr;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setIsDef(int isDef) {
		this.isDef = isDef;
	}
	public void setStatusAddr(int statusAddr) {
		this.statusAddr = statusAddr;
	}
	
}
