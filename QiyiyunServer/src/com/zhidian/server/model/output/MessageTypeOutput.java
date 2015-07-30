package com.zhidian.server.model.output;

import java.util.List;

public class MessageTypeOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5042582304645732676L;
	
	private List<Output> output;
	
	public static class Output{
		private String messageTypeId;
		private String messageTypeName;
		private int messageIsDelete;
		
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

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
