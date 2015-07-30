package com.zhidian.server.configuration;

import java.util.List;

public class ParameterHelper {
	/**
	 * 参数限制类型
	 */
	// 类型限制
	public static final int CODEMUSTINT = 1;// 必须为int型
	public static final int CODEMUSTSTRING = 2;// 必须为String型
	public static final int CODEMUSTBOOLEAN = 3;// 必须为boolean型
	public static final int CODEMUSTSHORT = 4;// 必须为short型
	public static final int CODEMUSTBYTE = 5;// 必须为Byte类型
	public static final int CODEMUSTLONG = 6;// 必须为Long类型
	public static final int CODEMUSTDOUBLE = 7;// 必须为double类型
	public static final int CODEMUSTFLOAT = 8;// 必须为float类型
	// 内容限制
	public static final int CODEMUST09 = 9;// 值必须在0~9之间
	public static final int CODEMUSTMOBILE = 10;// 值必须是手机号码
	public static final int CODEMUSTEMAIL = 11;// 值必须是Eamil
	// 没有限制
	public static final int CODEALL = 12;// 没有任何限制

	public static boolean checkParamLimit(Object value, List<Integer> limits) {
		System.out.println("正在进行参数检测 "+limits.size());
		boolean result = false;
		for (int i = 0; i < limits.size(); i++) {
			System.out.println(limits.get(i).intValue());
			switch (limits.get(i).intValue()) {
			case CODEMUSTINT:
				if (value instanceof Integer) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTSTRING:
				if (value instanceof String) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTBOOLEAN:
				if (value instanceof Boolean) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTSHORT:
				if (value instanceof Short) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTBYTE:
				if (value instanceof Byte) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTLONG:
				if (value instanceof Long) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTDOUBLE:
				if (value instanceof Double) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUSTFLOAT:
				if (value instanceof Float) {
					result = true;
				} else {
					result = false;
				}
				break;
			case CODEMUST09:
				try {
					int a = (Integer) value;
					if (a >= 0 && a <= 9) {
						result = true;
					}
				} catch (Exception e) {
					result = false;
				}
				break;
			case CODEMUSTMOBILE:
				//手机号码
				break;
			case CODEMUSTEMAIL:
				//电子邮箱
				break;
			case CODEALL:
				result = true;
				break;
			}
		}
		return result;
	}
}
