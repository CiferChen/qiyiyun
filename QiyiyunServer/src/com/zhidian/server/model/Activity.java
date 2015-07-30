package com.zhidian.server.model;

/**
 * Activity entity. @author MyEclipse Persistence Tools
 */

public class Activity implements java.io.Serializable {

	// Fields

	private String activityId;
	private String activityTitle;
	private String activityPurpose;
	private String activityPersonNumber;
	private String activityTime;
	private String activityState;
	private String activityLeaderName;
	private String activityLeaderPhone;
	private String activityApplicantsEndTime;
	private String userId;
	private String userPersonId;
	private String organId;
	private Integer acitivtyIsDelete;

	// Constructors

	/** default constructor */
	public Activity() {
	}

	/** full constructor */
	public Activity(String activityTitle, String activityPurpose,
			String activityPersonNumber, String activityTime,
			String activityState, String activityLeaderName,
			String activityLeaderPhone, String activityApplicantsEndTime,
			String userId, String userPersonId, String organId,
			Integer acitivtyIsDelete) {
		this.activityTitle = activityTitle;
		this.activityPurpose = activityPurpose;
		this.activityPersonNumber = activityPersonNumber;
		this.activityTime = activityTime;
		this.activityState = activityState;
		this.activityLeaderName = activityLeaderName;
		this.activityLeaderPhone = activityLeaderPhone;
		this.activityApplicantsEndTime = activityApplicantsEndTime;
		this.userId = userId;
		this.userPersonId = userPersonId;
		this.organId = organId;
		this.acitivtyIsDelete = acitivtyIsDelete;
	}

	// Property accessors

	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityTitle() {
		return this.activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityPurpose() {
		return this.activityPurpose;
	}

	public void setActivityPurpose(String activityPurpose) {
		this.activityPurpose = activityPurpose;
	}

	public String getActivityPersonNumber() {
		return this.activityPersonNumber;
	}

	public void setActivityPersonNumber(String activityPersonNumber) {
		this.activityPersonNumber = activityPersonNumber;
	}

	public String getActivityTime() {
		return this.activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityState() {
		return this.activityState;
	}

	public void setActivityState(String activityState) {
		this.activityState = activityState;
	}

	public String getActivityLeaderName() {
		return this.activityLeaderName;
	}

	public void setActivityLeaderName(String activityLeaderName) {
		this.activityLeaderName = activityLeaderName;
	}

	public String getActivityLeaderPhone() {
		return this.activityLeaderPhone;
	}

	public void setActivityLeaderPhone(String activityLeaderPhone) {
		this.activityLeaderPhone = activityLeaderPhone;
	}

	public String getActivityApplicantsEndTime() {
		return this.activityApplicantsEndTime;
	}

	public void setActivityApplicantsEndTime(String activityApplicantsEndTime) {
		this.activityApplicantsEndTime = activityApplicantsEndTime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPersonId() {
		return this.userPersonId;
	}

	public void setUserPersonId(String userPersonId) {
		this.userPersonId = userPersonId;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public Integer getAcitivtyIsDelete() {
		return this.acitivtyIsDelete;
	}

	public void setAcitivtyIsDelete(Integer acitivtyIsDelete) {
		this.acitivtyIsDelete = acitivtyIsDelete;
	}

}