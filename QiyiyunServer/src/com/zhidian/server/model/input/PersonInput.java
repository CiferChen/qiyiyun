package com.zhidian.server.model.input;

public class PersonInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3246759003941905286L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String personId;
		private String personName;
		private String personPhone;
		private String personEmail;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public String getPersonPhone() {
			return personPhone;
		}
		public void setPersonPhone(String personPhone) {
			this.personPhone = personPhone;
		}
		public String getPersonEmail() {
			return personEmail;
		}
		public void setPersonEmail(String personEmail) {
			this.personEmail = personEmail;
		}
		public String getPersonId() {
			return personId;
		}
		public void setPersonId(String personId) {
			this.personId = personId;
		}
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	
}
