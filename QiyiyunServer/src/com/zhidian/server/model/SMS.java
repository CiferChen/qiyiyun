package com.zhidian.server.model;

/**
 * SMS entity. @author MyEclipse Persistence Tools
 */

public class SMS implements java.io.Serializable {

	// Fields

	private String smsId;
	private String smsReceiver;
	private String smsContent;
	private String smsSendTime;
	private String smsSender;
	private Integer smsSendStatus;
	private Integer smsIsDelete;

	// Constructors

	/** default constructor */
	public SMS() {
	}

	/** full constructor */
	public SMS(String smsReceiver, String smsContent, String smsSendTime,
			String smsSender, Integer smsSendStatus, Integer smsIsDelete) {
		this.smsReceiver = smsReceiver;
		this.smsContent = smsContent;
		this.smsSendTime = smsSendTime;
		this.smsSender = smsSender;
		this.smsSendStatus = smsSendStatus;
		this.smsIsDelete = smsIsDelete;
	}

	// Property accessors

	public String getSmsId() {
		return this.smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getSmsReceiver() {
		return this.smsReceiver;
	}

	public void setSmsReceiver(String smsReceiver) {
		this.smsReceiver = smsReceiver;
	}

	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsSendTime() {
		return this.smsSendTime;
	}

	public void setSmsSendTime(String smsSendTime) {
		this.smsSendTime = smsSendTime;
	}

	public String getSmsSender() {
		return this.smsSender;
	}

	public void setSmsSender(String smsSender) {
		this.smsSender = smsSender;
	}

	public Integer getSmsSendStatus() {
		return this.smsSendStatus;
	}

	public void setSmsSendStatus(Integer smsSendStatus) {
		this.smsSendStatus = smsSendStatus;
	}

	public Integer getSmsIsDelete() {
		return this.smsIsDelete;
	}

	public void setSmsIsDelete(Integer smsIsDelete) {
		this.smsIsDelete = smsIsDelete;
	}

}