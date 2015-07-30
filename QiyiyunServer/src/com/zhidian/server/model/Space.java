package com.zhidian.server.model;

/**
 * Space entity. @author MyEclipse Persistence Tools
 */

public class Space implements java.io.Serializable {

	// Fields

	private String spaceId;
	private String spaceName;
	private String spaceAddress;
	private String spaceX;
	private String spaceY;
	private String spaceDescription;
	private String spaceImg;
	private String spaceLeaderId;
	private Integer spaceIsDelete;

	// Constructors

	/** default constructor */
	public Space() {
	}

	/** minimal constructor */
	public Space(String spaceName, String spaceAddress, Integer spaceIsDelete) {
		this.spaceName = spaceName;
		this.spaceAddress = spaceAddress;
		this.spaceIsDelete = spaceIsDelete;
	}

	/** full constructor */
	public Space(String spaceName, String spaceAddress, String spaceX,
			String spaceY, String spaceDescription, String spaceImg,
			String spaceLeaderId, Integer spaceIsDelete) {
		this.spaceName = spaceName;
		this.spaceAddress = spaceAddress;
		this.spaceX = spaceX;
		this.spaceY = spaceY;
		this.spaceDescription = spaceDescription;
		this.spaceImg = spaceImg;
		this.spaceLeaderId = spaceLeaderId;
		this.spaceIsDelete = spaceIsDelete;
	}

	// Property accessors

	public String getSpaceId() {
		return this.spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getSpaceName() {
		return this.spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getSpaceAddress() {
		return this.spaceAddress;
	}

	public void setSpaceAddress(String spaceAddress) {
		this.spaceAddress = spaceAddress;
	}

	public String getSpaceX() {
		return this.spaceX;
	}

	public void setSpaceX(String spaceX) {
		this.spaceX = spaceX;
	}

	public String getSpaceY() {
		return this.spaceY;
	}

	public void setSpaceY(String spaceY) {
		this.spaceY = spaceY;
	}

	public String getSpaceDescription() {
		return this.spaceDescription;
	}

	public void setSpaceDescription(String spaceDescription) {
		this.spaceDescription = spaceDescription;
	}

	public String getSpaceImg() {
		return this.spaceImg;
	}

	public void setSpaceImg(String spaceImg) {
		this.spaceImg = spaceImg;
	}

	public String getSpaceLeaderId() {
		return this.spaceLeaderId;
	}

	public void setSpaceLeaderId(String spaceLeaderId) {
		this.spaceLeaderId = spaceLeaderId;
	}

	public Integer getSpaceIsDelete() {
		return this.spaceIsDelete;
	}

	public void setSpaceIsDelete(Integer spaceIsDelete) {
		this.spaceIsDelete = spaceIsDelete;
	}

}