package com.zhidian.server.model.input;

public class UserOrganInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8504827104022705586L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String organId;
		private String organName;
		private String organDescription;
		private String organAddress;
		private String organTypeId;
		private String contactName;
		private String contactPhone;
		private String contactEmail;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getOrganName() {
			return organName;
		}
		public void setOrganName(String organName) {
			this.organName = organName;
		}
		public String getOrganDescription() {
			return organDescription;
		}
		public void setOrganDescription(String organDescription) {
			this.organDescription = organDescription;
		}
		public String getOrganAddress() {
			return organAddress;
		}
		public void setOrganAddress(String organAddress) {
			this.organAddress = organAddress;
		}
		
		
		public String getContactName() {
			return contactName;
		}
		public void setContactName(String contactName) {
			this.contactName = contactName;
		}
		public String getContactPhone() {
			return contactPhone;
		}
		public void setContactPhone(String contactPhone) {
			this.contactPhone = contactPhone;
		}
		public String getContactEmail() {
			return contactEmail;
		}
		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}
		public String getOrganTypeId() {
			return organTypeId;
		}
		public void setOrganTypeId(String organTypeId) {
			this.organTypeId = organTypeId;
		}
		
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
