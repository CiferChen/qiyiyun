package com.zhidian.server.services.managermodule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zhidian.server.configuration.App2eSMSResult;
import com.zhidian.server.configuration.Configuration;
import com.zhidian.server.dao.AreaDAO;
import com.zhidian.server.dao.BookstationDAO;
import com.zhidian.server.dao.MessageTypeDAO;
import com.zhidian.server.dao.SMSDAO;
import com.zhidian.server.dao.SMSInterfaceDAO;
import com.zhidian.server.dao.SpaceDAO;
import com.zhidian.server.model.Area;
import com.zhidian.server.model.Bookstation;
import com.zhidian.server.model.HibernateSessionFactory;
import com.zhidian.server.model.MessageType;
import com.zhidian.server.model.SMS;
import com.zhidian.server.model.SMSInterface;
import com.zhidian.server.model.Space;
import com.zhidian.server.model.input.AddUpdataArea;
import com.zhidian.server.model.input.AddUpdateRegisteredSpaceInput;
import com.zhidian.server.model.input.BookStationInput;
import com.zhidian.server.model.input.MessageTypeInput;
import com.zhidian.server.model.input.QueryDelAreaInput;
import com.zhidian.server.model.input.QueryDelRegisteredSpaceInput;
import com.zhidian.server.model.input.StandardInputWithLoginId;
import com.zhidian.server.model.output.GetBookStationListOutput;
import com.zhidian.server.model.output.GetRegisteredSpaceListOutput;
import com.zhidian.server.model.output.GetSubAreaListOutput;
import com.zhidian.server.model.output.MessageTypeOutput;
import com.zhidian.server.model.output.QueryAreaDetailOutput;
import com.zhidian.server.model.output.QueryBookStationOutput;
import com.zhidian.server.model.output.QueryRegisteredSpaceDetailOutput;
import com.zhidian.server.services.QiyiyunService;
import com.zhidian.server.utils.Common;

/**
 * 系统管理模块
 * 
 * @author zb
 * 
 */
public class SystemManageModule {
	public static Logger log = Logger.getLogger(SystemManageModule.class);

	/**
	 * 获取消息类型列表
	 * 
	 * @param gson
	 * @param je
	 *            input output List[messageTypeId,messageTypeName] result
	 */

	@SuppressWarnings("unchecked")
	public static void getMessageTypeList(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->getMessageTypeList");
		StandardInputWithLoginId messageTypeInput = gson.fromJson(je,
				StandardInputWithLoginId.class);
		MessageTypeOutput messageTypeOutput = new MessageTypeOutput();
		String loginId = messageTypeInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			MessageTypeDAO messageTypeDAO = new MessageTypeDAO();
			List<com.zhidian.server.model.output.MessageTypeOutput.Output> messageTypeOutputList = new ArrayList<com.zhidian.server.model.output.MessageTypeOutput.Output>();
			List<MessageType> messageTypeList = messageTypeDAO.findAll();
			if (messageTypeList != null) {
				Iterator<MessageType> it = messageTypeList.iterator();
				while (it.hasNext()) {
					MessageType messageType = it.next();
					com.zhidian.server.model.output.MessageTypeOutput.Output output = new com.zhidian.server.model.output.MessageTypeOutput.Output();
					output.setMessageTypeId(messageType.getMessageTypeId());
					output.setMessageTypeName(messageType.getMessageTypeName());
					output.setMessageIsDelete(messageType
							.getMessageTypeIsDelete());
					messageTypeOutputList.add(output);
				}
			}

			messageTypeOutput.setFn(messageTypeInput.getFn());
			messageTypeOutput.setResult(0);
			messageTypeOutput.setOutput(messageTypeOutputList);

			dataList.add(messageTypeOutput);

		} else {
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 2,
					dataList);
		}

	}

	/**
	 * 修改消息类型
	 * 
	 * @param gson
	 * @param je
	 *            input[messageTypeId,messageTypeName] output result
	 */
	public static void modifyMessageType(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->modifyMessageType");
		MessageTypeInput messageTypeInput = gson.fromJson(je,
				MessageTypeInput.class);
		String loginId = messageTypeInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			MessageTypeDAO messageTypeDAO = new MessageTypeDAO();
			MessageType messageType = new MessageType();
			messageType.setMessageTypeId(messageTypeInput.getInput()
					.getMessageTypeId());
			messageType.setMessageTypeName(messageTypeInput.getInput()
					.getMessageTypeName());
			messageType.setMessageTypeIsDelete(0);
			messageTypeDAO.attachDirty(messageType);
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 0,
					dataList);
		} else {
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 2,
					dataList);
		}
	}

	/**
	 * 删除消息类型
	 * 
	 * @param gson
	 * @param je
	 *            input[messageTypeId] output result
	 */
	public static void delMessageType(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->delMessageType");
		MessageTypeInput messageTypeInput = gson.fromJson(je,
				MessageTypeInput.class);
		String loginId = messageTypeInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			MessageTypeDAO messageTypeDAO = new MessageTypeDAO();
			try {
				messageTypeDAO.delete(messageTypeDAO.findById(messageTypeInput
						.getInput().getMessageTypeId()));
			} catch (Exception e) {
				QiyiyunService.standardMessageOutput(messageTypeInput.getFn(),
						1, dataList);
			}
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 0,
					dataList);
		} else {
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 2,
					dataList);
		}
	}

	/**
	 * 添加消息类型
	 * 
	 * @param gson
	 * @param je
	 *            input[messageTypeName] output result
	 */
	public static void addMessageType(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->addMessageType");
		MessageTypeInput messageTypeInput = gson.fromJson(je,
				MessageTypeInput.class);
		String loginId = messageTypeInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			MessageTypeDAO messageTypeDAO = new MessageTypeDAO();
			MessageType messageType = new MessageType();
			messageType.setMessageTypeName(messageTypeInput.getInput()
					.getMessageTypeName());
			messageType.setMessageTypeIsDelete(0);
			try {
				messageTypeDAO.save(messageType);
			} catch (Exception e) {
				QiyiyunService.standardMessageOutput(messageTypeInput.getFn(),
						1, dataList);
			}
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 0,
					dataList);

		} else {
			QiyiyunService.standardMessageOutput(messageTypeInput.getFn(), 2,
					dataList);
		}

	}
	
	/**
	 * 发送手机验证码
	 * 
	 * @param phoneNumber
	 *            手机号码字符串
	 * @param multi
	 *            是否是多条，如果是多条，手机号码字符串以逗号隔开
	 */
	public static int sendSMS(String phoneNumber, String content, boolean multi) {
		SMSDAO smsDAO = new SMSDAO();
		List<SMSInterface> smsInterfaces = getCurrentUsingSMSConfiguration();
		Iterator<SMSInterface> it = smsInterfaces.iterator();
		HashMap<String, SMS> smses = new HashMap<String, SMS>();
		// 你的手机号为{$verify.mobile},验证码为{$verify.code}【企易云】
		String contentTemplate1 = "你的手机号为";
		String contentTemplate2 = "验证码为";
		String contentTemplate3 = "【企易云】";
		if (multi) {
			String[] phoneNumbers = phoneNumber.split(",");
			for (int i = 0; i < phoneNumbers.length; i++) {
				SMS sms = new SMS();
				String contentTemp = contentTemplate1 + phoneNumbers[i] + ","
						+ contentTemplate2 + content + contentTemplate3;
				sms.setSmsContent(contentTemp);
				sms.setSmsIsDelete(0);
				sms.setSmsReceiver(phoneNumbers[i]);
				sms.setSmsSender(Configuration.SMSSENDER);
				sms.setSmsSendStatus(1);
				sms.setSmsSendTime(Calendar.getInstance().getTimeInMillis()
						+ "");
				smses.put(phoneNumbers[i], sms);
				smsDAO.save(sms);
			}
			return sendSMS(phoneNumber, it, smses);
		} else {
			SMS sms = new SMS();
			String contentTemp = contentTemplate1 + phoneNumber + ","
					+ contentTemplate2 + content + contentTemplate3;
			sms.setSmsContent(contentTemp);
			sms.setSmsIsDelete(0);
			sms.setSmsReceiver(phoneNumber);
			sms.setSmsSender(Configuration.SMSSENDER);
			sms.setSmsSendStatus(1);
			sms.setSmsSendTime(Calendar.getInstance().getTimeInMillis() + "");
			smses.put(phoneNumber, sms);
			smsDAO.save(sms);
			return sendSMS(phoneNumber, it, smses);
		}
	}

	/**
	 * 发送信息
	 * 
	 * @param content
	 * @param it
	 * @param smses
	 * @return
	 */
	private static int sendSMS(String phoneNumber, Iterator<SMSInterface> it,
			HashMap<String, SMS> smses) {
		Iterator<SMS> smsIt = smses.values().iterator();
		int count = 0;// 发送成功条数
		while (it.hasNext()) {// 轮换接口
			SMSInterface smsInterface = it.next();
			log.info(smsInterface.getSmsInterfaceUrl());
			while (smsIt.hasNext()) {// 发送信息
				SMS sms = smsIt.next();
				if (sms.getSmsSendStatus() != 2) {//如果已经发送成功则下个接口不再发送
					String contentResult = "pwd="
							+ smsInterface.getSmsInterfacePassword()
							+ "&username="
							+ smsInterface.getSmsInterfaceUserName() + "&charSetStr=utf&p="
							+ sms.getSmsReceiver() + "&msg="
							+ sms.getSmsContent();
					log.info(contentResult);
					List<SMS> smsResult = parseSMSSendResult(Common.sendPost(
							smsInterface.getSmsInterfaceUrl(), contentResult),
							smsInterface.getSmsInterfaceUrl(), sms);
					if (smsResult != null && smsResult.size() > 0) {
						continue;
					} else {
						sms.setSmsSendStatus(2);
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * 解析短信发送结果
	 * 
	 * @param sendPost
	 */
	private static List<SMS> parseSMSSendResult(String sendPost,
			String smsInterfaceUrl, SMS sms) {
		log.info("result:" + sendPost);
		List<SMS> smsFailed = new ArrayList<SMS>();
		Gson gson = new Gson();
		if (smsInterfaceUrl.equals(Configuration.SMSURL)) {
			App2eSMSResult app2eSMSResult = gson.fromJson(sendPost,
					App2eSMSResult.class);
			if (app2eSMSResult.getStatus() == Configuration.STATUS100) {
				SMSDAO smsDAO = new SMSDAO();
				Transaction tx = HibernateSessionFactory.getSession()
						.beginTransaction();
				// 一次只发送一条
				for (int i = 0; i < app2eSMSResult.getList().size(); i++) {
					sms.setSmsSendTime(Calendar.getInstance().getTimeInMillis()
							+ "");
					if (app2eSMSResult.getList().get(i).getMid().equals("0")) {
						sms.setSmsSendStatus(2);// 发送失败
						smsFailed.add(sms);
					} else {
						sms.setSmsSendStatus(0);// 已发送
					}
					smsDAO.attachDirty(sms);
				}
				tx.commit();
			} else {
				log.info("status:" + app2eSMSResult.getStatus());
			}
		} else {
		}
		return smsFailed;
	}

	/**
	 * 获取当前正在使用的短信接口
	 * 
	 * @return
	 */
	public static List<SMSInterface> getCurrentUsingSMSConfiguration() {
		SMSInterfaceDAO smsInterfaceDAO = new SMSInterfaceDAO();
		List<SMSInterface> smsInterfaces = smsInterfaceDAO.findByProperty(
				"smsInterfaceStatus", 2);
		return smsInterfaces;
	}

	/**
	 * 添加短信接口
	 * 
	 * @param gson
	 * @param je
	 * @param dataList
	 */
	public static void addSMSInterface(Gson gson, JsonElement je,
			List<Object> dataList) {

	}
	
	
	/**
	 * 场地管理-场地注册管理-获取注册场地列表
	 * @param gson
	 * @param je input
	 * 			 output List[registeredSpaceId,registeredSpaceName,registeredSpaceAddress]
	 * 			 result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getRegisteredSpaceList(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->getRegisteredSpaceList");
		StandardInputWithLoginId getRegisteredSpaceInput = gson.fromJson(je, StandardInputWithLoginId.class);
		GetRegisteredSpaceListOutput getRegisteredSpaceListOutput = new GetRegisteredSpaceListOutput();
		String loginId = getRegisteredSpaceInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			SpaceDAO spaceDAO = new SpaceDAO();
			List<GetRegisteredSpaceListOutput.Output> outputs = new ArrayList<GetRegisteredSpaceListOutput.Output>();
			List<Space> spaceList = spaceDAO.findAll();
			if(spaceList!=null){
				Iterator<Space> it = spaceList.iterator();
				while(it.hasNext()){
					Space space = it.next();
					GetRegisteredSpaceListOutput.Output output = new GetRegisteredSpaceListOutput.Output();
					output.setRegisteredSpaceId(space.getSpaceId());
					output.setRegisteredSpaceName(space.getSpaceName());
					output.setRegisteredSpaceAddress(space.getSpaceAddress());
					outputs.add(output);
				}
		
				getRegisteredSpaceListOutput.setFn(getRegisteredSpaceInput.getFn());
				getRegisteredSpaceListOutput.setResult(0);
				getRegisteredSpaceListOutput.setOutput(outputs);
				dataList.add(getRegisteredSpaceListOutput);
				
			}
		}else{
			QiyiyunService.standardMessageOutput(getRegisteredSpaceInput.getFn(), 2,dataList);
		}
		
		
	}
	
	/**
	 * 场地管理-场地注册管理-查询注册场地信息
	 * @param gson
	 * @param je input  [registeredSpaceId]
	 * 			 output [registeredSpaceName,registeredSpaceAddress,registeredSpaceX,registeredSpaceY,
	 * 					registeredSpaceDescription,registeredSpaceImg,registeredSpaceLeaderId]
	 * 			 result
	 * @param dataList
	 */
	public static void queryRegisteredSpaceDetail(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->queryRegisteredSpaceDetail");
		QueryDelRegisteredSpaceInput queryRegisteredSpaceDetailInput = gson.fromJson(je, QueryDelRegisteredSpaceInput.class);
		QueryRegisteredSpaceDetailOutput queryRegisteredSpaceDetailOutput = new QueryRegisteredSpaceDetailOutput();
		String loginId = queryRegisteredSpaceDetailInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			SpaceDAO spaceDAO = new SpaceDAO();
			Space space = new Space();
			space = spaceDAO.findById(queryRegisteredSpaceDetailInput.getInput().getRegisteredSpaceId());
			QueryRegisteredSpaceDetailOutput.Output output = new QueryRegisteredSpaceDetailOutput.Output();
			output.setRegisteredSpaceName(space.getSpaceName());
			output.setRegisteredSpaceAddress(space.getSpaceAddress());
			output.setRegisteredSpaceX(space.getSpaceX());
			output.setRegisteredSpaceY(space.getSpaceY());
			output.setRegisteredSpaceDescription(space.getSpaceDescription());
			output.setRegisteredSpaceImg(space.getSpaceImg());
			output.setRegisteredSpaceLeaderId(space.getSpaceLeaderId());
			queryRegisteredSpaceDetailOutput.setFn(queryRegisteredSpaceDetailInput.getFn());
			queryRegisteredSpaceDetailOutput.setOutput(output);
			queryRegisteredSpaceDetailOutput.setResult(0);
			dataList.add(queryRegisteredSpaceDetailOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(queryRegisteredSpaceDetailInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 场地管理-场地注册管理-注册新场地
	 * @param gson
	 * @param je input  [registeredSpaceName,registeredSpaceAddress,registeredSpaceX,registeredSpaceY,
	 * 					registeredSpaceDescription,registeredSpaceImg,registeredSpaceLeaderId]			 
	 * 			 output 
	 * 			 result
	 * @param dataList
	 */
	public static void addNewRegisteredSpace(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->addNewRegisteredSpace");
		AddUpdateRegisteredSpaceInput addRegisteredSpaceInput = gson.fromJson(je, AddUpdateRegisteredSpaceInput.class);
		String loginId = addRegisteredSpaceInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			SpaceDAO spaceDAO = new SpaceDAO();
			Space space = new Space();
			space.setSpaceName(addRegisteredSpaceInput.getInput().getRegisteredSpaceName());
			space.setSpaceAddress(addRegisteredSpaceInput.getInput().getRegisteredSpaceAddress());
			space.setSpaceX(addRegisteredSpaceInput.getInput().getRegisteredSpaceX());
			space.setSpaceY(addRegisteredSpaceInput.getInput().getRegisteredSpaceY());
			space.setSpaceDescription(addRegisteredSpaceInput.getInput().getRegisteredSpaceDescription());
			space.setSpaceImg(addRegisteredSpaceInput.getInput().getRegisteredSpaceImg());
			space.setSpaceLeaderId(addRegisteredSpaceInput.getInput().getRegisteredSpaceLeaderId());
			space.setSpaceIsDelete(0);
			spaceDAO.save(space);
			QiyiyunService.standardMessageOutput(addRegisteredSpaceInput.getFn(),0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(addRegisteredSpaceInput.getFn(),2,dataList);
		}
	}
	
	/**
	 * 场地管理-场地注册管理-更新场地信息
	 * @param gson
	 * @param je input  [registeredSpaceId,registeredSpaceName,registeredSpaceAddress,registeredSpaceX,registeredSpaceY,
	 * 					registeredSpaceDescription,registeredSpaceImg,registeredSpaceLeaderId]			 
	 * 			 output 
	 * 			 result
	 * @param dataList
	 */
	public static void updateRegisteredSpaceInfo(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->updateRegisteredSpaceInfo");
		AddUpdateRegisteredSpaceInput updateRegisteredSpaceInfoInput = gson.fromJson(je, AddUpdateRegisteredSpaceInput.class);
		String loginId = updateRegisteredSpaceInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			SpaceDAO spaceDAO = new SpaceDAO();
			Space space = spaceDAO.findById(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceId());
			space.setSpaceName(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceName());
			space.setSpaceAddress(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceAddress());
			space.setSpaceX(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceX());
			space.setSpaceY(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceY());
			space.setSpaceDescription(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceDescription());
			space.setSpaceImg(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceImg());
			space.setSpaceLeaderId(updateRegisteredSpaceInfoInput.getInput().getRegisteredSpaceLeaderId());
			space.setSpaceIsDelete(0);
			spaceDAO.attachDirty(space);
			QiyiyunService.standardMessageOutput(updateRegisteredSpaceInfoInput.getFn(),0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(updateRegisteredSpaceInfoInput.getFn(),2,dataList);
		}
		
	}
	
	/**
	 * 场地管理-场地注册管理-删除场地
	 * @param gson
	 * @param je input  [registeredSpaceId]			 
	 * 			 output 
	 * 			 result
	 * @param dataList
	 */
	public static void delRegisteredSpace(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->delRegisteredSpace");
		QueryDelRegisteredSpaceInput delRegisteredSpaceDetailInput = gson.fromJson(je, QueryDelRegisteredSpaceInput.class);
		String loginId = delRegisteredSpaceDetailInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			SpaceDAO spaceDAO = new SpaceDAO();
			Space space = spaceDAO.findById(delRegisteredSpaceDetailInput.getInput().getRegisteredSpaceId());
			spaceDAO.delete(space);
			QiyiyunService.standardMessageOutput(delRegisteredSpaceDetailInput.getFn(),0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(delRegisteredSpaceDetailInput.getFn(),2,dataList);
		}
		
	}
	
	/**
	 * 场地管理-内部区域管理-获取子区域列表
	 * @param gson
	 * @param je input
	 * 			 output List[areaId,areaName,spaceName]
	 * 			 result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getSubAreaList(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->getSubAreaList");
		StandardInputWithLoginId getSubAreaListInput = gson.fromJson(je, StandardInputWithLoginId.class);
		GetSubAreaListOutput getSubAreaListOutput = new GetSubAreaListOutput();
		String loginId = getSubAreaListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			AreaDAO areaDAO = new AreaDAO();
			SpaceDAO spaceDAO = new SpaceDAO();
			List<GetSubAreaListOutput.Output> outputs = new ArrayList<GetSubAreaListOutput.Output>();
			List<Area> areas = new ArrayList<Area>();
			areas = areaDAO.findAll();
			if(areas != null){
				Iterator<Area> it = areas.iterator();
				while(it.hasNext()){
					Area area = it.next();
					GetSubAreaListOutput.Output output = new GetSubAreaListOutput.Output();
					output.setAreaId(area.getAreaId());
					output.setAreaName(area.getAreaName());
					output.setSpaceName(spaceDAO.findById(area.getSpaceId()).getSpaceName());
					outputs.add(output);
				}
			}
			getSubAreaListOutput.setFn(getSubAreaListInput.getFn());
			getSubAreaListOutput.setOutput(outputs);
			getSubAreaListOutput.setResult(0);
			
			dataList.add(getSubAreaListOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(getSubAreaListInput.getFn(),2,dataList);
		}
	}

	/**
	 * 场地管理-内部区域管理-新建区域
	 * @param gson
	 * @param je input  [areaName,spaceId,areaDescription,areaImg,areaLeaderId]
	 * 			 output 
	 * 			 result
	 * @param dataList
	 */
	public static void addNewArea(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->addNewArea");
		AddUpdataArea addNewAreaInput = gson.fromJson(je, AddUpdataArea.class);
		String loginId = addNewAreaInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			AreaDAO areaDAO = new AreaDAO();
			Area area = new Area();
			area.setSpaceId(addNewAreaInput.getInput().getSpaceId());
			area.setAreaName(addNewAreaInput.getInput().getAreaName());
			area.setAreaDescription(addNewAreaInput.getInput().getAreaDescription());
			area.setAreaImg(addNewAreaInput.getInput().getAreaImg());
			area.setAreaLeaderId(addNewAreaInput.getInput().getAreaLeaderId());
			area.setAreaIsDelete(0);
			areaDAO.save(area);
			QiyiyunService.standardMessageOutput(addNewAreaInput.getFn(),0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(addNewAreaInput.getFn(),2,dataList);
		}
		
		
	}
	/**
	 * 场地管理-内部区域管理-更新区域信息
	 * @param gson
	 * @param je input  [areaId,areaName,spaceId,areaDescription,areaImg,areaLeaderId]
	 * 			 output 
	 * 			 result
	 * @param dataList
	 */
	public static void updateAreaInfo(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->updateAreaInfo");
		AddUpdataArea updateAreaInfoInput = gson.fromJson(je, AddUpdataArea.class);
		String loginId = updateAreaInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			AreaDAO areaDAO = new AreaDAO();
			Area area = areaDAO.findById(updateAreaInfoInput.getInput().getAreaId());
			area.setSpaceId(updateAreaInfoInput.getInput().getSpaceId());
			area.setAreaName(updateAreaInfoInput.getInput().getAreaName());
			area.setAreaDescription(updateAreaInfoInput.getInput().getAreaDescription());
			area.setAreaImg(updateAreaInfoInput.getInput().getAreaImg());
			area.setAreaLeaderId(updateAreaInfoInput.getInput().getAreaLeaderId());
			area.setAreaIsDelete(0);
			areaDAO.attachDirty(area);
			QiyiyunService.standardMessageOutput(updateAreaInfoInput.getFn(),0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(updateAreaInfoInput.getFn(),2,dataList);
		}		
	}
	
	/**
	 * 场地管理-内部区域管理-查询区域详细信息
	 * @param gson
	 * @param je input  [areaId]			 
	 * 			 output [areaName,spaceId,areaDescription,areaImg,areaLeaderId]
	 * 			 result
	 * @param dataList
	 */
	public static void queryAreaDetail(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->queryAreaDetail");
		QueryDelAreaInput queryAreaDetailInput = gson.fromJson(je, QueryDelAreaInput.class);
		QueryAreaDetailOutput queryAreaDetailOutput = new QueryAreaDetailOutput();
		String loginId = queryAreaDetailInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			AreaDAO areaDAO = new AreaDAO();
			Area area = areaDAO.findById(queryAreaDetailInput.getInput().getAreaId());
			QueryAreaDetailOutput.Output output = new QueryAreaDetailOutput.Output();
			output.setSpaceId(area.getSpaceId());
			output.setAreaName(area.getAreaName());
			output.setAreaDescription(area.getAreaDescription());
			output.setAreaImg(area.getAreaImg());
			output.setAreaLeaderId(area.getAreaLeaderId());
			
			queryAreaDetailOutput.setFn(queryAreaDetailInput.getFn());
			queryAreaDetailOutput.setOutput(output);
			queryAreaDetailOutput.setResult(0);
			dataList.add(queryAreaDetailOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(queryAreaDetailInput.getFn(),2,dataList);
		}
		
	}
	
	/**
	 * 场地管理-内部区域管理-删除区域
	 * @param gson
	 * @param je input  [areaId]			 
	 * 			 output 
	 * 			 result
	 * @param dataList
	 */
	public static void delArea(Gson gson, JsonElement je, List<Object> dataList) {
		log.info("---Server--->delArea");
		QueryDelAreaInput queryAreaInput = gson.fromJson(je, QueryDelAreaInput.class);
		String loginId = queryAreaInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			AreaDAO areaDAO = new AreaDAO();
			Area area = areaDAO.findById(queryAreaInput.getInput().getAreaId());
			areaDAO.delete(area);
			QiyiyunService.standardMessageOutput(queryAreaInput.getFn(),0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(queryAreaInput.getFn(),2,dataList);
		}
		
		
	}

	/**
	 * 预订工位管理-新建预定工位
	 * @param gson
	 * @param je		input [bookStationName,bookStationPhone,bookStationEmail]
	 * 					deal
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void newBookStation(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->newBookStation");
		BookStationInput newBookStationInput = gson.fromJson(je, BookStationInput.class);
		
		String loginId = newBookStationInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			
			BookstationDAO bookstationDAO = new BookstationDAO();
			Bookstation bookstation = new Bookstation();
			bookstation.setBookstationName(newBookStationInput.getInput().getBookStationName());
			bookstation.setBookstationPhone(newBookStationInput.getInput().getBookStationPhone());
			bookstation.setBookstationEmail(newBookStationInput.getInput().getBookStationPhone());
			
			bookstationDAO.save(bookstation);
			
			QiyiyunService.standardMessageOutput(newBookStationInput.getFn(),0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(newBookStationInput.getFn(),2,dataList);
		}
		
	}
	
	/**
	 * 预定工位管理-删除预定工位
	 * @param gson
	 * @param je		input [bookStationId]
	 * 					deal
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void delBookStation(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->delBookStation");
		BookStationInput delBookStationInput = gson.fromJson(je, BookStationInput.class);
		String loginId = delBookStationInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			BookstationDAO bookstationDAO = new BookstationDAO();
			log.info(delBookStationInput.getInput().getBookStationId()+"-----");
			Bookstation bookstation = bookstationDAO.findById(delBookStationInput.getInput().getBookStationId());
			
			if(bookstation!=null){
			bookstationDAO.delete(bookstation);
			
			QiyiyunService.standardMessageOutput(delBookStationInput.getFn(),0,dataList);
			}
		}else{
			QiyiyunService.standardMessageOutput(delBookStationInput.getFn(),2,dataList);
		}
		
	}

	/**
	 * 预定工位管理-修改预订工位
	 * @param gson
	 * @param je		input [bookStationId,bookStationName,bookStationPhone,bookStationEmail]
	 * 					deal
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void modifyBookStation(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->modifyBookStation");
		BookStationInput modifyBookStationInput = gson.fromJson(je, BookStationInput.class);
		String loginId = modifyBookStationInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			BookstationDAO bookstationDAO = new BookstationDAO();
			Bookstation bookstation = bookstationDAO.findById(modifyBookStationInput.getInput().getBookStationId());
			bookstation.setBookstationName(modifyBookStationInput.getInput().getBookStationName());
			bookstation.setBookstationPhone(modifyBookStationInput.getInput().getBookStationPhone());
			bookstation.setBookstationEmail(modifyBookStationInput.getInput().getBookStationPhone());
			
			bookstationDAO.attachDirty(bookstation);
			
			QiyiyunService.standardMessageOutput(modifyBookStationInput.getFn(),0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(modifyBookStationInput.getFn(),2,dataList);
		}
		
	}

	/**
	 * 预定工位管理-查询预订工位
	 * @param gson
	 * @param je		input [bookStationId]
	 * 					deal
	 * 					output[bookStationId,bookStationName,bookStationPhone,bookStationEmail]
	 * 					result
	 * @param dataList
	 */
	public static void queryBookStation(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->queryBookStation");		
		BookStationInput queryBookStationInput = gson.fromJson(je, BookStationInput.class);
		QueryBookStationOutput queryBookStationOutput = new QueryBookStationOutput();
		String loginId = queryBookStationInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			BookstationDAO bookstationDAO = new BookstationDAO();
			Bookstation bookstation = bookstationDAO.findById(queryBookStationInput.getInput().getBookStationId());
			
			QueryBookStationOutput.Output output = new QueryBookStationOutput.Output();
			output.setBookStationId(bookstation.getBookstationId());
			output.setBookStationName(bookstation.getBookstationName());
			output.setBookStationPhone(bookstation.getBookstationPhone());
			output.setBookStationEmail(bookstation.getBookstationEmail());
			
			queryBookStationOutput.setFn(queryBookStationInput.getFn());
			queryBookStationOutput.setOutput(output);
			queryBookStationOutput.setResult(0);
			
			dataList.add(queryBookStationOutput);
			
			
		}else{
			QiyiyunService.standardMessageOutput(queryBookStationInput.getFn(),2,dataList);
		}
	}

	/**
	 * 预定工位管理-获取预订工位列表
	 * @param gson
	 * @param je		input 
	 * 					deal
	 * 					output List[bookStationId,bookStationName,bookStationPhone,bookStationEmail]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getBookStationList(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->getBookStationList");		
		StandardInputWithLoginId getBookStationListInput = gson.fromJson(je, StandardInputWithLoginId.class);
		GetBookStationListOutput getBookStationListOutput = new GetBookStationListOutput();
		String loginId = getBookStationListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			
			BookstationDAO bookstationDAO = new BookstationDAO();
			List<Bookstation> bookstations = bookstationDAO.findAll();
			List<GetBookStationListOutput.Output> outputs = new ArrayList<GetBookStationListOutput.Output>();
			
			Iterator<Bookstation> it = bookstations.iterator();
			while(it.hasNext()){
				Bookstation bookstation = it.next();
				GetBookStationListOutput.Output output = new GetBookStationListOutput.Output();
				output.setBookStationId(bookstation.getBookstationId());
				output.setBookStationName(bookstation.getBookstationName());
				output.setBookStationPhone(bookstation.getBookstationPhone());
				output.setBookStationEmail(bookstation.getBookstationEmail());
				outputs.add(output);
			}
			
			
			getBookStationListOutput.setFn(getBookStationListInput.getFn());
			getBookStationListOutput.setOutput(outputs);
			getBookStationListOutput.setResult(0);
			
			dataList.add(getBookStationListOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(getBookStationListInput.getFn(),0,dataList);
		}
	}

	
}
