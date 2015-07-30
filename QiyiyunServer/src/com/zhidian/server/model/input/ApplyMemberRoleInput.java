package com.zhidian.server.model.input;

public class ApplyMemberRoleInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4099487957163818886L;

	private Input input;
	
	public static class Input{
		private String loginId;
		private String personId;
		private String roleId;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPersonId() {
			return personId;
		}
		public void setPersonId(String personId) {
			this.personId = personId;
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
