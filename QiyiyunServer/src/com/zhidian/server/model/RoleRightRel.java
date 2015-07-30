package com.zhidian.server.model;

/**
 * RoleRightRel entity. @author MyEclipse Persistence Tools
 */

public class RoleRightRel implements java.io.Serializable {

	// Fields

	private String roleRightId;
	private String roleId;
	private String rightId;

	// Constructors

	/** default constructor */
	public RoleRightRel() {
	}

	/** full constructor */
	public RoleRightRel(String roleId, String rightId) {
		this.roleId = roleId;
		this.rightId = rightId;
	}

	// Property accessors

	public String getRoleRightId() {
		return this.roleRightId;
	}

	public void setRoleRightId(String roleRightId) {
		this.roleRightId = roleRightId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRightId() {
		return this.rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

}