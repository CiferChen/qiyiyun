package com.zhidian.server.model.input;

public class GetDelModifyUserMessageDetailInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8728496965474096564L;
	
	private Input input;
	
	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public static class Input{
		private String loginId;
		private String messageId;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getMessageId() {
			return messageId;
		}
		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}

		

		
		
	}
	
}
