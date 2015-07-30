package com.zhidian.server.model.output;

import java.util.List;

public class GetRegisteredSpaceListOutput  extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208465376715455918L;
	
	private List<Output> output;
	
	
	public static class Output{
		private String registeredSpaceId;
		private String registeredSpaceName;
		private String registeredSpaceAddress;
		
		public String getRegisteredSpaceName() {
			return registeredSpaceName;
		}
		public void setRegisteredSpaceName(String registeredSpaceName) {
			this.registeredSpaceName = registeredSpaceName;
		}
		public String getRegisteredSpaceAddress() {
			return registeredSpaceAddress;
		}
		public void setRegisteredSpaceAddress(String registeredSpaceAddress) {
			this.registeredSpaceAddress = registeredSpaceAddress;
		}
		public String getRegisteredSpaceId() {
			return registeredSpaceId;
		}
		public void setRegisteredSpaceId(String registeredSpaceId) {
			this.registeredSpaceId = registeredSpaceId;
		}
		
		
	}


	public List<Output> getOutput() {
		return output;
	}


	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
