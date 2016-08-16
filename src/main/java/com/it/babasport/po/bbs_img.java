package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * 图片
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class bbs_img implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column(name="productId")
	private Integer productId;
	private String url;
	@Column(name="isDef")
	private Integer isDef;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsDef() {
		return isDef;
	}
	public void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}
	public String toString() {
		return "Img [id=" + id + ",productId=" + productId + ",url=" + url + ",isDef=" + isDef + "]";
	}
}
