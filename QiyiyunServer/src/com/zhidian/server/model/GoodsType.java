package com.zhidian.server.model;

/**
 * GoodsType entity. @author MyEclipse Persistence Tools
 */

public class GoodsType implements java.io.Serializable {

	// Fields

	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsTypeParentId;
	private String goodsTypeKeywords;
	private Integer goodsTypeIsDelete;

	// Constructors

	/** default constructor */
	public GoodsType() {
	}

	/** full constructor */
	public GoodsType(String goodsTypeName, String goodsTypeParentId,
			String goodsTypeKeywords, Integer goodsTypeIsDelete) {
		this.goodsTypeName = goodsTypeName;
		this.goodsTypeParentId = goodsTypeParentId;
		this.goodsTypeKeywords = goodsTypeKeywords;
		this.goodsTypeIsDelete = goodsTypeIsDelete;
	}

	// Property accessors

	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public String getGoodsTypeParentId() {
		return this.goodsTypeParentId;
	}

	public void setGoodsTypeParentId(String goodsTypeParentId) {
		this.goodsTypeParentId = goodsTypeParentId;
	}

	public String getGoodsTypeKeywords() {
		return this.goodsTypeKeywords;
	}

	public void setGoodsTypeKeywords(String goodsTypeKeywords) {
		this.goodsTypeKeywords = goodsTypeKeywords;
	}

	public Integer getGoodsTypeIsDelete() {
		return this.goodsTypeIsDelete;
	}

	public void setGoodsTypeIsDelete(Integer goodsTypeIsDelete) {
		this.goodsTypeIsDelete = goodsTypeIsDelete;
	}

}