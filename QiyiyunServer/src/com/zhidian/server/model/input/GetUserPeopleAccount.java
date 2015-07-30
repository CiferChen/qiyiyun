package com.zhidian.server.model.input;

public class GetUserPeopleAccount extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -478869395541377986L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
	}

}
