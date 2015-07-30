package com.zhidian.server.model.input;

public class DelUserMessage extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4546109470671335533L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
		public String InformID;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

		public String getInformID() {
			return InformID;
		}

		public void setInformID(String informID) {
			InformID = informID;
		}

	}

}
