package com.zhidian.server.model;

/**
 * ManagerRoleRightRel entity. @author MyEclipse Persistence Tools
 */

public class ManagerRoleRightRel implements java.io.Serializable {

	// Fields

	private String managerroleRightId;
	private String managerRoleId;
	private String rightId;

	// Constructors

	/** default constructor */
	public ManagerRoleRightRel() {
	}

	/** full constructor */
	public ManagerRoleRightRel(String managerRoleId, String rightId) {
		this.managerRoleId = managerRoleId;
		this.rightId = rightId;
	}

	// Property accessors

	public String getManagerroleRightId() {
		return this.managerroleRightId;
	}

	public void setManagerroleRightId(String managerroleRightId) {
		this.managerroleRightId = managerroleRightId;
	}

	public String getManagerRoleId() {
		return this.managerRoleId;
	}

	public void setManagerRoleId(String managerRoleId) {
		this.managerRoleId = managerRoleId;
	}

	public String getRightId() {
		return this.rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

}