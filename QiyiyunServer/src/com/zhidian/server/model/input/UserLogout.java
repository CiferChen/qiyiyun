package com.zhidian.server.model.input;

public class UserLogout extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3140304311497074078L;
	
	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		
		public String LoginID;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}
		
		
	}
	
}
