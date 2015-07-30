package com.zhidian.server.model;

/**
 * OrganizationType entity. @author MyEclipse Persistence Tools
 */

public class OrganizationType implements java.io.Serializable {

	// Fields

	private String organTypeId;
	private String organTypeName;
	private Integer organTypeIsDelete;

	// Constructors

	/** default constructor */
	public OrganizationType() {
	}

	/** full constructor */
	public OrganizationType(String organTypeName, Integer organTypeIsDelete) {
		this.organTypeName = organTypeName;
		this.organTypeIsDelete = organTypeIsDelete;
	}

	// Property accessors

	public String getOrganTypeId() {
		return this.organTypeId;
	}

	public void setOrganTypeId(String organTypeId) {
		this.organTypeId = organTypeId;
	}

	public String getOrganTypeName() {
		return this.organTypeName;
	}

	public void setOrganTypeName(String organTypeName) {
		this.organTypeName = organTypeName;
	}

	public Integer getOrganTypeIsDelete() {
		return this.organTypeIsDelete;
	}

	public void setOrganTypeIsDelete(Integer organTypeIsDelete) {
		this.organTypeIsDelete = organTypeIsDelete;
	}

}