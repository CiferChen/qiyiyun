package com.zhidian.server.model;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;
	private String departmentId;
	private String roleDesc;
	private Integer roleIsDelete;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleName, String departmentId, String roleDesc,
			Integer roleIsDelete) {
		this.roleName = roleName;
		this.departmentId = departmentId;
		this.roleDesc = roleDesc;
		this.roleIsDelete = roleIsDelete;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleIsDelete() {
		return this.roleIsDelete;
	}

	public void setRoleIsDelete(Integer roleIsDelete) {
		this.roleIsDelete = roleIsDelete;
	}

}