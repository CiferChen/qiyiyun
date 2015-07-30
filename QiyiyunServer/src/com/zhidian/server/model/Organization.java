package com.zhidian.server.model;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */

public class Organization implements java.io.Serializable {

	// Fields

	private String organId;
	private String organName;
	private String createTime;
	private String createrId;
	private String organDescription;
	private String organAddress;
	private String organTypeId;
	private String contactName;
	private String contactPhone;
	private String contactEmail;

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** minimal constructor */
	public Organization(String organName, String createTime, String createrId,
			String organTypeId) {
		this.organName = organName;
		this.createTime = createTime;
		this.createrId = createrId;
		this.organTypeId = organTypeId;
	}

	/** full constructor */
	public Organization(String organName, String createTime, String createrId,
			String organDescription, String organAddress, String organTypeId,
			String contactName, String contactPhone, String contactEmail) {
		this.organName = organName;
		this.createTime = createTime;
		this.createrId = createrId;
		this.organDescription = organDescription;
		this.organAddress = organAddress;
		this.organTypeId = organTypeId;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
	}

	// Property accessors

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getOrganDescription() {
		return this.organDescription;
	}

	public void setOrganDescription(String organDescription) {
		this.organDescription = organDescription;
	}

	public String getOrganAddress() {
		return this.organAddress;
	}

	public void setOrganAddress(String organAddress) {
		this.organAddress = organAddress;
	}

	public String getOrganTypeId() {
		return this.organTypeId;
	}

	public void setOrganTypeId(String organTypeId) {
		this.organTypeId = organTypeId;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

}