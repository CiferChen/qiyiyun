package com.zhidian.server.model.output;

public class QueryRegisteredSpaceDetailOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8378258470935722034L;

	private Output output ;
	
	public static class Output{
		private String registeredSpaceName;
		private String registeredSpaceAddress;
		private String registeredSpaceX;
		private String registeredSpaceY;
		private String registeredSpaceDescription;
		private String registeredSpaceImg;
		private String registeredSpaceLeaderId;
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
		public String getRegisteredSpaceX() {
			return registeredSpaceX;
		}
		public void setRegisteredSpaceX(String registeredSpaceX) {
			this.registeredSpaceX = registeredSpaceX;
		}
		public String getRegisteredSpaceY() {
			return registeredSpaceY;
		}
		public void setRegisteredSpaceY(String registeredSpaceY) {
			this.registeredSpaceY = registeredSpaceY;
		}
		public String getRegisteredSpaceDescription() {
			return registeredSpaceDescription;
		}
		public void setRegisteredSpaceDescription(String registeredSpaceDescription) {
			this.registeredSpaceDescription = registeredSpaceDescription;
		}
		public String getRegisteredSpaceImg() {
			return registeredSpaceImg;
		}
		public void setRegisteredSpaceImg(String registeredSpaceImg) {
			this.registeredSpaceImg = registeredSpaceImg;
		}
		public String getRegisteredSpaceLeaderId() {
			return registeredSpaceLeaderId;
		}
		public void setRegisteredSpaceLeaderId(String registeredSpaceLeaderId) {
			this.registeredSpaceLeaderId = registeredSpaceLeaderId;
		}
		
		
		
		
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
}
