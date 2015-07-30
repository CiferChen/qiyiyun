package com.zhidian.server.model;

/**
 * MessageTemplet entity. @author MyEclipse Persistence Tools
 */

public class MessageTemplet implements java.io.Serializable {

	// Fields

	private String messageTempletId;
	private String messageTempletTypeId;
	private String messageTempletContent;
	private Integer messageTempletIsDelete;

	// Constructors

	/** default constructor */
	public MessageTemplet() {
	}

	/** full constructor */
	public MessageTemplet(String messageTempletTypeId,
			String messageTempletContent, Integer messageTempletIsDelete) {
		this.messageTempletTypeId = messageTempletTypeId;
		this.messageTempletContent = messageTempletContent;
		this.messageTempletIsDelete = messageTempletIsDelete;
	}

	// Property accessors

	public String getMessageTempletId() {
		return this.messageTempletId;
	}

	public void setMessageTempletId(String messageTempletId) {
		this.messageTempletId = messageTempletId;
	}

	public String getMessageTempletTypeId() {
		return this.messageTempletTypeId;
	}

	public void setMessageTempletTypeId(String messageTempletTypeId) {
		this.messageTempletTypeId = messageTempletTypeId;
	}

	public String getMessageTempletContent() {
		return this.messageTempletContent;
	}

	public void setMessageTempletContent(String messageTempletContent) {
		this.messageTempletContent = messageTempletContent;
	}

	public Integer getMessageTempletIsDelete() {
		return this.messageTempletIsDelete;
	}

	public void setMessageTempletIsDelete(Integer messageTempletIsDelete) {
		this.messageTempletIsDelete = messageTempletIsDelete;
	}

}