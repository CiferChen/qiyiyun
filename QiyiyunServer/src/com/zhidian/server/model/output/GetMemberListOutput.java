package com.zhidian.server.model.output;

import java.util.List;

public class GetMemberListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2092383742697578171L;
	
	private List<Output> output;
	
	public static class Output{
		private String personId;

		public String getPersonId() {
			return personId;
		}

		public void setPersonId(String personId) {
			this.personId = personId;
		}
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}

	
	
	
}
