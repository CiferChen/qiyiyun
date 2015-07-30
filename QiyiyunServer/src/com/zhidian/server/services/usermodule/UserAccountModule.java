package com.zhidian.server.services.usermodule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zhidian.server.configuration.Configuration;
import com.zhidian.server.dao.FavoriteDAO;
import com.zhidian.server.dao.GoodsDAO;
import com.zhidian.server.dao.GoodsTypeDAO;
import com.zhidian.server.dao.MessageDAO;
import com.zhidian.server.dao.MessageTypeDAO;
import com.zhidian.server.dao.ServiceGoodsDAO;
import com.zhidian.server.dao.SpaceDAO;
import com.zhidian.server.dao.UserDAO;
import com.zhidian.server.dao.UserMessageRelDAO;
import com.zhidian.server.model.Favorite;
import com.zhidian.server.model.Goods;
import com.zhidian.server.model.GoodsType;
import com.zhidian.server.model.Message;
import com.zhidian.server.model.ServiceGoods;
import com.zhidian.server.model.Space;
import com.zhidian.server.model.User;
import com.zhidian.server.model.UserMessageRel;
import com.zhidian.server.model.input.CheckUserIsExist;
import com.zhidian.server.model.input.CompltRegByPhone;
import com.zhidian.server.model.input.GetDelModifyUserMessageDetailInput;
import com.zhidian.server.model.input.GetRegCodeByPhone;
import com.zhidian.server.model.input.GetUserMessageList;
import com.zhidian.server.model.input.ModUserPsdInput;
import com.zhidian.server.model.input.NewUserMessageInput;
import com.zhidian.server.model.input.RegAndSendByEmail;
import com.zhidian.server.model.input.StandardInputWithLoginId;
import com.zhidian.server.model.input.UserFavoriteInput;
import com.zhidian.server.model.input.UserLogin;
import com.zhidian.server.model.input.UserLoginWithEmail;
import com.zhidian.server.model.input.UserLoginWithPhone;
import com.zhidian.server.model.output.GetUserFavoriteOutput;
import com.zhidian.server.model.output.GetUserMessageDetailOutput;
import com.zhidian.server.model.output.GetUserMessageList.Output;
import com.zhidian.server.model.output.StandardOutput;
import com.zhidian.server.services.QiyiyunService;
import com.zhidian.server.services.managermodule.SystemManageModule;
import com.zhidian.server.utils.CodeGenerator;
import com.zhidian.server.utils.IDGenerator;
import com.zhidian.server.utils.LoginID;
import com.zhidian.server.utils.MD5;
import com.zhidian.server.utils.PhoneCode;

/**
 * 会员账户模块
 * 
 * @author zb
 * 
 */
public class UserAccountModule {
	public static Logger log = Logger.getLogger(UserAccountModule.class);

	/**
	 * 通过手机注册并激活
	 * 
	 * @param gson
	 * @param je
	 */
	public static void compltRegByPhone(Gson gson, JsonElement je,
			List<Object> dataList) {
		CompltRegByPhone compltRegByPhone = gson.fromJson(je,
				CompltRegByPhone.class);
		String phoneNumber = compltRegByPhone.getInput().getPhoneNumb();
		PhoneCode pc = Configuration.getPhoneCode(phoneNumber);
		log.info(pc);
		if (pc!=null&&compltRegByPhone.getInput().getRegCode().equals(pc.getCode())) {
			UserDAO userDAO = new UserDAO();
			User u = new User();
			u.setUserName(phoneNumber);
			u.setUserPhone(phoneNumber);
			u.setUserPassword(compltRegByPhone.getInput().getPassword());
			u.setUserStatus(1);
			u.setUserIsdelete(0);
			try {
				userDAO.save(u);
				Configuration.removeCode(phoneNumber);
				QiyiyunService.standardMessageOutput(compltRegByPhone.getFn(),
						0, dataList);
			} catch (Exception e) {
				log.error("save failed");
				QiyiyunService.standardMessageOutput(compltRegByPhone.getFn(),
						1, dataList);
			}
		} else {
			QiyiyunService.standardMessageOutput(compltRegByPhone.getFn(), 9,
					dataList);
		}
	}

	public static void getRegCodeByPhone(Gson gson, JsonElement je,
			List<Object> dataList) {
		log.info("getRegCodeByPhone");
		GetRegCodeByPhone getRegCodeByPhone = gson.fromJson(je,
				GetRegCodeByPhone.class);
		String code = CodeGenerator.getDynamicCode(true, 6);
		PhoneCode pc = new PhoneCode();
		pc.setCode(code);
		Timer timer = new Timer();
		pc.setTimer(timer);
		Configuration.addPhoneCode(getRegCodeByPhone.getInput().getPhoneNumb(),
				pc);
		int successCount = SystemManageModule.sendSMS(getRegCodeByPhone.getInput().getPhoneNumb(),
				code, false);
		log.info("成功发送信息："+successCount+"条");
	}

	public static void regAndSendByEmail(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("邮箱注册");
		RegAndSendByEmail rasbe = gson.fromJson(je, RegAndSendByEmail.class);
		UserDAO userDAO = new UserDAO();
		User user = new User();
		RegAndSendByEmail.Input input = rasbe.getInput();
		user.setUserEmail(input.EmailAddr);
		user.setUserName(input.UserName);
		user.setUserStatus(1);// 目前假设已激活
		user.setUserPassword(MD5.GetMD5Code(input.Password));
		user.setUserIsdelete(0);
		try {
			userDAO.save(user);
			StandardOutput so = new StandardOutput();
			so.fn = "RegAndSentByEmail";
			so.Result = 0;// 邮箱注册成功
			dataList.add(so);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void activeByEmail(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	/**
	 * 用户名登录
	 * @param gson
	 * @param je
	 * @param dataList
	 */
	public static void userLogin(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("UserLogin");
		UserLogin ul = gson.fromJson(je, UserLogin.class);
		UserDAO userDAO = new UserDAO();
		System.out.println("Server:" + ul.getInput().getUserName() + ":"
				+ ul.getInput().getUserPsd());
		List list = userDAO.loginWithUserName(ul.getInput().getUserName(),
				MD5.GetMD5Code(ul.getInput().getUserPsd()));
		if (list != null && list.size() > 0) {
			User u = (User) list.get(0);// 只有一个
			String loginId = IDGenerator.getUUID();
			LoginID loginID2 = new LoginID(loginId,
					Configuration.LOGINIDTIMELIMIT, false, u.getUserId());
			Configuration.addLoginIds(loginId, loginID2);
			System.out.println("userLogin:" + loginId);
			com.zhidian.server.model.output.UserLogin ulogin = new com.zhidian.server.model.output.UserLogin();
			com.zhidian.server.model.output.UserLogin.Output op = new com.zhidian.server.model.output.UserLogin.Output();
			op.setLoginID(loginId);
			ulogin.setOutput(op);
			ulogin.fn = "UserLogin";
			dataList.add(ulogin);
		} else {
			QiyiyunService.standardMessageOutput(ul.getFn(), 5, dataList);
		}
	}
	/**
	 * 邮箱登录
	 * @param gson
	 * @param je
	 * @param dataList
	 */
	public static void userLoginWithEmail(Gson gson, JsonElement je,
			List<Object> dataList) {
		UserLoginWithEmail ulwe = gson.fromJson(je, UserLoginWithEmail.class);
		UserDAO userDAO = new UserDAO();
		List list = userDAO.loginWithUserName(ulwe.getInput().getUserEmail(),
				MD5.GetMD5Code(ulwe.getInput().getUserPsd()));
		if (list != null && list.size() > 0) {
			User u = (User) list.get(0);// 只有一个
			String loginId = IDGenerator.getUUID();
			LoginID loginID2 = new LoginID(loginId,
					Configuration.LOGINIDTIMELIMIT, false, u.getUserId());
			Configuration.addLoginIds(loginId, loginID2);
			System.out.println("userLogin:" + loginId);
			com.zhidian.server.model.output.UserLogin ulogin = new com.zhidian.server.model.output.UserLogin();
			com.zhidian.server.model.output.UserLogin.Output op = new com.zhidian.server.model.output.UserLogin.Output();
			op.setLoginID(loginId);
			ulogin.setOutput(op);
			ulogin.fn = ulwe.getFn();
			dataList.add(ulogin);
		} else {
			QiyiyunService.standardMessageOutput(ulwe.getFn(), 5, dataList);
		}
	}
	/**
	 * 手机登录
	 * @param gson
	 * @param je
	 * @param dataList
	 */
	public static void userLoginWithPhone(Gson gson, JsonElement je,
			List<Object> dataList) {
		UserLoginWithPhone ulwp = gson.fromJson(je, UserLoginWithPhone.class);
		UserDAO userDAO = new UserDAO();
		System.out.println("Server:" + ulwp.getInput().getUserPhone() + ":"
				+ ulwp.getInput().getUserPsd());
		List list = userDAO.loginWithUserName(ulwp.getInput().getUserPhone(),
				MD5.GetMD5Code(ulwp.getInput().getUserPsd()));
		if (list != null && list.size() > 0) {
			User u = (User) list.get(0);// 只有一个
			String loginId = IDGenerator.getUUID();
			LoginID loginID2 = new LoginID(loginId,
					Configuration.LOGINIDTIMELIMIT, false, u.getUserId());
			Configuration.addLoginIds(loginId, loginID2);
			com.zhidian.server.model.output.UserLogin ulogin = new com.zhidian.server.model.output.UserLogin();
			com.zhidian.server.model.output.UserLogin.Output op = new com.zhidian.server.model.output.UserLogin.Output();
			op.setLoginID(loginId);
			ulogin.setOutput(op);
			ulogin.fn = ulwp.getFn();
			dataList.add(ulogin);
		} else {
			QiyiyunService.standardMessageOutput(ulwp.getFn(), 5, dataList);
		}
	}

	public static void userLogout(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	/**
	 * 修改用户密码
	 * 
	 * @param gson
	 * @param je
	 *            input[oldPsd,newPsd] output result
	 */
	public static void modUserPsd(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->modUserPsd");
		ModUserPsdInput modUserPsdInput = gson.fromJson(je,
				ModUserPsdInput.class);
		String loginId = modUserPsdInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			UserDAO userDAO = new UserDAO();
			User u = userDAO.findById(userId);
			if (u.getUserPassword().equals(
					MD5.GetMD5Code(modUserPsdInput.getInput().getOldPsd()))) {
				u.setUserPassword(MD5.GetMD5Code(modUserPsdInput.getInput()
						.getNewPsd()));
				userDAO.attachDirty(u);
				QiyiyunService.standardMessageOutput(modUserPsdInput.getFn(),
						0, dataList);
			} else {
				QiyiyunService.standardMessageOutput(modUserPsdInput.getFn(),
						1, dataList);
				System.out.println("原密码不正确");
			}
		} else {
			QiyiyunService.standardMessageOutput(modUserPsdInput.getFn(), 2,
					dataList);
		}
	}

	public static void applyUserEmailBind(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	public static void bindUserEmail(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	public static void applyUserPhoneBind(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	public static void bindUserPhone(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	public static void getUserMessageList(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println(je);
		GetUserMessageList guml = gson.fromJson(je, GetUserMessageList.class);
		log.info(guml.getInput().messageType + ":"
				+ guml.getInput().getLoginId());
		String loginId = guml.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			log.info("userId:" + userId);
			UserMessageRelDAO userMessageRelDAO = new UserMessageRelDAO();
			List<UserMessageRel> userMessageRels = userMessageRelDAO
					.findByUserId(userId);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < userMessageRels.size(); i++) {
				if (i != userMessageRels.size()) {
					sb.append(userMessageRels.get(i).getMessageId() + ",");
				}
			}
			MessageDAO messageDAO = new MessageDAO();
			List<Message> messages = messageDAO.findByIds(sb.toString());
			com.zhidian.server.model.output.GetUserMessageList getUserMessageList = new com.zhidian.server.model.output.GetUserMessageList();
			List<Output> outputs = new ArrayList<Output>();
			if (messages != null) {
				Iterator<Message> it = messages.iterator();
				getUserMessageList.setFn("GetUserMessageList");
				while (it.hasNext()) {
					Message message = it.next();
					Output output = new Output();
					output.setMessageId(message.getMessageId());
					output.setMessageTime(message.getSendTime());
					output.setMessageTitle(message.getMessageTitle());
					output.setMessageType(message.getMessageType()
							.getMessageTypeName());// 此处ID要做解析
					outputs.add(output);
				}
			}
			getUserMessageList.setOutput(outputs);
			dataList.add(getUserMessageList);
		} else {
			QiyiyunService.standardMessageOutput("GetUserMessageList", 2,
					dataList);
		}
	}

	public static void getUserMessageDetail(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->获取用户消息明细");
		GetDelModifyUserMessageDetailInput gumdInput = gson.fromJson(je,
				GetDelModifyUserMessageDetailInput.class);
		String loginId = gumdInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);// 激活计时器
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {

			GetUserMessageDetailOutput gumdOutput = new GetUserMessageDetailOutput();
			MessageDAO messageDAO = new MessageDAO();
			Message message = null;
			message = messageDAO.findById(gumdInput.getInput().getMessageId());
			gumdOutput.setFn(gumdInput.getFn());
			com.zhidian.server.model.output.GetUserMessageDetailOutput.Output output = new com.zhidian.server.model.output.GetUserMessageDetailOutput.Output();
			output.setMessageId(message.getMessageId());
			output.setMessageType(message.getMessageType().getMessageTypeName());
			output.setMessageTitle(message.getMessageTitle());
			output.setMessageTime(message.getCreateTime());
			output.setMessageContent(message.getContent());
			gumdOutput.setOutput(output);
			dataList.add(gumdOutput);
		} else {
			QiyiyunService
					.standardMessageOutput(gumdInput.getFn(), 2, dataList);
		}
	}

	public static void newUserMessage(Gson gson, JsonElement je,
			List<Object> dataList) {
		NewUserMessageInput newUserMessage = gson.fromJson(je,
				NewUserMessageInput.class);
		String loginId = newUserMessage.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);// 激活计时器
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			MessageDAO messageDAO = new MessageDAO();
			MessageTypeDAO messageTypeDAO = new MessageTypeDAO();
			Message message = new Message();
			message.setMessageCreatorId(userId);
			message.setCreateTime(Calendar.getInstance().getTimeInMillis() + "");
			message.setMessageReceiverId(newUserMessage.getInput()
					.getReceiverId());
			message.setMessageTitle(newUserMessage.getInput().getMessageTitle());
			message.setContent(newUserMessage.getInput().getMessageContent());
			message.setMessageType(messageTypeDAO
					.findById("402880e74e4f0d1c014e4f0db9c50002"));
			message.setMessageIsDelete(0);
			messageDAO.save(message);
			UserMessageRelDAO userMessageRelDAO = new UserMessageRelDAO();
			UserMessageRel userMessageRel = new UserMessageRel();
			userMessageRel.setUserId(userId);
			userMessageRel.setMessageId(message.getMessageId());
			userMessageRelDAO.save(userMessageRel);
			QiyiyunService.standardMessageOutput(newUserMessage.getFn(), 0,
					dataList);
		} else {
			QiyiyunService.standardMessageOutput(newUserMessage.getFn(), 2,
					dataList);
		}
	}

	public static void delUserMessage(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->删除消息");
		GetDelModifyUserMessageDetailInput gumdInput = gson.fromJson(je,
				GetDelModifyUserMessageDetailInput.class);
		String loginId = gumdInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);// 激活计时器
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			GetUserMessageDetailOutput gumdOutput = new GetUserMessageDetailOutput();
			MessageDAO messageDAO = new MessageDAO();
			Message message = null;
			int result = messageDAO.deleteById(gumdInput.getInput()
					.getMessageId());
			if (result > 0) {
				QiyiyunService.standardMessageOutput(gumdInput.getFn(), 0,
						dataList);
			} else {
				QiyiyunService.standardMessageOutput(gumdInput.getFn(), 8,
						dataList);
			}
		} else {
			QiyiyunService
					.standardMessageOutput(gumdInput.getFn(), 2, dataList);
		}
	}

	public static void modifyUserMessage(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->修改消息");
		GetDelModifyUserMessageDetailInput gumdInput = gson.fromJson(je,
				GetDelModifyUserMessageDetailInput.class);
		String loginId = gumdInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);// 激活计时器
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			GetUserMessageDetailOutput gumdOutput = new GetUserMessageDetailOutput();
			MessageDAO messageDAO = new MessageDAO();
			Message message = null;
			int result = messageDAO.deleteById(gumdInput.getInput()
					.getMessageId());
			if (result > 0) {
				QiyiyunService.standardMessageOutput(gumdInput.getFn(), 0,
						dataList);
			} else {
				QiyiyunService.standardMessageOutput(gumdInput.getFn(), 8,
						dataList);
			}
		} else {
			QiyiyunService
					.standardMessageOutput(gumdInput.getFn(), 2, dataList);
		}
	}

	public static void delUserMessageAll(Gson gson, JsonElement je,
			List<Object> dataList) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取用户收藏夹
	 * 
	 * @param gson
	 * @param je
	 *            input output
	 *            List[serviceGoodsThumb,serviceGoodsName,serviceGoodsSpaceAddress
	 *            ,servivePrice,serviceMargin,serviceTypeName] result
	 */
	@SuppressWarnings("unchecked")
	public static void getUserFavorite(Gson gson, JsonElement je,
			List<Object> dataList) {
		System.out.println("---Server--->getUserFavorite");
		StandardInputWithLoginId getUserFavoriteInput = gson.fromJson(je,
				StandardInputWithLoginId.class);
		GetUserFavoriteOutput getUserFavoriteOutput = new GetUserFavoriteOutput();
		String loginId = getUserFavoriteInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			FavoriteDAO favoriteDAO = new FavoriteDAO();
			GoodsDAO goodsDAO = new GoodsDAO();
			ServiceGoodsDAO serviceGoodsDAO = new ServiceGoodsDAO();
			SpaceDAO spaceDAO = new SpaceDAO();
			GoodsTypeDAO goodsTypeDAO = new GoodsTypeDAO();
			List<GetUserFavoriteOutput.Output> outputs = new ArrayList<GetUserFavoriteOutput.Output>();
			List<Favorite> favorites = favoriteDAO.findByUserId(userId);
			if (favorites != null) {
				Iterator<Favorite> it = favorites.iterator();
				while (it.hasNext()) {
					Favorite favorite = it.next();
					Goods goods = goodsDAO.findById(favorite.getGoodsId());
					ServiceGoods serviceGoods = serviceGoodsDAO
							.findById(favorite.getServiceGoodsId());
					Space goodsSpace = spaceDAO.findById(goods
							.getGoodsSpaceId());
					GoodsType goodsType = goodsTypeDAO.findById(goods
							.getGoodsTypeId());
					GetUserFavoriteOutput.Output output = new GetUserFavoriteOutput.Output();
					output.setServiceGoodsName(serviceGoods
							.getServiceGoodsName());
					output.setServiceGoodsSpaceAddress(goodsSpace
							.getSpaceAddress());
					output.setServiceGoodsThumb(goods.getGoodsThumb());
					output.setSrviceTypeName(goodsType.getGoodsTypeName());
					output.setServivePrice(goods.getGoodsPrice().toString());
					output.setServiceMargin(serviceGoods
							.getServiceGoodsMargin().toString());
					outputs.add(output);

				}
			}
			getUserFavoriteOutput.setFn(getUserFavoriteInput.getFn());
			getUserFavoriteOutput.setOuput(outputs);
			getUserFavoriteOutput.setResult(0);
			dataList.add(getUserFavoriteOutput);
		} else {
			QiyiyunService.standardMessageOutput(getUserFavoriteInput.getFn(),
					2, dataList);
		}

	}

	/**
	 * 添加商品到收藏夹
	 * 
	 * @param gson
	 * @param je
	 *            input[userId,goodsId,serviceGoodsId] output result
	 * @param dataList
	 */
	public static void addtoUserFavorite(Gson gson, JsonElement je,
			List<Object> dataList) {
		log.info("---Server--->addtoUserFavorite");
		UserFavoriteInput userFavoriteInput = gson.fromJson(je,
				UserFavoriteInput.class);
		String loginId = userFavoriteInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			FavoriteDAO favoriteDAO = new FavoriteDAO();
			Favorite favorite = new Favorite();
			favorite.setUserId(userId);
			favorite.setGoodsId(userFavoriteInput.getInput().getGoodsId());
			favorite.setServiceGoodsId(userFavoriteInput.getInput()
					.getServiceGoodsId());
			favoriteDAO.save(favorite);
			QiyiyunService.standardMessageOutput(userFavoriteInput.getFn(), 0,
					dataList);

		} else {
			QiyiyunService.standardMessageOutput(userFavoriteInput.getFn(), 2,
					dataList);
		}
	}

	/**
	 * 删除收藏夹内商品
	 * 
	 * @param gson
	 * @param je
	 *            input[favoriteId] output result
	 * @param dataList
	 */
	public static void delUserFavorite(Gson gson, JsonElement je,
			List<Object> dataList) {
		log.info("---Server--->delUserFavorite");
		UserFavoriteInput userFavoriteInput = gson.fromJson(je,
				UserFavoriteInput.class);
		String loginId = userFavoriteInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			FavoriteDAO favoriteDAO = new FavoriteDAO();
			Favorite favorite = favoriteDAO.findById(userFavoriteInput
					.getInput().getFavoriteId());
			favoriteDAO.delete(favorite);
			QiyiyunService.standardMessageOutput(userFavoriteInput.getFn(), 0,
					dataList);

		} else {
			QiyiyunService.standardMessageOutput(userFavoriteInput.getFn(), 2,
					dataList);
		}

	}

	/**
	 * 清空用户收藏夹内商品
	 * 
	 * @param gson
	 * @param je
	 *            input output result
	 * @param dataList
	 */
	public static void clearUserFavorite(Gson gson, JsonElement je,
			List<Object> dataList) {
		log.info("---Server--->clearUserFavorite");
		StandardInputWithLoginId userFavoriteInput = gson.fromJson(je,
				StandardInputWithLoginId.class);
		String loginId = userFavoriteInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			FavoriteDAO favoriteDAO = new FavoriteDAO();
			int result = favoriteDAO.deleteAllByUserId(userId);
			QiyiyunService.standardMessageOutput(userFavoriteInput.getFn(), 0,
					dataList);
		} else {
			QiyiyunService.standardMessageOutput(userFavoriteInput.getFn(), 2,
					dataList);
		}
	}

	public static void checkUserIsExist(Gson gson, JsonElement je,
			List<Object> dataList) {
		log.info("检测用户是否存在");
		CheckUserIsExist cie = gson.fromJson(je, CheckUserIsExist.class);
		UserDAO userDAO = new UserDAO();
		switch (cie.getInput().getType()) {
		case 0:
			List<User> users = null;
			try {
				users = userDAO.findByUserName(cie.getInput().getTypeEx());
			} catch (Exception e) {
				e.printStackTrace();
			}
			StandardOutput so = new StandardOutput();
			so.setFn("CheckUserIsExist");
			if (users == null) {
				so.setResult(1);
			} else {
				if (users.size() > 0) {
					so.setResult(0);
					System.out.println("已存在这个用户名");
				} else {
					so.setResult(0);
					System.out.println("这个用户名不存在，可以注册");
				}
			}
			dataList.add(so);
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;
		}

	}
}
