package com.it.babasport.po;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.io.Serializable;


/**
 * 商品
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class bbs_product implements Serializable {
//	/**
//	 * 序列化ID
//	 */
//	private static final long serialVersionUID = 1L;
//	/**  前台每页数  */
//	public static final int FRONT_PAGE_SIZE = 8;
	@Id
	private Integer id;
	private String no;//商品编号
	private String name;
	private Double weight;
	@Column(name="isNew")
	private Integer isNew;
	@Column(name="isHot")
	private Integer isHot;
	@Column(name="isCommend")
	private Integer isCommend;
	@Column(name="createTime")
	private Date createTime;
	@Column(name="createUserId")
	private Integer createUserId;
	@Column(name="checkTime")
	private Date checkTime;
	@Column(name="checkUserId")
	private Integer checkUserId;
	@Column(name="isShow")
	private Integer isShow;
	@Column(name="isDel")
	private Integer isDel;
	@Column(name="typeId")
	private Integer typeId;
	@Column(name="brandId")
	private Integer brandId;
	private String keywords;
	private Integer sales;
	private String description;
	@Column(name="packageList")
	private String packageList;
	private String feature;//尺码
	private String color;//9,10,11,12
	private String size;//S,L,XXL
	@Transient
	private String url;
	public Integer getId() {
		return id;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public Double getWeight() {
		return weight;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public Integer getIsCommend() {
		return isCommend;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public Integer getCheckUserId() {
		return checkUserId;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public String getKeywords() {
		return keywords;
	}
	public Integer getSales() {
		return sales;
	}
	public String getDescription() {
		return description;
	}
	public String getPackageList() {
		return packageList;
	}
	public String getFeature() {
		return feature;
	}
	public String getColor() {
		return color;
	}
	public String getSize() {
		return size;
	}
	public String getUrl() {
		return url;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public void setIsCommend(Integer isCommend) {
		this.isCommend = isCommend;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public void setCheckUserId(Integer checkUserId) {
		this.checkUserId = checkUserId;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
