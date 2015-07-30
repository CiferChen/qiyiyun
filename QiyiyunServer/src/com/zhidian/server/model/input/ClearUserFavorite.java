package com.zhidian.server.model.input;

public class ClearUserFavorite extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3423177796568247969L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

	}

}
