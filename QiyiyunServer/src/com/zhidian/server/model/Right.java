package com.zhidian.server.model;

/**
 * Right entity. @author MyEclipse Persistence Tools
 */

public class Right implements java.io.Serializable {

	// Fields

	private String rightId;
	private Integer rightType;
	private String rightName;
	private String rightDescription;

	// Constructors

	/** default constructor */
	public Right() {
	}

	/** minimal constructor */
	public Right(Integer rightType, String rightName) {
		this.rightType = rightType;
		this.rightName = rightName;
	}

	/** full constructor */
	public Right(Integer rightType, String rightName, String rightDescription) {
		this.rightType = rightType;
		this.rightName = rightName;
		this.rightDescription = rightDescription;
	}

	// Property accessors

	public String getRightId() {
		return this.rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

	public Integer getRightType() {
		return this.rightType;
	}

	public void setRightType(Integer rightType) {
		this.rightType = rightType;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getRightDescription() {
		return this.rightDescription;
	}

	public void setRightDescription(String rightDescription) {
		this.rightDescription = rightDescription;
	}

}