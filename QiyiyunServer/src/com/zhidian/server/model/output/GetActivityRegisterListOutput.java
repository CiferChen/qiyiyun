package com.zhidian.server.model.output;

import java.util.List;

public class GetActivityRegisterListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770681392029127499L;
	
	private List<Output> output ;
	
	public static class Output{
		private String activityRegisterId;
		private String activityRegisterName;
		private String activityRegisterPhone;
		private String activityOrganId;
		public String getActivityRegisterId() {
			return activityRegisterId;
		}
		public void setActivityRegisterId(String activityRegisterId) {
			this.activityRegisterId = activityRegisterId;
		}
		public String getActivityRegisterName() {
			return activityRegisterName;
		}
		public void setActivityRegisterName(String activityRegisterName) {
			this.activityRegisterName = activityRegisterName;
		}
		public String getActivityRegisterPhone() {
			return activityRegisterPhone;
		}
		public void setActivityRegisterPhone(String activityRegisterPhone) {
			this.activityRegisterPhone = activityRegisterPhone;
		}
		public String getActivityOrganId() {
			return activityOrganId;
		}
		public void setActivityOrganId(String activityOrganId) {
			this.activityOrganId = activityOrganId;
		}
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
