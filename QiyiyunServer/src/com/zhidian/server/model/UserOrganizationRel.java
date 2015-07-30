package com.zhidian.server.model;

/**
 * UserOrganizationRel entity. @author MyEclipse Persistence Tools
 */

public class UserOrganizationRel implements java.io.Serializable {

	// Fields

	private String userOrganId;
	private String userId;
	private String organId;

	// Constructors

	/** default constructor */
	public UserOrganizationRel() {
	}

	/** full constructor */
	public UserOrganizationRel(String userId, String organId) {
		this.userId = userId;
		this.organId = organId;
	}

	// Property accessors

	public String getUserOrganId() {
		return this.userOrganId;
	}

	public void setUserOrganId(String userOrganId) {
		this.userOrganId = userOrganId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

}