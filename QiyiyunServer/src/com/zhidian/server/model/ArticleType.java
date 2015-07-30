package com.zhidian.server.model;

/**
 * ArticleType entity. @author MyEclipse Persistence Tools
 */

public class ArticleType implements java.io.Serializable {

	// Fields

	private String articleTypeId;
	private String articleTypeName;
	private Integer articleTypeIsDelete;

	// Constructors

	/** default constructor */
	public ArticleType() {
	}

	/** full constructor */
	public ArticleType(String articleTypeName, Integer articleTypeIsDelete) {
		this.articleTypeName = articleTypeName;
		this.articleTypeIsDelete = articleTypeIsDelete;
	}

	// Property accessors

	public String getArticleTypeId() {
		return this.articleTypeId;
	}

	public void setArticleTypeId(String articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public String getArticleTypeName() {
		return this.articleTypeName;
	}

	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	public Integer getArticleTypeIsDelete() {
		return this.articleTypeIsDelete;
	}

	public void setArticleTypeIsDelete(Integer articleTypeIsDelete) {
		this.articleTypeIsDelete = articleTypeIsDelete;
	}

}