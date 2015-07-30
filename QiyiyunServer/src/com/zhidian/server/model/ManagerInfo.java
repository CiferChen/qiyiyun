package com.zhidian.server.model;

/**
 * ManagerInfo entity. @author MyEclipse Persistence Tools
 */

public class ManagerInfo implements java.io.Serializable {

	// Fields

	private String managerId;
	private String managerRoleId;
	private String managerPersonName;
	private Integer managerAge;
	private Integer managerCertificationType;
	private String managerCeritficationNumber;
	private String managerPhone;
	private String managerEmail;

	// Constructors

	/** default constructor */
	public ManagerInfo() {
	}

	/** full constructor */
	public ManagerInfo(String managerRoleId, String managerPersonName,
			Integer managerAge, Integer managerCertificationType,
			String managerCeritficationNumber, String managerPhone,
			String managerEmail) {
		this.managerRoleId = managerRoleId;
		this.managerPersonName = managerPersonName;
		this.managerAge = managerAge;
		this.managerCertificationType = managerCertificationType;
		this.managerCeritficationNumber = managerCeritficationNumber;
		this.managerPhone = managerPhone;
		this.managerEmail = managerEmail;
	}

	// Property accessors

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerRoleId() {
		return this.managerRoleId;
	}

	public void setManagerRoleId(String managerRoleId) {
		this.managerRoleId = managerRoleId;
	}

	public String getManagerPersonName() {
		return this.managerPersonName;
	}

	public void setManagerPersonName(String managerPersonName) {
		this.managerPersonName = managerPersonName;
	}

	public Integer getManagerAge() {
		return this.managerAge;
	}

	public void setManagerAge(Integer managerAge) {
		this.managerAge = managerAge;
	}

	public Integer getManagerCertificationType() {
		return this.managerCertificationType;
	}

	public void setManagerCertificationType(Integer managerCertificationType) {
		this.managerCertificationType = managerCertificationType;
	}

	public String getManagerCeritficationNumber() {
		return this.managerCeritficationNumber;
	}

	public void setManagerCeritficationNumber(String managerCeritficationNumber) {
		this.managerCeritficationNumber = managerCeritficationNumber;
	}

	public String getManagerPhone() {
		return this.managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerEmail() {
		return this.managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

}