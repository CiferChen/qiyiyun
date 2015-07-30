package com.zhidian.server.model;

/**
 * UserWordsRel entity. @author MyEclipse Persistence Tools
 */

public class UserWordsRel implements java.io.Serializable {

	// Fields

	private String userWordsId;
	private String userId;
	private String wordsId;

	// Constructors

	/** default constructor */
	public UserWordsRel() {
	}

	/** full constructor */
	public UserWordsRel(String userId, String wordsId) {
		this.userId = userId;
		this.wordsId = wordsId;
	}

	// Property accessors

	public String getUserWordsId() {
		return this.userWordsId;
	}

	public void setUserWordsId(String userWordsId) {
		this.userWordsId = userWordsId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWordsId() {
		return this.wordsId;
	}

	public void setWordsId(String wordsId) {
		this.wordsId = wordsId;
	}

}