package com.zhidian.server.model;

/**
 * Nav entity. @author MyEclipse Persistence Tools
 */

public class Nav implements java.io.Serializable {

	// Fields

	private String navId;
	private String navAddress;
	private String navImage;
	private Integer navCount;
	private String navLinkAddress;
	private Integer navIsDelete;

	// Constructors

	/** default constructor */
	public Nav() {
	}

	/** full constructor */
	public Nav(String navAddress, String navImage, Integer navCount,
			String navLinkAddress, Integer navIsDelete) {
		this.navAddress = navAddress;
		this.navImage = navImage;
		this.navCount = navCount;
		this.navLinkAddress = navLinkAddress;
		this.navIsDelete = navIsDelete;
	}

	// Property accessors

	public String getNavId() {
		return this.navId;
	}

	public void setNavId(String navId) {
		this.navId = navId;
	}

	public String getNavAddress() {
		return this.navAddress;
	}

	public void setNavAddress(String navAddress) {
		this.navAddress = navAddress;
	}

	public String getNavImage() {
		return this.navImage;
	}

	public void setNavImage(String navImage) {
		this.navImage = navImage;
	}

	public Integer getNavCount() {
		return this.navCount;
	}

	public void setNavCount(Integer navCount) {
		this.navCount = navCount;
	}

	public String getNavLinkAddress() {
		return this.navLinkAddress;
	}

	public void setNavLinkAddress(String navLinkAddress) {
		this.navLinkAddress = navLinkAddress;
	}

	public Integer getNavIsDelete() {
		return this.navIsDelete;
	}

	public void setNavIsDelete(Integer navIsDelete) {
		this.navIsDelete = navIsDelete;
	}

}