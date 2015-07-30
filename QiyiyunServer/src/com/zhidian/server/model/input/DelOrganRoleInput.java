package com.zhidian.server.model.input;

public class DelOrganRoleInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1851432597700058878L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String roleId;
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
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
