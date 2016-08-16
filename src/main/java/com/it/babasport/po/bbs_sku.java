package com.it.babasport.po;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.io.Serializable;


/**
 * 最小销售单元
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class bbs_sku implements Serializable {

	@Id
	private Integer id;
	@Column(name="productId")
	private Integer productId;
	@Column(name="colorId")
	private Integer colorId;
	private String size;
	@Column(name="deliveFee")
	private Double deliveFee;
	@Column(name="skuPrice")
	private Double skuPrice;
	@Column(name="stockInventory")
	private Integer stockInventory;
	@Column(name="skuUpperLimit")
	private Integer skuUpperLimit;
	private String location;
	@Column(name="skuImg")
	private String skuImg;
	@Column(name="skuSort")
	private Integer skuSort;
	@Column(name="skuName")
	private String skuName;
	@Column(name="marketPrice")
	private Double marketPrice;
	@Column(name="createTime")
	private Date createTime;
	@Column(name="updateTime")
	private Date updateTime;
	@Column(name="createUserId")
	private String createUserId;
	@Column(name="updateUserId")
	private String updateUserId;
	@Column(name="lastStatus")
	private Integer lastStatus;
	@Column(name="skuType")
	private Integer skuType;
	private Integer sales;
	@Transient
	private String color;
	public Integer getId() {
		return id;
	}
	public Integer getProductId() {
		return productId;
	}
	public Integer getColorId() {
		return colorId;
	}
	public String getSize() {
		return size;
	}
	public Double getDeliveFee() {
		return deliveFee;
	}
	public Double getSkuPrice() {
		return skuPrice;
	}
	public Integer getStockInventory() {
		return stockInventory;
	}
	public Integer getSkuUpperLimit() {
		return skuUpperLimit;
	}
	public String getLocation() {
		return location;
	}
	public String getSkuImg() {
		return skuImg;
	}
	public Integer getSkuSort() {
		return skuSort;
	}
	public String getSkuName() {
		return skuName;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public Integer getLastStatus() {
		return lastStatus;
	}
	public Integer getSkuType() {
		return skuType;
	}
	public Integer getSales() {
		return sales;
	}
	public String getColor() {
		return color;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setDeliveFee(Double deliveFee) {
		this.deliveFee = deliveFee;
	}
	public void setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
	}
	public void setStockInventory(Integer stockInventory) {
		this.stockInventory = stockInventory;
	}
	public void setSkuUpperLimit(Integer skuUpperLimit) {
		this.skuUpperLimit = skuUpperLimit;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setSkuImg(String skuImg) {
		this.skuImg = skuImg;
	}
	public void setSkuSort(Integer skuSort) {
		this.skuSort = skuSort;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public void setLastStatus(Integer lastStatus) {
		this.lastStatus = lastStatus;
	}
	public void setSkuType(Integer skuType) {
		this.skuType = skuType;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public void setColor(String color) {
		this.color = color;
	}

	
}
