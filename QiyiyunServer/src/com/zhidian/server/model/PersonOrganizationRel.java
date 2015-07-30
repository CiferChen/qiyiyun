package com.zhidian.server.model;

/**
 * PersonOrganizationRel entity. @author MyEclipse Persistence Tools
 */

public class PersonOrganizationRel implements java.io.Serializable {

	// Fields

	private String personOrganId;
	private String personId;
	private String organId;

	// Constructors

	/** default constructor */
	public PersonOrganizationRel() {
	}

	/** full constructor */
	public PersonOrganizationRel(String personId, String organId) {
		this.personId = personId;
		this.organId = organId;
	}

	// Property accessors

	public String getPersonOrganId() {
		return this.personOrganId;
	}

	public void setPersonOrganId(String personOrganId) {
		this.personOrganId = personOrganId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

}