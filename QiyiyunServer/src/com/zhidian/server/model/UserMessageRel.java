package com.zhidian.server.model;

/**
 * UserMessageRel entity. @author MyEclipse Persistence Tools
 */

public class UserMessageRel implements java.io.Serializable {

	// Fields

	private String userMessageId;
	private String userId;
	private String messageId;

	// Constructors

	/** default constructor */
	public UserMessageRel() {
	}

	/** full constructor */
	public UserMessageRel(String userId, String messageId) {
		this.userId = userId;
		this.messageId = messageId;
	}

	// Property accessors

	public String getUserMessageId() {
		return this.userMessageId;
	}

	public void setUserMessageId(String userMessageId) {
		this.userMessageId = userMessageId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}