package com.zhidian.server.model;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private String managerId;
	private String managerName;
	private String managerPassword;
	private Integer managerIsDelete;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(String managerName, String managerPassword,
			Integer managerIsDelete) {
		this.managerName = managerName;
		this.managerPassword = managerPassword;
		this.managerIsDelete = managerIsDelete;
	}

	// Property accessors

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPassword() {
		return this.managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public Integer getManagerIsDelete() {
		return this.managerIsDelete;
	}

	public void setManagerIsDelete(Integer managerIsDelete) {
		this.managerIsDelete = managerIsDelete;
	}

}