package com.zhidian.server.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userPassword;
	private Integer userStatus;
	private Integer userIsdelete;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String userPassword, Integer userStatus,
			Integer userIsdelete) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
		this.userIsdelete = userIsdelete;
	}

	/** full constructor */
	public User(String userName, String userPhone, String userEmail,
			String userPassword, Integer userStatus, Integer userIsdelete) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
		this.userIsdelete = userIsdelete;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getUserIsdelete() {
		return this.userIsdelete;
	}

	public void setUserIsdelete(Integer userIsdelete) {
		this.userIsdelete = userIsdelete;
	}

}