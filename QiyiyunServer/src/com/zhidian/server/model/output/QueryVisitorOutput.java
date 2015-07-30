package com.zhidian.server.model.output;

public class QueryVisitorOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4829242040509614963L;
	
	private Output output;
	
	
	
	public Output getOutput() {
		return output;
	}



	public void setOutput(Output output) {
		this.output = output;
	}



	public static class Output{
		private String visitorId;
		private String visitorName;
		private String visitorPhone;
		private String visitorEmail;
		private String visitorStartTime;
		private String organId;
		public String getVisitorId() {
			return visitorId;
		}
		public void setVisitorId(String visitorId) {
			this.visitorId = visitorId;
		}
		public String getVisitorName() {
			return visitorName;
		}
		public void setVisitorName(String visitorName) {
			this.visitorName = visitorName;
		}
		public String getVisitorPhone() {
			return visitorPhone;
		}
		public void setVisitorPhone(String visitorPhone) {
			this.visitorPhone = visitorPhone;
		}
		public String getVisitorEmail() {
			return visitorEmail;
		}
		public void setVisitorEmail(String visitorEmail) {
			this.visitorEmail = visitorEmail;
		}
		public String getVisitorStartTime() {
			return visitorStartTime;
		}
		public void setVisitorStartTime(String visitorStartTime) {
			this.visitorStartTime = visitorStartTime;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		
		
	}

}
