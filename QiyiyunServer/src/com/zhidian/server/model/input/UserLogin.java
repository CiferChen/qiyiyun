package com.zhidian.server.model.input;

public class UserLogin extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1611657941212820377L;

	public Input input;
	
	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public static class Input{
		
		public String userName;
		public String userPsd;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPsd() {
			return userPsd;
		}
		public void setUserPsd(String userPsd) {
			this.userPsd = userPsd;
		}
	}
}
