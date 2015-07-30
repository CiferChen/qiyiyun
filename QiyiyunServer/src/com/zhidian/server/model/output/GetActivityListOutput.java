package com.zhidian.server.model.output;

import java.util.List;

public class GetActivityListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2340344172127164702L;
	
	private List<Output> output;
	
	public static class Output{
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
		public String getActivityId() {
			return activityId;
		}
		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}
		public String getActivityTitle() {
			return activityTitle;
		}
		public void setActivityTitle(String activityTitle) {
			this.activityTitle = activityTitle;
		}
		public String getActivityPurpose() {
			return activityPurpose;
		}
		public void setActivityPurpose(String activityPurpose) {
			this.activityPurpose = activityPurpose;
		}
		public String getActivityPersonNumber() {
			return activityPersonNumber;
		}
		public void setActivityPersonNumber(String activityPersonNumber) {
			this.activityPersonNumber = activityPersonNumber;
		}
		public String getActivityTime() {
			return activityTime;
		}
		public void setActivityTime(String activityTime) {
			this.activityTime = activityTime;
		}
		public String getActivityState() {
			return activityState;
		}
		public void setActivityState(String activityState) {
			this.activityState = activityState;
		}
		public String getActivityLeaderName() {
			return activityLeaderName;
		}
		public void setActivityLeaderName(String activityLeaderName) {
			this.activityLeaderName = activityLeaderName;
		}
		public String getActivityLeaderPhone() {
			return activityLeaderPhone;
		}
		public void setActivityLeaderPhone(String activityLeaderPhone) {
			this.activityLeaderPhone = activityLeaderPhone;
		}
		public String getActivityApplicantsEndTime() {
			return activityApplicantsEndTime;
		}
		public void setActivityApplicantsEndTime(String activityApplicantsEndTime) {
			this.activityApplicantsEndTime = activityApplicantsEndTime;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPersonId() {
			return userPersonId;
		}
		public void setUserPersonId(String userPersonId) {
			this.userPersonId = userPersonId;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}

}
