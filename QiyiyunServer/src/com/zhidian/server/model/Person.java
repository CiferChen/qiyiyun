package com.zhidian.server.model;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private String personId;
	private String personName;
	private String personPhone;
	private String personEmail;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** minimal constructor */
	public Person(String personName) {
		this.personName = personName;
	}

	/** full constructor */
	public Person(String personName, String personPhone, String personEmail) {
		this.personName = personName;
		this.personPhone = personPhone;
		this.personEmail = personEmail;
	}

	// Property accessors

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPhone() {
		return this.personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonEmail() {
		return this.personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

}