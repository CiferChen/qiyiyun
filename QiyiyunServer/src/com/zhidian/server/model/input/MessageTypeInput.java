package com.zhidian.server.model.input;

public class MessageTypeInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 905231042346387727L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String messageTypeId;
		private String messageTypeName;
		private int messageIsDelete;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getMessageTypeId() {
			return messageTypeId;
		}
		public void setMessageTypeId(String messageTypeId) {
			this.messageTypeId = messageTypeId;
		}
		public String getMessageTypeName() {
			return messageTypeName;
		}
		public void setMessageTypeName(String messageTypeName) {
			this.messageTypeName = messageTypeName;
		}
		public int getMessageIsDelete() {
			return messageIsDelete;
		}
		public void setMessageIsDelete(int messageIsDelete) {
			this.messageIsDelete = messageIsDelete;
		}
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
