package com.zhidian.server.model.output;

import java.util.List;

public class GetOrganRoleListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7266698919502076937L;
	
	private List<Output> output;
	
	public static class Output{
		private String roleId;
		private String roleName;
		private String roleDesc;
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
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

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
	
}
