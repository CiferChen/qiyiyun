package com.zhidian.server.model;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */

public class Favorite implements java.io.Serializable {

	// Fields

	private String favoriteId;
	private String userId;
	private String goodsId;
	private String serviceGoodsId;

	// Constructors

	/** default constructor */
	public Favorite() {
	}

	/** minimal constructor */
	public Favorite(String userId, String goodsId) {
		this.userId = userId;
		this.goodsId = goodsId;
	}

	/** full constructor */
	public Favorite(String userId, String goodsId, String serviceGoodsId) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.serviceGoodsId = serviceGoodsId;
	}

	// Property accessors

	public String getFavoriteId() {
		return this.favoriteId;
	}

	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getServiceGoodsId() {
		return this.serviceGoodsId;
	}

	public void setServiceGoodsId(String serviceGoodsId) {
		this.serviceGoodsId = serviceGoodsId;
	}

}