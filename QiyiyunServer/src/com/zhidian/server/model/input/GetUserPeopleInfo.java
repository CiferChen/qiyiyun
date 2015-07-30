package com.zhidian.server.model.input;

public class GetUserPeopleInfo extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 635867086695375914L;

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
