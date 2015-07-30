package com.zhidian.server.model.input;

public class AddUpdateRegisteredSpaceInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850491771010866511L;

	private Input input;
	
	public static class Input{
		private String loginId;
		private String registeredSpaceId;
		private String registeredSpaceName;
		private String registeredSpaceAddress;
		private String registeredSpaceX;
		private String registeredSpaceY;
		private String registeredSpaceDescription;
		private String registeredSpaceImg;
		private String registeredSpaceLeaderId;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getRegisteredSpaceId() {
			return registeredSpaceId;
		}
		public void setRegisteredSpaceId(String registeredSpaceId) {
			this.registeredSpaceId = registeredSpaceId;
		}
		public String getRegisteredSpaceName() {
			return registeredSpaceName;
		}
		public void setRegisteredSpaceName(String registeredSpaceName) {
			this.registeredSpaceName = registeredSpaceName;
		}
		public String getRegisteredSpaceAddress() {
			return registeredSpaceAddress;
		}
		public void setRegisteredSpaceAddress(String registeredSpaceAddress) {
			this.registeredSpaceAddress = registeredSpaceAddress;
		}
		public String getRegisteredSpaceX() {
			return registeredSpaceX;
		}
		public void setRegisteredSpaceX(String registeredSpaceX) {
			this.registeredSpaceX = registeredSpaceX;
		}
		public String getRegisteredSpaceY() {
			return registeredSpaceY;
		}
		public void setRegisteredSpaceY(String registeredSpaceY) {
			this.registeredSpaceY = registeredSpaceY;
		}
		public String getRegisteredSpaceDescription() {
			return registeredSpaceDescription;
		}
		public void setRegisteredSpaceDescription(String registeredSpaceDescription) {
			this.registeredSpaceDescription = registeredSpaceDescription;
		}
		public String getRegisteredSpaceImg() {
			return registeredSpaceImg;
		}
		public void setRegisteredSpaceImg(String registeredSpaceImg) {
			this.registeredSpaceImg = registeredSpaceImg;
		}
		public String getRegisteredSpaceLeaderId() {
			return registeredSpaceLeaderId;
		}
		public void setRegisteredSpaceLeaderId(String registeredSpaceLeaderId) {
			this.registeredSpaceLeaderId = registeredSpaceLeaderId;
		}
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
