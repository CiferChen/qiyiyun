package com.zhidian.server.model;

/**
 * PersonCertificationRel entity. @author MyEclipse Persistence Tools
 */

public class PersonCertificationRel implements java.io.Serializable {

	// Fields

	private String personCertificationId;
	private String personId;
	private String certificationId;

	// Constructors

	/** default constructor */
	public PersonCertificationRel() {
	}

	/** full constructor */
	public PersonCertificationRel(String personId, String certificationId) {
		this.personId = personId;
		this.certificationId = certificationId;
	}

	// Property accessors

	public String getPersonCertificationId() {
		return this.personCertificationId;
	}

	public void setPersonCertificationId(String personCertificationId) {
		this.personCertificationId = personCertificationId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}

}