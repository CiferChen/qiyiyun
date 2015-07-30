package com.zhidian.server.utils;


import com.zhidian.server.configuration.Configuration;

public class LoginID extends Thread {
	private String loginId;
	private String userId;
	private int time;
	private boolean resetTime = false;

	public LoginID(String loginId, int time,boolean resetTime,String userId) {
		this.loginId = loginId;
		this.userId = userId;
		this.time = time;
		this.resetTime = resetTime;
	}


	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public boolean isResetTime() {
		return resetTime;
	}


	public void setResetTime(boolean resetTime) {
		this.resetTime = resetTime;
	}


	public void run() {
		
		while (time > 0) {
			if (resetTime) {
				time = Configuration.LOGINIDTIMELIMIT;
				resetTime = false;
			}
			time--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Configuration.removeLoginId(this.loginId);
	}
}
