package com.zhidian.server.model;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private String goodsId;
	private String goodsTypeId;
	private String goodsName;
	private String goodsUpTime;
	private String goodsDownTime;
	private String goodsProvider;
	private String goodsKeyWords;
	private Double goodsPrice;
	private String goodsThumb;
	private String goodsImg;
	private String goodsOriginalImg;
	private String goodsDescription;
	private String goodsBriefDescription;
	private Integer goodsIsDelete;
	private String goodsSpaceId;
	private String goodsAreaId;
	private Integer goodsStatus;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(String goodsTypeId, String goodsName, Double goodsPrice,
			Integer goodsIsDelete, String goodsSpaceId, String goodsAreaId,
			Integer goodsStatus) {
		this.goodsTypeId = goodsTypeId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsIsDelete = goodsIsDelete;
		this.goodsSpaceId = goodsSpaceId;
		this.goodsAreaId = goodsAreaId;
		this.goodsStatus = goodsStatus;
	}

	/** full constructor */
	public Goods(String goodsTypeId, String goodsName, String goodsUpTime,
			String goodsDownTime, String goodsProvider, String goodsKeyWords,
			Double goodsPrice, String goodsThumb, String goodsImg,
			String goodsOriginalImg, String goodsDescription,
			String goodsBriefDescription, Integer goodsIsDelete,
			String goodsSpaceId, String goodsAreaId, Integer goodsStatus) {
		this.goodsTypeId = goodsTypeId;
		this.goodsName = goodsName;
		this.goodsUpTime = goodsUpTime;
		this.goodsDownTime = goodsDownTime;
		this.goodsProvider = goodsProvider;
		this.goodsKeyWords = goodsKeyWords;
		this.goodsPrice = goodsPrice;
		this.goodsThumb = goodsThumb;
		this.goodsImg = goodsImg;
		this.goodsOriginalImg = goodsOriginalImg;
		this.goodsDescription = goodsDescription;
		this.goodsBriefDescription = goodsBriefDescription;
		this.goodsIsDelete = goodsIsDelete;
		this.goodsSpaceId = goodsSpaceId;
		this.goodsAreaId = goodsAreaId;
		this.goodsStatus = goodsStatus;
	}

	// Property accessors

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsUpTime() {
		return this.goodsUpTime;
	}

	public void setGoodsUpTime(String goodsUpTime) {
		this.goodsUpTime = goodsUpTime;
	}

	public String getGoodsDownTime() {
		return this.goodsDownTime;
	}

	public void setGoodsDownTime(String goodsDownTime) {
		this.goodsDownTime = goodsDownTime;
	}

	public String getGoodsProvider() {
		return this.goodsProvider;
	}

	public void setGoodsProvider(String goodsProvider) {
		this.goodsProvider = goodsProvider;
	}

	public String getGoodsKeyWords() {
		return this.goodsKeyWords;
	}

	public void setGoodsKeyWords(String goodsKeyWords) {
		this.goodsKeyWords = goodsKeyWords;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsThumb() {
		return this.goodsThumb;
	}

	public void setGoodsThumb(String goodsThumb) {
		this.goodsThumb = goodsThumb;
	}

	public String getGoodsImg() {
		return this.goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getGoodsOriginalImg() {
		return this.goodsOriginalImg;
	}

	public void setGoodsOriginalImg(String goodsOriginalImg) {
		this.goodsOriginalImg = goodsOriginalImg;
	}

	public String getGoodsDescription() {
		return this.goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public String getGoodsBriefDescription() {
		return this.goodsBriefDescription;
	}

	public void setGoodsBriefDescription(String goodsBriefDescription) {
		this.goodsBriefDescription = goodsBriefDescription;
	}

	public Integer getGoodsIsDelete() {
		return this.goodsIsDelete;
	}

	public void setGoodsIsDelete(Integer goodsIsDelete) {
		this.goodsIsDelete = goodsIsDelete;
	}

	public String getGoodsSpaceId() {
		return this.goodsSpaceId;
	}

	public void setGoodsSpaceId(String goodsSpaceId) {
		this.goodsSpaceId = goodsSpaceId;
	}

	public String getGoodsAreaId() {
		return this.goodsAreaId;
	}

	public void setGoodsAreaId(String goodsAreaId) {
		this.goodsAreaId = goodsAreaId;
	}

	public Integer getGoodsStatus() {
		return this.goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

}