package com.zhidian.server.model;

/**
 * MeetingRoomRecord entity. @author MyEclipse Persistence Tools
 */

public class MeetingRoomRecord implements java.io.Serializable {

	// Fields

	private String meetingRoomRecordId;
	private String meetingRoomId;
	private String meetingRoomStartTime;
	private String meetingRoomEndTime;
	private String userId;
	private String meetingRoomRecordUrl;
	private Integer meetingRoomRecordIsDelete;

	// Constructors

	/** default constructor */
	public MeetingRoomRecord() {
	}

	/** full constructor */
	public MeetingRoomRecord(String meetingRoomId, String meetingRoomStartTime,
			String meetingRoomEndTime, String userId,
			String meetingRoomRecordUrl, Integer meetingRoomRecordIsDelete) {
		this.meetingRoomId = meetingRoomId;
		this.meetingRoomStartTime = meetingRoomStartTime;
		this.meetingRoomEndTime = meetingRoomEndTime;
		this.userId = userId;
		this.meetingRoomRecordUrl = meetingRoomRecordUrl;
		this.meetingRoomRecordIsDelete = meetingRoomRecordIsDelete;
	}

	// Property accessors

	public String getMeetingRoomRecordId() {
		return this.meetingRoomRecordId;
	}

	public void setMeetingRoomRecordId(String meetingRoomRecordId) {
		this.meetingRoomRecordId = meetingRoomRecordId;
	}

	public String getMeetingRoomId() {
		return this.meetingRoomId;
	}

	public void setMeetingRoomId(String meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	public String getMeetingRoomStartTime() {
		return this.meetingRoomStartTime;
	}

	public void setMeetingRoomStartTime(String meetingRoomStartTime) {
		this.meetingRoomStartTime = meetingRoomStartTime;
	}

	public String getMeetingRoomEndTime() {
		return this.meetingRoomEndTime;
	}

	public void setMeetingRoomEndTime(String meetingRoomEndTime) {
		this.meetingRoomEndTime = meetingRoomEndTime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMeetingRoomRecordUrl() {
		return this.meetingRoomRecordUrl;
	}

	public void setMeetingRoomRecordUrl(String meetingRoomRecordUrl) {
		this.meetingRoomRecordUrl = meetingRoomRecordUrl;
	}

	public Integer getMeetingRoomRecordIsDelete() {
		return this.meetingRoomRecordIsDelete;
	}

	public void setMeetingRoomRecordIsDelete(Integer meetingRoomRecordIsDelete) {
		this.meetingRoomRecordIsDelete = meetingRoomRecordIsDelete;
	}

}