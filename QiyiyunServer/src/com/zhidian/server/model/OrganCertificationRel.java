package com.zhidian.server.model;

/**
 * OrganCertificationRel entity. @author MyEclipse Persistence Tools
 */

public class OrganCertificationRel implements java.io.Serializable {

	// Fields

	private String organCertificationId;
	private String organId;
	private String certificationId;

	// Constructors

	/** default constructor */
	public OrganCertificationRel() {
	}

	/** full constructor */
	public OrganCertificationRel(String organId, String certificationId) {
		this.organId = organId;
		this.certificationId = certificationId;
	}

	// Property accessors

	public String getOrganCertificationId() {
		return this.organCertificationId;
	}

	public void setOrganCertificationId(String organCertificationId) {
		this.organCertificationId = organCertificationId;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}

}