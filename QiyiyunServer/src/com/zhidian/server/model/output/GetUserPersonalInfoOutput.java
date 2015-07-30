package com.zhidian.server.model.output;

public class GetUserPersonalInfoOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731073806441114816L;

	private Output output;
	
	public static class Output{
		private String personId;
		private String personName;
		private String personPhone;
		private String personEmail;
		
		public String getPersonId() {
			return personId;
		}
		public void setPersonId(String personId) {
			this.personId = personId;
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
		
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
	
}
