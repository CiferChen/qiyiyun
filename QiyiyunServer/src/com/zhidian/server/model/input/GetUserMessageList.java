package com.zhidian.server.model.input;

public class GetUserMessageList extends StandardInput {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5885072627626428280L;

	public Input input;
	
	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public static class Input{
		public String loginId;
		public int messageType;
	
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public int getMessageType() {
			return messageType;
		}
		public void setMessageType(int messageType) {
			this.messageType = messageType;
		}
	}
}
