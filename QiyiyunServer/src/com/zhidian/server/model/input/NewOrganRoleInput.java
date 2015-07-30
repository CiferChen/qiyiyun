package com.zhidian.server.model.input;

public class NewOrganRoleInput extends StandardInput{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3888777676265664293L;
	private Input input;
	
	public static class Input{
		private String loginId;
		private String departmentId;
		private String roleName;
		private String roleDesc;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		public String getRoleDesc() {
			return roleDesc;
		}
		public void setRoleDesc(String roleDesc) {
			this.roleDesc = roleDesc;
		}
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
