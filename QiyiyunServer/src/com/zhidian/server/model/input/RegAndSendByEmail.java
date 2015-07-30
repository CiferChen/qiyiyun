package com.zhidian.server.model.input;

public class RegAndSendByEmail extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 303371350267515618L;
	
	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		public String UserName;
		public String EmailAddr;
		public String Password;
		public String ActiveUrl;
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getEmailAddr() {
			return EmailAddr;
		}
		public void setEmailAddr(String emailAddr) {
			EmailAddr = emailAddr;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getActiveUrl() {
			return ActiveUrl;
		}
		public void setActiveUrl(String activeUrl) {
			ActiveUrl = activeUrl;
		}
		
		
	}
	
}
