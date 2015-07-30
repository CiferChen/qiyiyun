package com.zhidian.server.model.output;

import java.util.List;

public class GetUserFavoriteOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1383696934944131692L;

	private List<Output> ouput;
	
	


	public static class Output{
		private String serviceGoodsThumb;
		private String serviceGoodsName;
		private String serviceGoodsSpaceAddress;
		private String servivePrice;
		private String srviceTypeName;
		private String serviceMargin;
		public String getServiceGoodsThumb() {
			return serviceGoodsThumb;
		}
		public void setServiceGoodsThumb(String serviceGoodsThumb) {
			this.serviceGoodsThumb = serviceGoodsThumb;
		}
		public String getServiceGoodsName() {
			return serviceGoodsName;
		}
		public void setServiceGoodsName(String serviceGoodsName) {
			this.serviceGoodsName = serviceGoodsName;
		}
		public String getServiceGoodsSpaceAddress() {
			return serviceGoodsSpaceAddress;
		}
		public void setServiceGoodsSpaceAddress(String serviceGoodsSpaceAddress) {
			this.serviceGoodsSpaceAddress = serviceGoodsSpaceAddress;
		}
		public String getServivePrice() {
			return servivePrice;
		}
		public void setServivePrice(String servivePrice) {
			this.servivePrice = servivePrice;
		}
		public String getSrviceTypeName() {
			return srviceTypeName;
		}
		public void setSrviceTypeName(String srviceTypeName) {
			this.srviceTypeName = srviceTypeName;
		}
		public String getServiceMargin() {
			return serviceMargin;
		}
		public void setServiceMargin(String serviceMargin) {
			this.serviceMargin = serviceMargin;
		}
		
		
	}




	public List<Output> getOuput() {
		return ouput;
	}




	public void setOuput(List<Output> ouput) {
		this.ouput = ouput;
	}
	
}
