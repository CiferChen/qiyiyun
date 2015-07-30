package com.zhidian.server.utils;

import java.util.UUID;

public class IDGenerator {
		//获取loginId UUID
		public static String getUUID(){
			return UUID.randomUUID().toString().replace("-", "");
		}
		//获取订单序列号
		public static String getOrderSN(){
			return null;
		}
}
