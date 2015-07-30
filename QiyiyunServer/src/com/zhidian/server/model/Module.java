package com.zhidian.server.model;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private String moduleId;
	private String moduleName;
	private String moduleDesc;
	private String moduleUpTime;
	private String moduleShortDesc;
	private Integer moduleIsDelete;

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** minimal constructor */
	public Module(String moduleName, String moduleUpTime,
			String moduleShortDesc, Integer moduleIsDelete) {
		this.moduleName = moduleName;
		this.moduleUpTime = moduleUpTime;
		this.moduleShortDesc = moduleShortDesc;
		this.moduleIsDelete = moduleIsDelete;
	}

	/** full constructor */
	public Module(String moduleName, String moduleDesc, String moduleUpTime,
			String moduleShortDesc, Integer moduleIsDelete) {
		this.moduleName = moduleName;
		this.moduleDesc = moduleDesc;
		this.moduleUpTime = moduleUpTime;
		this.moduleShortDesc = moduleShortDesc;
		this.moduleIsDelete = moduleIsDelete;
	}

	// Property accessors

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDesc() {
		return this.moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleUpTime() {
		return this.moduleUpTime;
	}

	public void setModuleUpTime(String moduleUpTime) {
		this.moduleUpTime = moduleUpTime;
	}

	public String getModuleShortDesc() {
		return this.moduleShortDesc;
	}

	public void setModuleShortDesc(String moduleShortDesc) {
		this.moduleShortDesc = moduleShortDesc;
	}

	public Integer getModuleIsDelete() {
		return this.moduleIsDelete;
	}

	public void setModuleIsDelete(Integer moduleIsDelete) {
		this.moduleIsDelete = moduleIsDelete;
	}

}