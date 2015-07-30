package com.zhidian.server.model.input;

public class GetUserFavorite extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5312605307036890709L;

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
