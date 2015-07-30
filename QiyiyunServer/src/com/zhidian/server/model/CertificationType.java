package com.zhidian.server.model;

/**
 * CertificationType entity. @author MyEclipse Persistence Tools
 */

public class CertificationType implements java.io.Serializable {

	// Fields

	private String certificationTypeId;
	private String certificationTypeName;

	// Constructors

	/** default constructor */
	public CertificationType() {
	}

	/** full constructor */
	public CertificationType(String certificationTypeName) {
		this.certificationTypeName = certificationTypeName;
	}

	// Property accessors

	public String getCertificationTypeId() {
		return this.certificationTypeId;
	}

	public void setCertificationTypeId(String certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
	}

	public String getCertificationTypeName() {
		return this.certificationTypeName;
	}

	public void setCertificationTypeName(String certificationTypeName) {
		this.certificationTypeName = certificationTypeName;
	}

}