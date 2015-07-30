package com.zhidian.server.model;

/**
 * ManagerRoleRel entity. @author MyEclipse Persistence Tools
 */

public class ManagerRoleRel implements java.io.Serializable {

	// Fields

	private String managerManagerroleId;
	private String managerId;
	private String managerRoleId;

	// Constructors

	/** default constructor */
	public ManagerRoleRel() {
	}

	/** full constructor */
	public ManagerRoleRel(String managerId, String managerRoleId) {
		this.managerId = managerId;
		this.managerRoleId = managerRoleId;
	}

	// Property accessors

	public String getManagerManagerroleId() {
		return this.managerManagerroleId;
	}

	public void setManagerManagerroleId(String managerManagerroleId) {
		this.managerManagerroleId = managerManagerroleId;
	}

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

}