package com.zhidian.server.model.output;

import java.util.List;

public class GetUserOrganListByTypeOutput extends StandardOutput{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3739448229640943645L;
	private List<Output> output;
	
	public static class Output{
		private String organId;
		private int getOrganType;
		private String organName;
		private List<Role> role;
		
		public String getOrganId() {
			return organId;
		}

		public void setOrganId(String organId) {
			this.organId = organId;
		}

		public int getGetOrganType() {
			return getOrganType;
		}

		public void setGetOrganType(int getOrganType) {
			this.getOrganType = getOrganType;
		}

		public String getOrganName() {
			return organName;
		}

		public void setOrganName(String organName) {
			this.organName = organName;
		}

	

		public List<Role> getRole() {
			return role;
		}

		public void setRole(List<Role> role) {
			this.role = role;
		}



		public static class Role{
			private String roleId;
			private String roleName;
			
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
			
		}
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}


}
