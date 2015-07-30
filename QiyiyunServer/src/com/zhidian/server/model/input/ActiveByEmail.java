package com.zhidian.server.model.input;

public class ActiveByEmail extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1574257711546356968L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}
	
	public static class Input{
		public String EmailAddr;
		public String ActiveCode;
		public String getEmailAddr() {
			return EmailAddr;
		}
		public void setEmailAddr(String emailAddr) {
			EmailAddr = emailAddr;
		}
		public String getActiveCode() {
			return ActiveCode;
		}
		public void setActiveCode(String activeCode) {
			ActiveCode = activeCode;
		}
		
		
	}
}
