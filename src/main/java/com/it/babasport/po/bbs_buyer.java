package com.it.babasport.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class bbs_buyer implements Serializable {
	/**
	 * 序列化ID
	 */
	@Id
	private String id;

	private String username;
	private String password;
	private Gender gender;
	private String email;
	@Column(name="realName")
	private String realName;
	@Column(name="registerTime")
	private Date registerTime;
	private String province;
	private String city;
	private String town;
	private String addr;
	@Column(name="isDel")
	private Integer isDel;
	@Transient
	private bbs_cart cart;
	@Transient
	private List<bbs_cart_info> cart_infos;
	@Transient
	bbs_address address;
	
	public bbs_address getAddress() {
		return address;
	}

	public void setAddress(bbs_address address) {
		this.address = address;
	}
	@Transient//总价
	private int totalPrice;
	@Transient//总运费
	private int totalFee;
	public int getTotalPrice() {
		int s = 0;
		if(cart_infos!=null&&cart_infos.size()>0){
			for(int i=0;i<cart_infos.size();i++){
				s+=cart_infos.get(i).getQuantity()*cart_infos.get(i).getSku().getSkuPrice();
			}
		}
		return s ;
	}
	
	public int getTotalFee() {
		int s = 0;
		if(cart_infos!=null&&cart_infos.size()>0){
			for(int i=0;i<cart_infos.size();i++){
				s+=cart_infos.get(i).getQuantity()*cart_infos.get(i).getSku().getDeliveFee();
			}
		}
		return s ;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<bbs_cart_info> getCart_infos() {
		return cart_infos;
	}
	public void setCart_infos(List<bbs_cart_info> cart_infos) {
		this.cart_infos = cart_infos;
	}
	public bbs_cart getCart() {
		return cart;
	}
	public void setCart(bbs_cart cart) {
		this.cart = cart;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public enum Gender {

		MAN{
			public String getName(){return "男";}
		},
		WOMAN{
			public String getName(){return "女";}
		},
		SECRECY{
			public String getName(){return "保密";}
		};
		
		public abstract String getName();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "Buyer [username=" + username + ", password=" + password
				+ ", gender=" + gender + ", email=" + email + ", realName="
				+ realName + ", registerTime=" + registerTime + ", province="
				+ province + ", city=" + city + ", town=" + town + ", addr="
				+ addr + ", isDel=" + isDel + "]";
	}


}
