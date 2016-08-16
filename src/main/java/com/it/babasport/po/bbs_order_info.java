package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Administrator
 *
 */
public class bbs_order_info implements Serializable{
	@Id
	private int id;
	@Column(name="orderId")
	private int orderId;//订单ID
	private String color;
	private String size;
	private int amount;
	private double sale_price;//售价
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	@Column(name="deFee")
	private double deFee;//总邮费
	@Column(name="productNo")
	private String productNo;
	@Column(name="productName")
	private String productName;
	@Column(name="productId")
	private int productId;
	@Column(name="imgUrl")
	private String imgUrl;
	@Column(name="skuId")
	private int skuId;
	
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getId() {
		return id;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getColor() {
		return color;
	}
	public String getSize() {
		return size;
	}
	public int getAmount() {
		return amount;
	}


	
	public String getProductNo() {
		return productNo;
	}
	public String getProductName() {
		return productName;
	}
	public double getDeFee() {
		return deFee;
	}
	public void setDeFee(double deFee) {
		this.deFee = deFee;
	}
	public int getProductId() {
		return productId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}


	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
