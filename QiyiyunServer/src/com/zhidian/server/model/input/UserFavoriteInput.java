package com.zhidian.server.model.input;

public class UserFavoriteInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1518006630386733915L;

	private Input input;
	
	public static class Input{
		private String favoriteId;
		private String loginId;
		private String goodsId;
		private String serviceGoodsId;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(String goodsId) {
			this.goodsId = goodsId;
		}
		public String getServiceGoodsId() {
			return serviceGoodsId;
		}
		public void setServiceGoodsId(String serviceGoodsId) {
			this.serviceGoodsId = serviceGoodsId;
		}
		public String getFavoriteId() {
			return favoriteId;
		}
		public void setFavoriteId(String favoriteId) {
			this.favoriteId = favoriteId;
		}
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	
}
