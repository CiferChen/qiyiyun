package com.zhidian.server.model.output;

import java.util.List;

public class GetUserMessageList extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2920427475959389316L;

	private List<Output> Output;

	public List<Output> getOutput() {
		return Output;
	}

	public void setOutput(List<Output> output) {
		Output = output;
	}

	public static class Output {
		private String MessageId;
		private String MessageTime;
		private String MessageType;
		private String MessageTitle;
		public String getMessageId() {
			return MessageId;
		}
		public void setMessageId(String messageId) {
			MessageId = messageId;
		}
		public String getMessageTime() {
			return MessageTime;
		}
		public void setMessageTime(String messageTime) {
			MessageTime = messageTime;
		}
		public String getMessageType() {
			return MessageType;
		}
		public void setMessageType(String messageType) {
			MessageType = messageType;
		}
		public String getMessageTitle() {
			return MessageTitle;
		}
		public void setMessageTitle(String messageTitle) {
			MessageTitle = messageTitle;
		}
	}
}
