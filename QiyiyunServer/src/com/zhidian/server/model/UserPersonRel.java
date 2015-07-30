package com.zhidian.server.model;

/**
 * UserPersonRel entity. @author MyEclipse Persistence Tools
 */

public class UserPersonRel implements java.io.Serializable {

	// Fields

	private String userPersonId;
	private String userId;
	private String personId;

	// Constructors

	/** default constructor */
	public UserPersonRel() {
	}

	/** full constructor */
	public UserPersonRel(String userId, String personId) {
		this.userId = userId;
		this.personId = personId;
	}

	// Property accessors

	public String getUserPersonId() {
		return this.userPersonId;
	}

	public void setUserPersonId(String userPersonId) {
		this.userPersonId = userPersonId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}