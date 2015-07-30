package com.zhidian.server.model.input;

public class VisitorInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5204330093734814025L;
	
	private Input input;
	
	
	public static class Input{
		private String loginId;
		private String visitorId;
		private String visitorName;
		private String visitorPhone;
		private String visitorEmail;
		private String visitorStartTime;
		private String organId;
		
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
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


	public Input getInput() {
		return input;
	}


	public void setInput(Input input) {
		this.input = input;
	}

}
