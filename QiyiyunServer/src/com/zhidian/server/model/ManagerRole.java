package com.zhidian.server.model;

/**
 * ManagerRole entity. @author MyEclipse Persistence Tools
 */

public class ManagerRole implements java.io.Serializable {

	// Fields

	private String managerRoleId;
	private String managerRoleName;
	private String managerRoleDescription;
	private Integer managerRoleIsDelete;

	// Constructors

	/** default constructor */
	public ManagerRole() {
	}

	/** full constructor */
	public ManagerRole(String managerRoleName, String managerRoleDescription,
			Integer managerRoleIsDelete) {
		this.managerRoleName = managerRoleName;
		this.managerRoleDescription = managerRoleDescription;
		this.managerRoleIsDelete = managerRoleIsDelete;
	}

	// Property accessors

	public String getManagerRoleId() {
		return this.managerRoleId;
	}

	public void setManagerRoleId(String managerRoleId) {
		this.managerRoleId = managerRoleId;
	}

	public String getManagerRoleName() {
		return this.managerRoleName;
	}

	public void setManagerRoleName(String managerRoleName) {
		this.managerRoleName = managerRoleName;
	}

	public String getManagerRoleDescription() {
		return this.managerRoleDescription;
	}

	public void setManagerRoleDescription(String managerRoleDescription) {
		this.managerRoleDescription = managerRoleDescription;
	}

	public Integer getManagerRoleIsDelete() {
		return this.managerRoleIsDelete;
	}

	public void setManagerRoleIsDelete(Integer managerRoleIsDelete) {
		this.managerRoleIsDelete = managerRoleIsDelete;
	}

}