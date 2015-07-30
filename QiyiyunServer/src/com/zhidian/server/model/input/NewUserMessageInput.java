package com.zhidian.server.model.input;

public class NewUserMessageInput extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1263190505712291198L;

	private Input input;

	

	public Input getInput() {
		return input;
	}



	public void setInput(Input input) {
		this.input = input;
	}



	public static class Input {
		private String loginId;
		private String receiverId;
		private String messageTitle;
		private String messageContent;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		
		public String getMessageTitle() {
			return messageTitle;
		}
		public void setMessageTitle(String messageTitle) {
			this.messageTitle = messageTitle;
		}
		public String getMessageContent() {
			return messageContent;
		}
		public void setMessageContent(String messageContent) {
			this.messageContent = messageContent;
		}
		public String getReceiverId() {
			return receiverId;
		}
		public void setReceiverId(String receiverId) {
			this.receiverId = receiverId;
		}
		
		
		

	}

}
