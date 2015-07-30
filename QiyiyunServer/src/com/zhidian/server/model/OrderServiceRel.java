package com.zhidian.server.model;

/**
 * OrderServiceRel entity. @author MyEclipse Persistence Tools
 */

public class OrderServiceRel implements java.io.Serializable {

	// Fields

	private String orderServiceId;
	private String orderId;
	private String serviceId;

	// Constructors

	/** default constructor */
	public OrderServiceRel() {
	}

	/** full constructor */
	public OrderServiceRel(String orderId, String serviceId) {
		this.orderId = orderId;
		this.serviceId = serviceId;
	}

	// Property accessors

	public String getOrderServiceId() {
		return this.orderServiceId;
	}

	public void setOrderServiceId(String orderServiceId) {
		this.orderServiceId = orderServiceId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}