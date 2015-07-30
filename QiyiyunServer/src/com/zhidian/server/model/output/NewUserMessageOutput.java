package com.zhidian.server.model.output;

public class NewUserMessageOutput extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 244380707282040046L;

	private Output output;

	

	public Output getOutput() {
		return output;
	}



	public void setOutput(Output output) {
		this.output = output;
	}



	public static class Output {
		private String messageId;

		public String getMessageId() {
			return messageId;
		}

		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}

		

	}

}
