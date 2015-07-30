package com.zhidian.server.model;

/**
 * SMSInterface entity. @author MyEclipse Persistence Tools
 */

public class SMSInterface implements java.io.Serializable {

	// Fields

	private String smsInterfaceId;
	private String smsInterfaceName;
	private String smsInterfaceUrl;
	private String smsInterfaceUserName;
	private String smsInterfacePassword;
	private Integer smsInterfaceStatus;

	// Constructors

	/** default constructor */
	public SMSInterface() {
	}

	/** full constructor */
	public SMSInterface(String smsInterfaceName, String smsInterfaceUrl,
			String smsInterfaceUserName, String smsInterfacePassword,
			Integer smsInterfaceStatus) {
		this.smsInterfaceName = smsInterfaceName;
		this.smsInterfaceUrl = smsInterfaceUrl;
		this.smsInterfaceUserName = smsInterfaceUserName;
		this.smsInterfacePassword = smsInterfacePassword;
		this.smsInterfaceStatus = smsInterfaceStatus;
	}

	// Property accessors

	public String getSmsInterfaceId() {
		return this.smsInterfaceId;
	}

	public void setSmsInterfaceId(String smsInterfaceId) {
		this.smsInterfaceId = smsInterfaceId;
	}

	public String getSmsInterfaceName() {
		return this.smsInterfaceName;
	}

	public void setSmsInterfaceName(String smsInterfaceName) {
		this.smsInterfaceName = smsInterfaceName;
	}

	public String getSmsInterfaceUrl() {
		return this.smsInterfaceUrl;
	}

	public void setSmsInterfaceUrl(String smsInterfaceUrl) {
		this.smsInterfaceUrl = smsInterfaceUrl;
	}

	public String getSmsInterfaceUserName() {
		return this.smsInterfaceUserName;
	}

	public void setSmsInterfaceUserName(String smsInterfaceUserName) {
		this.smsInterfaceUserName = smsInterfaceUserName;
	}

	public String getSmsInterfacePassword() {
		return this.smsInterfacePassword;
	}

	public void setSmsInterfacePassword(String smsInterfacePassword) {
		this.smsInterfacePassword = smsInterfacePassword;
	}

	public Integer getSmsInterfaceStatus() {
		return this.smsInterfaceStatus;
	}

	public void setSmsInterfaceStatus(Integer smsInterfaceStatus) {
		this.smsInterfaceStatus = smsInterfaceStatus;
	}

}