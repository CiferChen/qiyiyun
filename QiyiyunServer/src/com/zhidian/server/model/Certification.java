package com.zhidian.server.model;

/**
 * Certification entity. @author MyEclipse Persistence Tools
 */

public class Certification implements java.io.Serializable {

	// Fields

	private String certificationId;
	private String certificationTypeId;
	private Integer certificationObject;
	private String certificationTime;
	private String certificationName;
	private String certificationNumber;
	private String certificationImage;
	private Integer certificationStatus;

	// Constructors

	/** default constructor */
	public Certification() {
	}

	/** full constructor */
	public Certification(String certificationTypeId,
			Integer certificationObject, String certificationTime,
			String certificationName, String certificationNumber,
			String certificationImage, Integer certificationStatus) {
		this.certificationTypeId = certificationTypeId;
		this.certificationObject = certificationObject;
		this.certificationTime = certificationTime;
		this.certificationName = certificationName;
		this.certificationNumber = certificationNumber;
		this.certificationImage = certificationImage;
		this.certificationStatus = certificationStatus;
	}

	// Property accessors

	public String getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}

	public String getCertificationTypeId() {
		return this.certificationTypeId;
	}

	public void setCertificationTypeId(String certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
	}

	public Integer getCertificationObject() {
		return this.certificationObject;
	}

	public void setCertificationObject(Integer certificationObject) {
		this.certificationObject = certificationObject;
	}

	public String getCertificationTime() {
		return this.certificationTime;
	}

	public void setCertificationTime(String certificationTime) {
		this.certificationTime = certificationTime;
	}

	public String getCertificationName() {
		return this.certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getCertificationNumber() {
		return this.certificationNumber;
	}

	public void setCertificationNumber(String certificationNumber) {
		this.certificationNumber = certificationNumber;
	}

	public String getCertificationImage() {
		return this.certificationImage;
	}

	public void setCertificationImage(String certificationImage) {
		this.certificationImage = certificationImage;
	}

	public Integer getCertificationStatus() {
		return this.certificationStatus;
	}

	public void setCertificationStatus(Integer certificationStatus) {
		this.certificationStatus = certificationStatus;
	}

}