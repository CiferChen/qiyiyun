package com.zhidian.server.model;

/**
 * UserWords entity. @author MyEclipse Persistence Tools
 */

public class UserWords implements java.io.Serializable {

	// Fields

	private String userWordsId;
	private String userWordsTypeId;
	private String userWordsContent;
	private String orderId;
	private String createTime;
	private Integer userWordsIsDelete;

	// Constructors

	/** default constructor */
	public UserWords() {
	}

	/** minimal constructor */
	public UserWords(String userWordsTypeId, String userWordsContent,
			String createTime, Integer userWordsIsDelete) {
		this.userWordsTypeId = userWordsTypeId;
		this.userWordsContent = userWordsContent;
		this.createTime = createTime;
		this.userWordsIsDelete = userWordsIsDelete;
	}

	/** full constructor */
	public UserWords(String userWordsTypeId, String userWordsContent,
			String orderId, String createTime, Integer userWordsIsDelete) {
		this.userWordsTypeId = userWordsTypeId;
		this.userWordsContent = userWordsContent;
		this.orderId = orderId;
		this.createTime = createTime;
		this.userWordsIsDelete = userWordsIsDelete;
	}

	// Property accessors

	public String getUserWordsId() {
		return this.userWordsId;
	}

	public void setUserWordsId(String userWordsId) {
		this.userWordsId = userWordsId;
	}

	public String getUserWordsTypeId() {
		return this.userWordsTypeId;
	}

	public void setUserWordsTypeId(String userWordsTypeId) {
		this.userWordsTypeId = userWordsTypeId;
	}

	public String getUserWordsContent() {
		return this.userWordsContent;
	}

	public void setUserWordsContent(String userWordsContent) {
		this.userWordsContent = userWordsContent;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUserWordsIsDelete() {
		return this.userWordsIsDelete;
	}

	public void setUserWordsIsDelete(Integer userWordsIsDelete) {
		this.userWordsIsDelete = userWordsIsDelete;
	}

}