package com.zhidian.server.configuration;

import java.util.List;

public class App2eSMSResult {
	private int status;
	private int count;
	private List<PhoneResult> list;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<PhoneResult> getList() {
		return list;
	}

	public void setList(List<PhoneResult> list) {
		this.list = list;
	}

	public static class PhoneResult {
		private String p;
		private String mid;
		private String msg;
		
		public String getP() {
			return p;
		}

		public void setP(String p) {
			this.p = p;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}
}
