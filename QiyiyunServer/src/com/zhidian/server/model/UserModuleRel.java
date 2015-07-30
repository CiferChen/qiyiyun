package com.zhidian.server.model;

/**
 * UserModuleRel entity. @author MyEclipse Persistence Tools
 */

public class UserModuleRel implements java.io.Serializable {

	// Fields

	private String userModuleId;
	private String userId;
	private String moduleId;

	// Constructors

	/** default constructor */
	public UserModuleRel() {
	}

	/** full constructor */
	public UserModuleRel(String userId, String moduleId) {
		this.userId = userId;
		this.moduleId = moduleId;
	}

	// Property accessors

	public String getUserModuleId() {
		return this.userModuleId;
	}

	public void setUserModuleId(String userModuleId) {
		this.userModuleId = userModuleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

}