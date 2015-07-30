package com.zhidian.server.model.input;

public class GetUserPeopleAccountInfo extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656269368697968877L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
		public String StartTime;
		public String EndTime;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

		public String getStartTime() {
			return StartTime;
		}

		public void setStartTime(String startTime) {
			StartTime = startTime;
		}

		public String getEndTime() {
			return EndTime;
		}

		public void setEndTime(String endTime) {
			EndTime = endTime;
		}

	}
}
