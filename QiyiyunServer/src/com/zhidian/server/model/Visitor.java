package com.zhidian.server.model;

/**
 * Visitor entity. @author MyEclipse Persistence Tools
 */

public class Visitor implements java.io.Serializable {

	// Fields

	private String visitorId;
	private String visitorName;
	private String visitorPhone;
	private String visitorEmail;
	private String visitorStartTime;
	private String userId;
	private String userPersonId;
	private String organId;
	private Integer visitorIsDelete;

	// Constructors

	/** default constructor */
	public Visitor() {
	}

	/** full constructor */
	public Visitor(String visitorName, String visitorPhone,
			String visitorEmail, String visitorStartTime, String userId,
			String userPersonId, String organId, Integer visitorIsDelete) {
		this.visitorName = visitorName;
		this.visitorPhone = visitorPhone;
		this.visitorEmail = visitorEmail;
		this.visitorStartTime = visitorStartTime;
		this.userId = userId;
		this.userPersonId = userPersonId;
		this.organId = organId;
		this.visitorIsDelete = visitorIsDelete;
	}

	// Property accessors

	public String getVisitorId() {
		return this.visitorId;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return this.visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorPhone() {
		return this.visitorPhone;
	}

	public void setVisitorPhone(String visitorPhone) {
		this.visitorPhone = visitorPhone;
	}

	public String getVisitorEmail() {
		return this.visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public String getVisitorStartTime() {
		return this.visitorStartTime;
	}

	public void setVisitorStartTime(String visitorStartTime) {
		this.visitorStartTime = visitorStartTime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPersonId() {
		return this.userPersonId;
	}

	public void setUserPersonId(String userPersonId) {
		this.userPersonId = userPersonId;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public Integer getVisitorIsDelete() {
		return this.visitorIsDelete;
	}

	public void setVisitorIsDelete(Integer visitorIsDelete) {
		this.visitorIsDelete = visitorIsDelete;
	}

}