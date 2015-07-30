package com.zhidian.server.model.input;

public class GetOrganRoleListInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7782203509454122295L;
	
	private Input input ;
	
	public static class Input{
		private String loginId;
		private String departmentId;
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
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
