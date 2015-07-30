package com.zhidian.server.model;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private String areaId;
	private String spaceId;
	private String areaName;
	private String areaDescription;
	private String areaLeaderId;
	private String areaImg;
	private Integer areaIsDelete;

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(String spaceId, String areaName, String areaDescription,
			String areaLeaderId, String areaImg, Integer areaIsDelete) {
		this.spaceId = spaceId;
		this.areaName = areaName;
		this.areaDescription = areaDescription;
		this.areaLeaderId = areaLeaderId;
		this.areaImg = areaImg;
		this.areaIsDelete = areaIsDelete;
	}

	// Property accessors

	public String getAreaId() {
		return this.areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getSpaceId() {
		return this.spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaDescription() {
		return this.areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public String getAreaLeaderId() {
		return this.areaLeaderId;
	}

	public void setAreaLeaderId(String areaLeaderId) {
		this.areaLeaderId = areaLeaderId;
	}

	public String getAreaImg() {
		return this.areaImg;
	}

	public void setAreaImg(String areaImg) {
		this.areaImg = areaImg;
	}

	public Integer getAreaIsDelete() {
		return this.areaIsDelete;
	}

	public void setAreaIsDelete(Integer areaIsDelete) {
		this.areaIsDelete = areaIsDelete;
	}

}