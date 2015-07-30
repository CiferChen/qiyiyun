package com.zhidian.server.services.usermodule;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zhidian.server.configuration.Configuration;
import com.zhidian.server.dao.PersonDAO;
import com.zhidian.server.dao.UserPersonRelDAO;
import com.zhidian.server.model.Person;
import com.zhidian.server.model.UserPersonRel;
import com.zhidian.server.model.input.PersonInput;
import com.zhidian.server.model.output.GetUserPersonalInfoOutput;
import com.zhidian.server.services.QiyiyunService;

/**
 * 会员个人模块
 * @author zb
 *
 */
public class UserPersonModule {
	
	public static Logger log = Logger.getLogger(UserPersonModule.class);
	

	/**
	 * 个人信息管理-基本信息管理-新增会员个人
	 * @param gson
	 * @param je	input	[personName,personPhone,personEmail]
	 * 				deal	1:new person 2:user_person_rel
	 * 				output
	 * 				result
	 * @param dataList
	 */
	public static void newUserPerson(Gson gson, JsonElement je,List<Object> dataList) {
			log.info("---Server--->newUserPerson");
			PersonInput newUserPersonInput = gson.fromJson(je, PersonInput.class);

			String loginId = newUserPersonInput.getInput().getLoginId();
			Configuration.resetLoginIdTime(loginId);
			String userId = Configuration.getUserIdByLoginId(loginId);
			if (userId != null && !userId.equals("")) {
				String personId = new PersonDAO().save(new Person(newUserPersonInput.getInput().getPersonName(),newUserPersonInput.getInput().getPersonPhone(),newUserPersonInput.getInput().getPersonEmail())); 
				new UserPersonRelDAO().save(new UserPersonRel(userId,personId));
				
				QiyiyunService.standardMessageOutput(newUserPersonInput.getFn(), 0,dataList);
			}else{
				QiyiyunService.standardMessageOutput(newUserPersonInput.getFn(), 2,dataList);
			}
			
	}
	
	
	
	/**
	 * 个人信息管理-查询个人信息
	 * @param gson
	 * @param je input	 [personId] 
	 * 			 deal
	 * 			 output	 [personId,personName,personPhone,personEmail]
	 * 			 result
	 * @param dataList
	 */
	public static void getUserPersonalInfo(Gson gson,JsonElement je,List<Object>dataList) {
		log.info("---Server--->getUserPersonalInfo");
		PersonInput getUserPersonalInfoInput = gson.fromJson(je, PersonInput.class);
		GetUserPersonalInfoOutput getUserPersonalInfoOutput = new GetUserPersonalInfoOutput();
		
		String loginId = getUserPersonalInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			Person person = new PersonDAO().findById(getUserPersonalInfoInput.getInput().getPersonId());
			GetUserPersonalInfoOutput.Output output = new GetUserPersonalInfoOutput.Output();
			
			output.setPersonId(person.getPersonId());
			output.setPersonName(person.getPersonName());
			output.setPersonPhone(person.getPersonPhone());
			output.setPersonEmail(person.getPersonEmail());
			
			
			
			getUserPersonalInfoOutput.setFn(getUserPersonalInfoInput.getFn());
			getUserPersonalInfoOutput.setOutput(output);
			getUserPersonalInfoOutput.setResult(0);
			
			dataList.add(getUserPersonalInfoOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(getUserPersonalInfoInput.getFn(), 2,dataList);
		}
		
		
		
	}
	
	/**
	 * 个人信息管理-更新个人信息
	 * @param gson
	 * @param je input		[personId,personPhone,personEmail]
	 * 			 deal
	 * 			 output
	 * 			 result
	 * @param dataList
	 */
	public static void updateUserPersonalInfo(Gson gson,JsonElement je,List<Object>dataList) {
		log.info("---Server--->updateUserPersonalInfo");
		PersonInput updateUserPersonalInfoInput = gson.fromJson(je, PersonInput.class);
		
		String loginId = updateUserPersonalInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			PersonDAO personDAO = new PersonDAO();
			Person person = personDAO.findById(updateUserPersonalInfoInput.getInput().getPersonId());
			
			person.setPersonPhone(updateUserPersonalInfoInput.getInput().getPersonPhone());
			person.setPersonEmail(updateUserPersonalInfoInput.getInput().getPersonEmail());
			
			personDAO.attachDirty(person);
			
		}else{
			QiyiyunService.standardMessageOutput(updateUserPersonalInfoInput.getFn(), 2,dataList);
		}
		
		
	}

	public static void getUserPersonalCertificateDetail(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void modifyUserPersonalCertificate(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserPersonalCertificateList(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void applyUserFirstPersonalCertificate(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserPersonalInvitation(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void deleteUserApplyToOrganHistoryAll(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void deleteUserApplyToOrganHistory(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserApplyToOrganHistoryList(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void dealUserPersonalInvitation(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void newUserApplyToOrgan(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserPersonalRelateToOrgan(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void startUserPersonalRecharge(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void cancelUserPersonalRecharge(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void finishUserPersonalRecharge(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserPersonalRechargeList(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getPersonalOrderList(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getPersonalOrderDetail(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void submitPersonalOrder(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void payPersonalOrder(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void completePersonalOrder(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void evaluationPersonalOrder(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void cancelPersonalOrder(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void applicationForBackPersonalOrder(Gson gson,JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserPersonalAccount(Gson gson, JsonElement je,List<Object> dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getUserPersonalAccountInfo(Gson gson, JsonElement je,List<Object> dataList) {
		// TODO Auto-generated method stub
		
	}



}
