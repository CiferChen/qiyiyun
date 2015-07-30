package com.zhidian.server.model;

/**
 * UserWordsType entity. @author MyEclipse Persistence Tools
 */

public class UserWordsType implements java.io.Serializable {

	// Fields

	private String userWordsTypeId;
	private String userWordsTypeName;
	private Integer userWordsTypeIsDelete;

	// Constructors

	/** default constructor */
	public UserWordsType() {
	}

	/** full constructor */
	public UserWordsType(String userWordsTypeName, Integer userWordsTypeIsDelete) {
		this.userWordsTypeName = userWordsTypeName;
		this.userWordsTypeIsDelete = userWordsTypeIsDelete;
	}

	// Property accessors

	public String getUserWordsTypeId() {
		return this.userWordsTypeId;
	}

	public void setUserWordsTypeId(String userWordsTypeId) {
		this.userWordsTypeId = userWordsTypeId;
	}

	public String getUserWordsTypeName() {
		return this.userWordsTypeName;
	}

	public void setUserWordsTypeName(String userWordsTypeName) {
		this.userWordsTypeName = userWordsTypeName;
	}

	public Integer getUserWordsTypeIsDelete() {
		return this.userWordsTypeIsDelete;
	}

	public void setUserWordsTypeIsDelete(Integer userWordsTypeIsDelete) {
		this.userWordsTypeIsDelete = userWordsTypeIsDelete;
	}

}