package com.zhidian.server.model;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private String departmentId;
	private String departmentName;
	private String creatorId;
	private String createTime;
	private String organId;
	private String departmentDesc;
	private String departmentLeaderId;
	private Integer departmentIsDelete;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String departmentName, String creatorId,
			String createTime, String organId, String departmentDesc,
			String departmentLeaderId, Integer departmentIsDelete) {
		this.departmentName = departmentName;
		this.creatorId = creatorId;
		this.createTime = createTime;
		this.organId = organId;
		this.departmentDesc = departmentDesc;
		this.departmentLeaderId = departmentLeaderId;
		this.departmentIsDelete = departmentIsDelete;
	}

	// Property accessors

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getDepartmentDesc() {
		return this.departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public String getDepartmentLeaderId() {
		return this.departmentLeaderId;
	}

	public void setDepartmentLeaderId(String departmentLeaderId) {
		this.departmentLeaderId = departmentLeaderId;
	}

	public Integer getDepartmentIsDelete() {
		return this.departmentIsDelete;
	}

	public void setDepartmentIsDelete(Integer departmentIsDelete) {
		this.departmentIsDelete = departmentIsDelete;
	}

}