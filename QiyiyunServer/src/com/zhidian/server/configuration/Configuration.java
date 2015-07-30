package com.zhidian.server.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.zhidian.server.dao.UserPersonRelDAO;
import com.zhidian.server.model.UserPersonRel;
import com.zhidian.server.utils.LoginID;
import com.zhidian.server.utils.PhoneCode;

public class Configuration {
	
	public static Logger log = Logger.getLogger(Configuration.class);
	public static List<String> ips = new ArrayList<String>();
	public static Map<String, String> messages = new HashMap<String, String>();
	public static Map<String, String> configurations = new HashMap<String, String>();
	private static Map<String, LoginID> loginIds = new HashMap<String, LoginID>();
	/**
	 * 配置相关
	 */
	public static final int CONFIGURATIONS = 1;
	public static final int MESSAGES = 2;
	/**
	 * 短信配置
	 */
	public static final String SMSURL = "http://api.app2e.com/smsBigSend.api.php";//短信发送
	public static final int STATUS100 = 100;// 全部成功，全部号码和内容提交成功。
	public static final int STATUS101 = 101;// 参数错误，GET提交的参数不足或错误。
	public static final int STATUS102 = 102;// 号码错误，提交的号码均出现非法字符。
	public static final int STATUS103 = 103;// 当日余量不足，当日的发送队列已满员，无法再提交新的信息发送。
	public static final int STATUS104 = 104;// 请求超时，合作方采用多线程同时并发提交信息发送请求过大时，新请求将无法正确响应。
	public static final int STATUS105 = 105;// 用户余量不足，合作方的信息可用发送余量不足，请充值后继续。
	public static final int STATUS106 = 106;// 非法用户，提交的授权Key非法，无此用户。
	public static final int STATUS107 = 107;// 提交号码超限，一次提交最多提交1000个号码，当超过这个限制时，将返回此错误。
	public static final int STATUS111 = 111;// 签名不合法。
	public static final int STATUS120 = 120;// 内容长度超长，请不要超过500个字。
	public static final int STATUS121 = 121;// 内容中有屏蔽词。
	public static final int STATUS131 = 131;// IP非法。
	public static final String SMSBALANCEURL="http://api.app2e.com/getBalance.api.php";//查询余额
	public static final String SMSSENDER = "system";//短信发送者
	private static HashMap<String,PhoneCode> phoneCode ;
	// 会话凭证生存时间
	public static final int LOGINIDTIMELIMIT = 60000000;
	

	/**
	 * 添加手机动态验证码
	 * @param phoneNumber
	 * @param code
	 */
	public static void addPhoneCode(final String phoneNumber,PhoneCode code){
		if(phoneCode==null){
			phoneCode = new HashMap<String,PhoneCode>();
		}
		code.getTimer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				 log.info("移除动态验证码"+phoneNumber);
				 phoneCode.remove(phoneNumber);
			}
		}, 60000);
		phoneCode.put(phoneNumber, code);
	}
	
	/**
	 * 获取手机动态验证码
	 * @param phoneNumber
	 * @return
	 */
	public static PhoneCode getPhoneCode(String phoneNumber){
		if(phoneCode!=null){
			return phoneCode.get(phoneNumber);
		}else{
			return null;
		}
	}
	
	
	/**
	 * 添加会话凭证（loginid）
	 * 
	 * @param loginId
	 * @param loginID2
	 */
	public static void addLoginIds(final String loginId, LoginID loginID2) {
		if (loginIds == null) {
			loginIds = new HashMap<String, LoginID>();
		}
		// 启动线程
		loginID2.start();
		System.out.println("启动线程");
		loginIds.put(loginId, loginID2);
	}

	/**
	 * 重设时间
	 * 
	 * @param loginId
	 */
	public static void resetLoginIdTime(String loginId) {
		if (loginIds.containsKey(loginId)) {
			loginIds.get(loginId).setResetTime(true);
		}
	}

	/**
	 * 移除会话凭证
	 * 
	 * @param loginId
	 */
	public static void removeLoginId(String loginId) {
		System.out.println("移除：" + loginId);
		loginIds.remove(loginId);
	}

	/**
	 * 通过loginId获取userId
	 * @param loginId
	 * @return
	 */
	public static String getUserIdByLoginId(String loginId) {
		if (loginIds.containsKey(loginId)) {
			return loginIds.get(loginId).getUserId();
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static String getPersonIdByUserId(String userId){
	//getPersonIdbyUserId
	UserPersonRelDAO userPersonRelDAO = new UserPersonRelDAO();
	List<UserPersonRel> userPersonRels = userPersonRelDAO.findByUserId(userId);
	String personId = "";
	if(userPersonRels!=null){
		if(userPersonRels.size()==1){
			personId = userPersonRels.get(0).getPersonId();
		}else{
			log.error("more than 1 persinId finded");
		}
	}else{
		log.error("can not find personId");
	}
	return personId;
	}

	@SuppressWarnings("unchecked")
	public static String getUserIdByPersonId(String personId){
	//getUserIdbyPersonId
	UserPersonRelDAO userPersonRelDAO = new UserPersonRelDAO();
	List<UserPersonRel> userPersonRels = userPersonRelDAO.findByPersonId(personId);
	String userId = "";
	if(userPersonRels!=null){
		if(userPersonRels.size()==1){
			userId = userPersonRels.get(0).getUserId();
		}else{
			log.error("more than 1 persinId finded");
		}
	}else{
		log.error("can not find personId");
	}
	return userId;
	}
	
	/**
	 * 移除动态验证码
	 * @param phoneNumber
	 */
	public static void removeCode(String phoneNumber) {
		if(phoneCode!=null){
			phoneCode.remove(phoneNumber);
		}
	}
}
