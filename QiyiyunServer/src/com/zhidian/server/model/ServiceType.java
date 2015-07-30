package com.zhidian.server.model;

/**
 * ServiceType entity. @author MyEclipse Persistence Tools
 */

public class ServiceType implements java.io.Serializable {

	// Fields

	private String serviceTypeId;
	private String serviceTypeName;
	private Integer serviceTypeIsDelete;

	// Constructors

	/** default constructor */
	public ServiceType() {
	}

	/** full constructor */
	public ServiceType(String serviceTypeName, Integer serviceTypeIsDelete) {
		this.serviceTypeName = serviceTypeName;
		this.serviceTypeIsDelete = serviceTypeIsDelete;
	}

	// Property accessors

	public String getServiceTypeId() {
		return this.serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceTypeName() {
		return this.serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	public Integer getServiceTypeIsDelete() {
		return this.serviceTypeIsDelete;
	}

	public void setServiceTypeIsDelete(Integer serviceTypeIsDelete) {
		this.serviceTypeIsDelete = serviceTypeIsDelete;
	}

}