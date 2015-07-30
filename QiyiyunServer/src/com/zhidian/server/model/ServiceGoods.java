package com.zhidian.server.model;

/**
 * ServiceGoods entity. @author MyEclipse Persistence Tools
 */

public class ServiceGoods implements java.io.Serializable {

	// Fields

	private String serviceGoodsId;
	private String goodsId;
	private String serviceGoodsName;
	private Integer serviceGoodsTimeUnit;
	private String serviceGoodsDesc;
	private Double serviceGoodsMargin;

	// Constructors

	/** default constructor */
	public ServiceGoods() {
	}

	/** full constructor */
	public ServiceGoods(String goodsId, String serviceGoodsName,
			Integer serviceGoodsTimeUnit, String serviceGoodsDesc,
			Double serviceGoodsMargin) {
		this.goodsId = goodsId;
		this.serviceGoodsName = serviceGoodsName;
		this.serviceGoodsTimeUnit = serviceGoodsTimeUnit;
		this.serviceGoodsDesc = serviceGoodsDesc;
		this.serviceGoodsMargin = serviceGoodsMargin;
	}

	// Property accessors

	public String getServiceGoodsId() {
		return this.serviceGoodsId;
	}

	public void setServiceGoodsId(String serviceGoodsId) {
		this.serviceGoodsId = serviceGoodsId;
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getServiceGoodsName() {
		return this.serviceGoodsName;
	}

	public void setServiceGoodsName(String serviceGoodsName) {
		this.serviceGoodsName = serviceGoodsName;
	}

	public Integer getServiceGoodsTimeUnit() {
		return this.serviceGoodsTimeUnit;
	}

	public void setServiceGoodsTimeUnit(Integer serviceGoodsTimeUnit) {
		this.serviceGoodsTimeUnit = serviceGoodsTimeUnit;
	}

	public String getServiceGoodsDesc() {
		return this.serviceGoodsDesc;
	}

	public void setServiceGoodsDesc(String serviceGoodsDesc) {
		this.serviceGoodsDesc = serviceGoodsDesc;
	}

	public Double getServiceGoodsMargin() {
		return this.serviceGoodsMargin;
	}

	public void setServiceGoodsMargin(Double serviceGoodsMargin) {
		this.serviceGoodsMargin = serviceGoodsMargin;
	}

}