package com.zhidian.server.model.input;

public class ApplyOrganRoleRightInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 452995004701803132L;
	
	private Input input;

	public static class Input{
		private String loginId;
		private String roleId;
		private String rightId;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public String getRightId() {
			return rightId;
		}
		public void setRightId(String rightId) {
			this.rightId = rightId;
		}
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
