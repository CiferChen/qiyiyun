package com.zhidian.server.model;

/**
 * MessageTempletType entity. @author MyEclipse Persistence Tools
 */

public class MessageTempletType implements java.io.Serializable {

	// Fields

	private String messageTempletTypeId;
	private String messageTempletTypeName;
	private Integer messageTempletIsDelete;

	// Constructors

	/** default constructor */
	public MessageTempletType() {
	}

	/** full constructor */
	public MessageTempletType(String messageTempletTypeName,
			Integer messageTempletIsDelete) {
		this.messageTempletTypeName = messageTempletTypeName;
		this.messageTempletIsDelete = messageTempletIsDelete;
	}

	// Property accessors

	public String getMessageTempletTypeId() {
		return this.messageTempletTypeId;
	}

	public void setMessageTempletTypeId(String messageTempletTypeId) {
		this.messageTempletTypeId = messageTempletTypeId;
	}

	public String getMessageTempletTypeName() {
		return this.messageTempletTypeName;
	}

	public void setMessageTempletTypeName(String messageTempletTypeName) {
		this.messageTempletTypeName = messageTempletTypeName;
	}

	public Integer getMessageTempletIsDelete() {
		return this.messageTempletIsDelete;
	}

	public void setMessageTempletIsDelete(Integer messageTempletIsDelete) {
		this.messageTempletIsDelete = messageTempletIsDelete;
	}

}