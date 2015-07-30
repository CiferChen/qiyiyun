package com.zhidian.server.model;

/**
 * MeetingRoom entity. @author MyEclipse Persistence Tools
 */

public class MeetingRoom implements java.io.Serializable {

	// Fields

	private String meetingRoomId;
	private String meetingRoomName;
	private String spaceId;
	private String meetingRoomTypeId;
	private String meetingRoomEquipment;
	private Integer meetingRoomStatus;
	private Integer meetingRoomIsDelete;

	// Constructors

	/** default constructor */
	public MeetingRoom() {
	}

	/** minimal constructor */
	public MeetingRoom(String meetingRoomName, String spaceId,
			String meetingRoomTypeId, Integer meetingRoomStatus,
			Integer meetingRoomIsDelete) {
		this.meetingRoomName = meetingRoomName;
		this.spaceId = spaceId;
		this.meetingRoomTypeId = meetingRoomTypeId;
		this.meetingRoomStatus = meetingRoomStatus;
		this.meetingRoomIsDelete = meetingRoomIsDelete;
	}

	/** full constructor */
	public MeetingRoom(String meetingRoomName, String spaceId,
			String meetingRoomTypeId, String meetingRoomEquipment,
			Integer meetingRoomStatus, Integer meetingRoomIsDelete) {
		this.meetingRoomName = meetingRoomName;
		this.spaceId = spaceId;
		this.meetingRoomTypeId = meetingRoomTypeId;
		this.meetingRoomEquipment = meetingRoomEquipment;
		this.meetingRoomStatus = meetingRoomStatus;
		this.meetingRoomIsDelete = meetingRoomIsDelete;
	}

	// Property accessors

	public String getMeetingRoomId() {
		return this.meetingRoomId;
	}

	public void setMeetingRoomId(String meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	public String getMeetingRoomName() {
		return this.meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public String getSpaceId() {
		return this.spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getMeetingRoomTypeId() {
		return this.meetingRoomTypeId;
	}

	public void setMeetingRoomTypeId(String meetingRoomTypeId) {
		this.meetingRoomTypeId = meetingRoomTypeId;
	}

	public String getMeetingRoomEquipment() {
		return this.meetingRoomEquipment;
	}

	public void setMeetingRoomEquipment(String meetingRoomEquipment) {
		this.meetingRoomEquipment = meetingRoomEquipment;
	}

	public Integer getMeetingRoomStatus() {
		return this.meetingRoomStatus;
	}

	public void setMeetingRoomStatus(Integer meetingRoomStatus) {
		this.meetingRoomStatus = meetingRoomStatus;
	}

	public Integer getMeetingRoomIsDelete() {
		return this.meetingRoomIsDelete;
	}

	public void setMeetingRoomIsDelete(Integer meetingRoomIsDelete) {
		this.meetingRoomIsDelete = meetingRoomIsDelete;
	}

}