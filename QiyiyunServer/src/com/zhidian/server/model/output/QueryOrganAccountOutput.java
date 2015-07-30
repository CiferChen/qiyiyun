package com.zhidian.server.model.output;

public class QueryOrganAccountOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7784403876367969404L;
	
	private Output output;
	
	public static class Output{
		
		private String accountId;
		private String organId;
		private String organBalance;
		private String organMarginBalance;
		
		public String getAccountId() {
			return accountId;
		}
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getOrganBalance() {
			return organBalance;
		}
		public void setOrganBalance(String organBalance) {
			this.organBalance = organBalance;
		}
		public String getOrganMarginBalance() {
			return organMarginBalance;
		}
		public void setOrganMarginBalance(String organMarginBalance) {
			this.organMarginBalance = organMarginBalance;
		}
		
		
		
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
}
