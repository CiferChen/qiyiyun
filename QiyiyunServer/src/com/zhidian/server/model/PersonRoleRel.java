package com.zhidian.server.model;

/**
 * PersonRoleRel entity. @author MyEclipse Persistence Tools
 */

public class PersonRoleRel implements java.io.Serializable {

	// Fields

	private String personRoelId;
	private String personId;
	private String roleId;

	// Constructors

	/** default constructor */
	public PersonRoleRel() {
	}

	/** full constructor */
	public PersonRoleRel(String personId, String roleId) {
		this.personId = personId;
		this.roleId = roleId;
	}

	// Property accessors

	public String getPersonRoelId() {
		return this.personRoelId;
	}

	public void setPersonRoelId(String personRoelId) {
		this.personRoelId = personRoelId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}