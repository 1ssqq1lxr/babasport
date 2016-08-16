package com.it.babasport.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class bbs_cart_info implements Serializable{
		@Id
		private int id;
		@Column(name="cartId")
		private int cartId;
		@Column(name="colorId")
		private int colorId;
		@Column(name="skuId")
		private int skuId;
		@Column(name="productId")
		private int productId;
		private int quantity;
		@Transient
		private String colorName;
		@Transient
		private bbs_sku sku;
		@Transient
		private bbs_product product;
		@Transient
		private String imgUrl;
		
		
	
		public String getImgUrl() {
			return imgUrl;
		}
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}
		public String getColorName() {
			return colorName;
		}
		public bbs_sku getSku() {
			return sku;
		}
		public bbs_product getProduct() {
			return product;
		}
		public void setColorName(String colorName) {
			this.colorName = colorName;
		}
		public void setSku(bbs_sku sku) {
			this.sku = sku;
		}
		public void setProduct(bbs_product product) {
			this.product = product;
		}
		public int getId() {
			return id;
		}
		public int getCartId() {
			return cartId;
		}
		public int getColorId() {
			return colorId;
		}
		public int getSkuId() {
			return skuId;
		}
		public int getProductId() {
			return productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		public void setColorId(int colorId) {
			this.colorId = colorId;
		}
		public void setSkuId(int skuId) {
			this.skuId = skuId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
}
