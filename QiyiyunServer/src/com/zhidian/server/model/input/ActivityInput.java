package com.zhidian.server.model.input;

public class ActivityInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290610663003009149L;
	
	
	private Input input;
	
	
	public static class Input{
		private String loginId ;
		private String activityId ;
		private String activityTitle ;
		private String activityPurpose ;
		private String activityPersonNumber ;
		private String activityTime ;
		private String activityLeaderName ;
		private String activityLeaderPhone ;
		private String activityApplicantsEndTime ;
		private String organId ;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
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
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		
		
		
		
	}


	public Input getInput() {
		return input;
	}


	public void setInput(Input input) {
		this.input = input;
	}

}
