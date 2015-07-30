package com.zhidian.server.model.output;

public class GetUserMessageDetailOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9030175520108431054L;

	private Output output;
	
	

	public Output getOutput() {
		return output;
	}



	public void setOutput(Output output) {
		this.output = output;
	}



	public static class Output{
		private String messageId;
		private String messageTime;
		private String messageType;
		private String messageTitle;
		private String messageContent;
		public String getMessageId() {
			return messageId;
		}
		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}
		public String getMessageTime() {
			return messageTime;
		}
		public void setMessageTime(String messageTime) {
			this.messageTime = messageTime;
		}
		public String getMessageType() {
			return messageType;
		}
		public void setMessageType(String messageType) {
			this.messageType = messageType;
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
		
		
		
		
	}
	
}
