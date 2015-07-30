package com.zhidian.server.model.input;

public class GetUserPeopleCertificateList extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8772676305429147399L;

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
