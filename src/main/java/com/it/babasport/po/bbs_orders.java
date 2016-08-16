package com.it.babasport.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class bbs_orders implements Serializable{
	//	id	oid	amount_payable	amount_paid	buyerId	paymentWay	state	createDate	totalPrice	deliverFee	delivery	isConfirm	paymentCash	isPaiy
	@Id
	private int id;
	@Column(name="addressId")
	private int addressId;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	@Transient
	bbs_address address;
	
	public bbs_address getAddress() {
		return address;
	}
	public void setAddress(bbs_address address) {
		this.address = address;
	}
	private String oid;//订单编号
	@Column(name="deliverFee")
	private int deliverFee;//运费
	private int amount_payable;//应付价格
	private int amount_paid;//已付价格
	@Column(name="totalPrice")
	private int totalPrice;//总价
	@Column(name="paymentWay")
	private Integer paymentWay;//付款方式
	@Column(name="paymentCash")
	private Integer paymentCash;//现金付款（是 否）
	private Integer delivery;//送货时间
	@Column(name="isConfirm")
	private Integer isConfirm;//电话确认
	@Column(name="isPaiy")
	private Integer isPaiy;//支付状态
	private Integer state;//订单状态
	@Column(name="createDate")
	private Date createDate;//下单时间
	@Transient
	private String goTime;
	
	public String getGoTime() {
		return goTime;
	}
	public void setGoTime(String goTime) {
		this.goTime = goTime;
	}
	//	发货时间
	public int getId() {
		return id;
	}
	public String getOid() {
		return oid;
	}
	public int getDeliverFee() {
		return deliverFee;
	}
	public int getAmount_payable() {
		return amount_payable;
	}
	public int getAmount_paid() {
		return amount_paid;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public Integer getPaymentWay() {
		return paymentWay;
	}
	public Integer getPaymentCash() {
		return paymentCash;
	}
	public Integer getDelivery() {
		return delivery;
	}
	public Integer getIsConfirm() {
		return isConfirm;
	}
	public Integer getIsPaiy() {
		return isPaiy;
	}
	public Integer getState() {
		return state;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public void setDeliverFee(int deliverFee) {
		this.deliverFee = deliverFee;
	}
	public void setAmount_payable(int amount_payable) {
		this.amount_payable = amount_payable;
	}
	public void setAmount_paid(int amount_paid) {
		this.amount_paid = amount_paid;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
	}
	public void setPaymentCash(Integer paymentCash) {
		this.paymentCash = paymentCash;
	}
	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}
	public void setIsConfirm(Integer isConfirm) {
		this.isConfirm = isConfirm;
	}
	public void setIsPaiy(Integer isPaiy) {
		this.isPaiy = isPaiy;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	@Column(name="buyerId")
	private String buyerId;

	

	/** 特殊处理字段   */
	/** 支付方式           */
	public String getPaymentWayName() {
		switch (paymentWay) {
			case 0:  return "货到到付";
			case 1:  return "在线支付";
			case 2:  return "公司转帐";
			case 3:  return "邮局汇款";
			default: return "";
		}
	}
	/** 支付要求     必须是货到付款时  才会有支付要求 分为 0:现金 1:POS机       */
	public String getPaymentCashName() {
		if(null == paymentCash) return null;
		
		switch (paymentCash) {
			case 0:  return "现金";
			case 1:  return "POS机";
			default: return "";
		}
	}
	/** 支付状态        //支付状态 :0到付,1待付款,2已付款,3待退款,4退款成功,5退款失败  */
	public String getIsPaiyName() {
		switch (isPaiy) {
			case 0:  return "货到到付";
			case 1:  return "待付款";
			case 2:  return "已付款";
			case 3:  return "待退款";
			case 4:  return "退款成功";
			case 5:  return "退款失败";
			default: return "";
		}
	}
	/** 订单状态        //订单状态 0:提交订单 1:仓库配货 2:商品出库 3:等待收货 4:完成 5:待退货 6已退货 7已取消  */
	public String getStateName() {
		switch (state) {
			case 0:  return "提交订单";
			case 1:  return "仓库配货";
			case 2:  return "商品出库";
			case 3:  return "等待收货";
			case 4:  return "已完成";
			case 5:  return "待退货";
			case 6:  return "已退货";
			case 7:  return "已取消";
			default: return "";
		}
	}
	/** 送货时间    //  1:工作日，双休日，假日均可送货  2:只双休日，假日送货   3:只工作日送货（双休日，节假日不送）         */
	public String getDeliveryName() {
		switch (delivery) {
		case 1:  return "工作日，双休日，假日均可送货";
		case 2:  return "只双休日，假日送货";
		case 3:  return "只工作日送货（双休日，节假日不送）";
		default: return "";
		}
	}
	/** 电话确认     1:是   0:否          */
	public String getIsConfirmName() {
		switch (isConfirm) {
			case 0:  return "否";
			case 1:  return "是";
			default: return "";
		}
	}

}
