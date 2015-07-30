package com.zhidian.server.model.input;

public class ModUserPsd extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2335888152068004106L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
		public String OldPsd;
		public String NewPsd;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

		public String getOldPsd() {
			return OldPsd;
		}

		public void setOldPsd(String oldPsd) {
			OldPsd = oldPsd;
		}

		public String getNewPsd() {
			return NewPsd;
		}

		public void setNewPsd(String newPsd) {
			NewPsd = newPsd;
		}

	}

}
