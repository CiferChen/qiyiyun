package com.zhidian.server.model;

/**
 * Service entity. @author MyEclipse Persistence Tools
 */

public class Service implements java.io.Serializable {

	// Fields

	private String serviceId;
	private String seiviceGoodsId;
	private String serviceTypeId;
	private String serviceBookTime;
	private String serviceStartTime;
	private String serviceEndTime;
	private Integer serviceStatus;
	private Integer serviceIsDelete;

	// Constructors

	/** default constructor */
	public Service() {
	}

	/** full constructor */
	public Service(String seiviceGoodsId, String serviceTypeId,
			String serviceBookTime, String serviceStartTime,
			String serviceEndTime, Integer serviceStatus,
			Integer serviceIsDelete) {
		this.seiviceGoodsId = seiviceGoodsId;
		this.serviceTypeId = serviceTypeId;
		this.serviceBookTime = serviceBookTime;
		this.serviceStartTime = serviceStartTime;
		this.serviceEndTime = serviceEndTime;
		this.serviceStatus = serviceStatus;
		this.serviceIsDelete = serviceIsDelete;
	}

	// Property accessors

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSeiviceGoodsId() {
		return this.seiviceGoodsId;
	}

	public void setSeiviceGoodsId(String seiviceGoodsId) {
		this.seiviceGoodsId = seiviceGoodsId;
	}

	public String getServiceTypeId() {
		return this.serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceBookTime() {
		return this.serviceBookTime;
	}

	public void setServiceBookTime(String serviceBookTime) {
		this.serviceBookTime = serviceBookTime;
	}

	public String getServiceStartTime() {
		return this.serviceStartTime;
	}

	public void setServiceStartTime(String serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	public String getServiceEndTime() {
		return this.serviceEndTime;
	}

	public void setServiceEndTime(String serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}

	public Integer getServiceStatus() {
		return this.serviceStatus;
	}

	public void setServiceStatus(Integer serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public Integer getServiceIsDelete() {
		return this.serviceIsDelete;
	}

	public void setServiceIsDelete(Integer serviceIsDelete) {
		this.serviceIsDelete = serviceIsDelete;
	}

}