package com.zhidian.server.model;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private String orderId;
	private String goodsId;
	private Integer orderPayWay;
	private Integer orderPayStatus;
	private Integer orderStatus;
	private Double orderMoney;
	private Integer orderIsDelete;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderId, String goodsId, Integer orderPayWay,
			Integer orderPayStatus, Integer orderStatus, Double orderMoney,
			Integer orderIsDelete) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.orderPayWay = orderPayWay;
		this.orderPayStatus = orderPayStatus;
		this.orderStatus = orderStatus;
		this.orderMoney = orderMoney;
		this.orderIsDelete = orderIsDelete;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getOrderPayWay() {
		return this.orderPayWay;
	}

	public void setOrderPayWay(Integer orderPayWay) {
		this.orderPayWay = orderPayWay;
	}

	public Integer getOrderPayStatus() {
		return this.orderPayStatus;
	}

	public void setOrderPayStatus(Integer orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getOrderMoney() {
		return this.orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Integer getOrderIsDelete() {
		return this.orderIsDelete;
	}

	public void setOrderIsDelete(Integer orderIsDelete) {
		this.orderIsDelete = orderIsDelete;
	}

}