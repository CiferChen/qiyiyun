package com.zhidian.server.model;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private String articleId;
	private String articleTypeId;
	private Integer clickCount;
	private String articleContent;
	private String articleTime;
	private Integer articleIsDelete;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** full constructor */
	public Article(String articleTypeId, Integer clickCount,
			String articleContent, String articleTime, Integer articleIsDelete) {
		this.articleTypeId = articleTypeId;
		this.clickCount = clickCount;
		this.articleContent = articleContent;
		this.articleTime = articleTime;
		this.articleIsDelete = articleIsDelete;
	}

	// Property accessors

	public String getArticleId() {
		return this.articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleTypeId() {
		return this.articleTypeId;
	}

	public void setArticleTypeId(String articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleTime() {
		return this.articleTime;
	}

	public void setArticleTime(String articleTime) {
		this.articleTime = articleTime;
	}

	public Integer getArticleIsDelete() {
		return this.articleIsDelete;
	}

	public void setArticleIsDelete(Integer articleIsDelete) {
		this.articleIsDelete = articleIsDelete;
	}

}