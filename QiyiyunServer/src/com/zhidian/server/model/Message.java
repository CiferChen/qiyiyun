package com.zhidian.server.model;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private String messageId;
	private MessageType messageType;
	private String messageTitle;
	private String content;
	private String createTime;
	private String sendTime;
	private String messageCreatorId;
	private String messageReceiverId;
	private Integer messageIsDelete;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(MessageType messageType, String messageTitle,
			String createTime, String messageCreatorId,
			String messageReceiverId, Integer messageIsDelete) {
		this.messageType = messageType;
		this.messageTitle = messageTitle;
		this.createTime = createTime;
		this.messageCreatorId = messageCreatorId;
		this.messageReceiverId = messageReceiverId;
		this.messageIsDelete = messageIsDelete;
	}

	/** full constructor */
	public Message(MessageType messageType, String messageTitle,
			String content, String createTime, String sendTime,
			String messageCreatorId, String messageReceiverId,
			Integer messageIsDelete) {
		this.messageType = messageType;
		this.messageTitle = messageTitle;
		this.content = content;
		this.createTime = createTime;
		this.sendTime = sendTime;
		this.messageCreatorId = messageCreatorId;
		this.messageReceiverId = messageReceiverId;
		this.messageIsDelete = messageIsDelete;
	}

	// Property accessors

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getMessageTitle() {
		return this.messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMessageCreatorId() {
		return this.messageCreatorId;
	}

	public void setMessageCreatorId(String messageCreatorId) {
		this.messageCreatorId = messageCreatorId;
	}

	public String getMessageReceiverId() {
		return this.messageReceiverId;
	}

	public void setMessageReceiverId(String messageReceiverId) {
		this.messageReceiverId = messageReceiverId;
	}

	public Integer getMessageIsDelete() {
		return this.messageIsDelete;
	}

	public void setMessageIsDelete(Integer messageIsDelete) {
		this.messageIsDelete = messageIsDelete;
	}

}