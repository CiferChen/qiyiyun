package com.zhidian.server.model;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */

public class Collection implements java.io.Serializable {

	// Fields

	private String collectionId;
	private String collectionTitle;
	private String targetTable;
	private String targetId;
	private String collectionTime;
	private Integer operatorId;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** full constructor */
	public Collection(String collectionTitle, String targetTable,
			String targetId, String collectionTime, Integer operatorId) {
		this.collectionTitle = collectionTitle;
		this.targetTable = targetTable;
		this.targetId = targetId;
		this.collectionTime = collectionTime;
		this.operatorId = operatorId;
	}

	// Property accessors

	public String getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionTitle() {
		return this.collectionTitle;
	}

	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}

	public String getTargetTable() {
		return this.targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public String getTargetId() {
		return this.targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getCollectionTime() {
		return this.collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}

	public Integer getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

}