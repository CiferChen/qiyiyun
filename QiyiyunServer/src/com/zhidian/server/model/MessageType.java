package com.zhidian.server.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MessageType entity. @author MyEclipse Persistence Tools
 */

public class MessageType implements java.io.Serializable {

	// Fields

	private String messageTypeId;
	private String messageTypeName;
	private Integer messageTypeIsDelete;
	private Set messages = new HashSet(0);

	// Constructors

	/** default constructor */
	public MessageType() {
	}

	/** minimal constructor */
	public MessageType(String messageTypeName, Integer messageTypeIsDelete) {
		this.messageTypeName = messageTypeName;
		this.messageTypeIsDelete = messageTypeIsDelete;
	}

	/** full constructor */
	public MessageType(String messageTypeName, Integer messageTypeIsDelete,
			Set messages) {
		this.messageTypeName = messageTypeName;
		this.messageTypeIsDelete = messageTypeIsDelete;
		this.messages = messages;
	}

	// Property accessors

	public String getMessageTypeId() {
		return this.messageTypeId;
	}

	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageTypeName() {
		return this.messageTypeName;
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public Integer getMessageTypeIsDelete() {
		return this.messageTypeIsDelete;
	}

	public void setMessageTypeIsDelete(Integer messageTypeIsDelete) {
		this.messageTypeIsDelete = messageTypeIsDelete;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

}