package com.zhidian.server.model.input;

public class QueryDelAreaInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7353627097253117752L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String areaId;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getAreaId() {
			return areaId;
		}
		public void setAreaId(String areaId) {
			this.areaId = areaId;
		}
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	
}
