package com.zhidian.server.model;

/**
 * ModuleRightRel entity. @author MyEclipse Persistence Tools
 */

public class ModuleRightRel implements java.io.Serializable {

	// Fields

	private String moduleRightId;
	private String moduleId;
	private String rightId;

	// Constructors

	/** default constructor */
	public ModuleRightRel() {
	}

	/** full constructor */
	public ModuleRightRel(String moduleId, String rightId) {
		this.moduleId = moduleId;
		this.rightId = rightId;
	}

	// Property accessors

	public String getModuleRightId() {
		return this.moduleRightId;
	}

	public void setModuleRightId(String moduleRightId) {
		this.moduleRightId = moduleRightId;
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getRightId() {
		return this.rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

}