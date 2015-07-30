package com.zhidian.server.model.output;

public class GetUserPeopleAccount extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3460963745827031197L;
	public Output Output;
	
	public Output getOutput() {
		return Output;
	}

	public void setOutput(Output output) {
		Output = output;
	}

	public static class Output{
		public String Cash;
		public String Deposit;
		public String getCash() {
			return Cash;
		}
		public void setCash(String cash) {
			Cash = cash;
		}
		public String getDeposit() {
			return Deposit;
		}
		public void setDeposit(String deposit) {
			Deposit = deposit;
		}
		
	}
}
