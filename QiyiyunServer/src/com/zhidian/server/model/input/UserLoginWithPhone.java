package com.zhidian.server.model.input;

public class UserLoginWithPhone extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1611657941212820377L;

	private Input input;
	
	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public static class Input{
		private String userPhone;
		private String userPsd;
		public String getUserPsd() {
			return userPsd;
		}
		public void setUserPsd(String userPsd) {
			this.userPsd = userPsd;
		}
		public String getUserPhone() {
			return userPhone;
		}
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
	}
}
