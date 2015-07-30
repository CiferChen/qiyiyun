package com.zhidian.server.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.opensymphony.xwork2.ActionSupport;
import com.zhidian.server.configuration.Configuration;
import com.zhidian.server.configuration.Result;
import com.zhidian.server.model.input.StandardInput;
import com.zhidian.server.model.output.StandardOutput;
import com.zhidian.server.services.managermodule.SystemManageModule;
import com.zhidian.server.services.usermodule.UserAccountModule;
import com.zhidian.server.services.usermodule.UserOrganizationModule;
import com.zhidian.server.services.usermodule.UserPersonModule;

public class QiyiyunService extends ActionSupport {
	public static Logger log = Logger.getLogger(QiyiyunService.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 2548744542521947417L;
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpSession session;
	private List<Object> dataList;

	public List<Object> getDataList() {
		return dataList;
	}

	/**
	 * 获取客户端IP
	 * 
	 * @return
	 */
	public String getIP() {
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		return ip;
	}

	/**
	 * 检测IP
	 * 
	 * @param ip
	 * @return
	 */
	public boolean checkIP(String ip) {
		boolean result = false;
		if (Configuration.ips.contains(ip)) {
			result = true;
		}
		return result;
	}

	/**
	 * 服务器入口
	 * 
	 * @return
	 */
	public String Entry() {
		dataList = new ArrayList<Object>();
		if (checkIP(getIP())) {
			String params = request.getParameter("params");
			System.out.println(params);
			if (params == null || params.equals("")) {
				Result re = new Result(
						Configuration.messages.get("params_error"));
				dataList.add(re);
			} else {
				Gson gson = new Gson();
				JsonParser jp = new JsonParser();
				JsonElement el = jp.parse(params);
				if (el.isJsonArray()) {
					JsonArray ja = el.getAsJsonArray();
					for (int i = 0; i < ja.size(); i++) {
						JsonElement je = ja.get(i);
						StandardInput si = gson.fromJson(je,
								StandardInput.class);
						String method = si.getFn();
						if (method.equals("CheckUserIsExist")) {// 检测用户是否存在
							UserAccountModule.checkUserIsExist(gson, je,
									dataList);
						} else if (method.equals("GetRegCodeByPhone")) {// 通过手机获取动态验证码
							UserAccountModule.getRegCodeByPhone(gson, je,
									dataList);
						} else if (method.equals("CompltRegByPhone")) {// 通过手机注册
							UserAccountModule.compltRegByPhone(gson, je,
									dataList);
						} else if (method.equals("RegAndSendByEmail")) {// 通过邮箱注册，并发送激活码
							UserAccountModule.regAndSendByEmail(gson, je,
									dataList);
						} else if (method.equals("ActiveByEmail")) {// 通过邮箱激活
							UserAccountModule.activeByEmail(gson, je, dataList);
						} else if (method.equals("UserLogin")) {// 用户登录
							UserAccountModule.userLogin(gson, je, dataList);
						} else if (method.equals("UserLoginWithEmail")) {//邮箱登录
							UserAccountModule.userLoginWithEmail(gson, je,
									dataList);
						}else if(method.equals("UserLoginWithPhone")){//手机登录
							UserAccountModule.userLoginWithPhone(gson, je, dataList);
						} else if (method.equals("UserLogout")) {// 用户登出
							UserAccountModule.userLogout(gson, je, dataList);
						} else if (method.equals("GetUserMessageList")) {// 获取消息列表
							UserAccountModule.getUserMessageList(gson, je,
									dataList);
						} else if (method.equals("GetUserMessageDetail")) {// 获取消息详情
							UserAccountModule.getUserMessageDetail(gson, je,
									dataList);
						} else if (method.equals("NewUserMessage")) {// 新建消息
							UserAccountModule
									.newUserMessage(gson, je, dataList);
						} else if (method.equals("DelUserMessage")) {// 删除消息
							UserAccountModule
									.delUserMessage(gson, je, dataList);
						} else if (method.equals("ModifyUserMessage")) {// 修改消息
							UserAccountModule.modifyUserMessage(gson, je,
									dataList);
						} else if (method.equals("DelUserMessageAll")) {// 删除全部消息
							UserAccountModule.delUserMessageAll(gson, je,
									dataList);
						} else if (method.equals("AddMessageType")) {// 添加消息类型
							SystemManageModule.addMessageType(gson, je,
									dataList);
						} else if (method.equals("GetMessageTypeList")) {// 获取消息类型列表
							SystemManageModule.getMessageTypeList(gson, je,
									dataList);
						} else if (method.equals("DelMessageType")) {// 删除消息类型
							SystemManageModule.delMessageType(gson, je,
									dataList);
						} else if (method.equals("ModifyMessageType")) {// 修改消息类型
							SystemManageModule.modifyMessageType(gson, je,
									dataList);
						} else if (method.equals("ModUserPsd")) {// 修改用户密码
							UserAccountModule.modUserPsd(gson, je, dataList);
						} else if (method.equals("ApplyUserEmailBind")) {// 申请绑定邮箱
							UserAccountModule.applyUserEmailBind(gson, je,
									dataList);
						} else if (method.equals("BindUserEmail")) {// 绑定邮箱
							UserAccountModule.bindUserEmail(gson, je, dataList);
						} else if (method.equals("ApplyUserPhoneBind")) {// 申请手机绑定
							UserAccountModule.applyUserPhoneBind(gson, je,
									dataList);
						} else if (method.equals("BindUserPhone")) {// 绑定手机
							UserAccountModule.bindUserPhone(gson, je, dataList);
						} else if (method.equals("GetUserFavorite")) {// 获取会员收藏夹
							UserAccountModule.getUserFavorite(gson, je,
									dataList);
						} else if (method.equals("AddtoUserFavorite")) {// 添加商品到会员收藏夹
							UserAccountModule.addtoUserFavorite(gson, je,
									dataList);
						} else if (method.equals("DelUserFavorite")) {// 删除收藏夹中商品
							UserAccountModule.delUserFavorite(gson, je,
									dataList);
						} else if (method.equals("ClearUserFavorite")) {// 清空收藏夹
							UserAccountModule.clearUserFavorite(gson, je,
									dataList);
						} else if (method.equals("GetUserPersonalInfo")) {// 获取会员个人信息
							UserPersonModule.getUserPersonalInfo(gson, je,
									dataList);
						}  else if (method.equals("NewUserPerson")) {// 新增会员个人
							UserPersonModule.newUserPerson(gson, je,
									dataList);
						} else if (method.equals("UpdateUserPersonalInfo")) {// 更新会员个人信息
							UserPersonModule.updateUserPersonalInfo(gson, je,
									dataList);
						} else if (method
								.equals("GetUserPersonalCertificateDetail")) {// 查询个人认证详情
							UserPersonModule.getUserPersonalCertificateDetail(
									gson, je, dataList);
						} else if (method
								.equals("ModifyUserPersonalCertificate")) {// 修改个人认证详情
							UserPersonModule.modifyUserPersonalCertificate(
									gson, je, dataList);
						} else if (method
								.equals("GetUserPersonalCertificateList")) {// 获取会员个人认证列表
							UserPersonModule.getUserPersonalCertificateList(
									gson, je, dataList);
						} else if (method
								.equals("ApplyUserFirstPersonalCertificate")) {// 申请实名校验
							UserPersonModule.applyUserFirstPersonalCertificate(
									gson, je, dataList);
						} else if (method.equals("GetUserPersonalAccount")) {// 获取会员个人账户
							UserPersonModule.getUserPersonalAccount(gson, je,
									dataList);
						} else if (method.equals("GetUserPersonalAccountInfo")) {// 获取会员个人账户信息
							UserPersonModule.getUserPersonalAccountInfo(gson,
									je, dataList);
						} else if (method.equals("GetUserPersonalInvitation")) {// 获取邀请
							UserPersonModule.getUserPersonalInvitation(gson,
									je, dataList);
						} else if (method
								.equals("DeleteUserApplyToOrganHistoryAll")) {// 删除全部邀请加入历史记录
							UserPersonModule.deleteUserApplyToOrganHistoryAll(
									gson, je, dataList);
						} else if (method
								.equals("DeleteUserApplyToOrganHistory")) {// 删除邀请加入历史记录
							UserPersonModule.deleteUserApplyToOrganHistory(
									gson, je, dataList);
						} else if (method
								.equals("GetUserApplyToOrganHistoryList")) {// 获取邀请加入历史记录
							UserPersonModule.getUserApplyToOrganHistoryList(
									gson, je, dataList);
						} else if (method.equals("DealUserPersonalInvitation")) {// 处理邀请
							UserPersonModule.dealUserPersonalInvitation(gson,
									je, dataList);
						} else if (method.equals("NewUserApplyToOrgan")) {// 新建邀请
							UserPersonModule.newUserApplyToOrgan(gson, je,
									dataList);
						} else if (method
								.equals("GetUserPersonalRelateToOrgan")) {// 获取个人身份列表
							UserPersonModule.getUserPersonalRelateToOrgan(gson,
									je, dataList);
						} else if (method.equals("StartUserPersonalRecharge")) {// 开始个人账户充值
							UserPersonModule.startUserPersonalRecharge(gson,
									je, dataList);
						} else if (method.equals("CancelUserPersonalRecharge")) {// 取消个人账户充值
							UserPersonModule.cancelUserPersonalRecharge(gson,
									je, dataList);
						} else if (method.equals("FinishUserPersonalRecharge")) {// 完成个人账户充值
							UserPersonModule.finishUserPersonalRecharge(gson,
									je, dataList);
						} else if (method.equals("GetUserPersonalRechargeList")) {// 获取个人充值列表
							UserPersonModule.getUserPersonalRechargeList(gson,
									je, dataList);
						} else if (method.equals("GetPersonalOrderList")) {// 获取个人订单
							UserPersonModule.getPersonalOrderList(gson, je,
									dataList);
						} else if (method.equals("GetPersonalOrderDetail")) {// 获取个人订单详情
							UserPersonModule.getPersonalOrderDetail(gson, je,
									dataList);
						} else if (method.equals("SubmitPersonalOrder")) {// 提交订单
							UserPersonModule.submitPersonalOrder(gson, je,
									dataList);
						} else if (method.equals("PayPersonalOrder")) {// 支付订单
							UserPersonModule.payPersonalOrder(gson, je,
									dataList);
						} else if (method.equals("CompletePersonalOrder")) {// 完成订单
							UserPersonModule.completePersonalOrder(gson, je,
									dataList);
						} else if (method.equals("EvaluationPersonalOrder")) {// 评价订单
							UserPersonModule.evaluationPersonalOrder(gson, je,
									dataList);
						} else if (method.equals("CancelPersonalOrder")) {// 取消订单
							UserPersonModule.cancelPersonalOrder(gson, je,
									dataList);
						} else if (method
								.equals("ApplicationForBackPersonalOrder")) {// 申请退单
							UserPersonModule.applicationForBackPersonalOrder(
									gson, je, dataList);
						} else if (method.equals("GetCertificationList")) {// 获取认证列表 input 个人 或者 组织
							UserOrganizationModule.getCertificationList(
									gson, je, dataList);
						} else if (method.equals("GetUserOrganListByType")) {// 获取会员组织列表
							UserOrganizationModule.getUserOrganListByType(gson, je,
									dataList);
						} else if (method.equals("NewUserOrgan")) {// 新建组织
							UserOrganizationModule.newUserOrgan(gson, je,
									dataList);
						} else if (method.equals("GetUserOrganInfo")) {// 获取组织信息
							UserOrganizationModule.getUserOrganInfo(gson, je,
									dataList);
						} else if (method.equals("UpdateUserOrganInfo")) {// 更新组织信息
							UserOrganizationModule.updateUserOrganInfo(gson,
									je, dataList);
						} else if (method
								.equals("QueryOrganCertificationDetail")) {// 查询组织认证详情
							UserOrganizationModule
									.queryOrganCertificationDetail(gson, je,
											dataList);
						} else if (method
								.equals("ModifyOrganCertificationInfo")) {// 修改组织认证详情
							UserOrganizationModule
									.modifyOrganCertificationInfo(gson, je,
											dataList);
						} else if (method.equals("GetOrganCertificationListByType")) {// 分类获取组织认证列表
							UserOrganizationModule.getOrganCertificationListByType(
									gson, je, dataList);
						} else if (method
								.equals("ApplicationForRealCertification")) {// 申请真实性认证
							UserOrganizationModule
									.applicationForRealCertification(gson, je,
											dataList);
						} else if (method.equals("QueryOrganBalance")) {// 组织信息管理-组织账户信息管理-查询余额
							UserOrganizationModule.queryOrganBalance(gson, je,
									dataList);
						} else if (method.equals("QueryOrganMarginBalance")) {// 组织信息管理-组织账户信息管理-查询保障金
							UserOrganizationModule.queryOrganMarginBalance(gson, je,
									dataList);
						} else if (method.equals("GetOrganAccountRecordList")) {// 组织信息管理-组织账户信息管理-查询收支明细
							UserOrganizationModule.getOrganAccountRecordList(gson, je,
									dataList);
						} else if (method.equals("StartOrganRecharge")) {// 开始组织账户充值
							UserOrganizationModule.startOrganRecharge(gson, je,
									dataList);
						} else if (method.equals("CancelOrganRecharge")) {// 取消组织充值
							UserOrganizationModule.cancelOrganRecharge(gson,
									je, dataList);
						} else if (method.equals("CompleteOrganRecharge")) {// 完成充值
							UserOrganizationModule.completeOrganRecharge(gson,
									je, dataList);
						} else if (method.equals("QueryOrganOrderList")) {// 查询订单列表
							UserOrganizationModule.queryOrganOrderList(gson,
									je, dataList);
						} else if (method.equals("QueryOrganOrderDetail")) {// 查询订单详情
							UserOrganizationModule.queryOrganOrderDetail(gson,
									je, dataList);
						} else if (method.equals("SubmitOrganOrder")) {// 提交订单
							UserOrganizationModule.submitOrganOrder(gson, je,
									dataList);
						} else if (method.equals("PayOrganOrder")) {// 支付订单
							UserOrganizationModule.payOrganOrder(gson, je,
									dataList);
						} else if (method.equals("CompleteOrganOrder")) {// 完成订单
							UserOrganizationModule.completeOrganOrder(gson, je,
									dataList);
						} else if (method.equals("EvaluationOrganOrder")) {// 评价订单
							UserOrganizationModule.evaluationOrganOrder(gson,
									je, dataList);
						} else if (method.equals("CancelOrganOrder")) {// 取消订单
							UserOrganizationModule.cancelOrganOrder(gson, je,
									dataList);
						} else if (method
								.equals("ApplicationForOrganBackOrder")) {// 申请退单
							UserOrganizationModule
									.applicationForOrganBackOrder(gson, je,
											dataList);
						} else if (method.equals("QuerySubDepartmentList")) {// 查询子部门列表
							UserOrganizationModule.querySubDepartmentList(gson,
									je, dataList);
						} else if (method.equals("NewDepartment")) {// 新建部门
							UserOrganizationModule.newDepartment(gson, je,
									dataList);
						} else if (method.equals("ChangeDepartmentName")) {// 更改部门名称
							UserOrganizationModule.changeDepartmentName(gson,
									je, dataList);
						} else if (method.equals("DeleteDepartment")) {// 删除部门
							UserOrganizationModule.deleteDepartment(gson, je,
									dataList);
						} else if (method.equals("GetUserApplyToOrgan")) {// 获取加入申请列表
							UserOrganizationModule.getUserApplyToOrgan(gson,
									je, dataList);
						} else if (method.equals("DealUserApplyToOrgan")) {// 审核加入申请
							UserOrganizationModule.dealUserApplyToOrgan(gson,
									je, dataList);
						} else if (method.equals("NewUserInvitePeople")) {// 邀请个人加入
							UserOrganizationModule.newUserInvitePeople(gson,
									je, dataList);
						} else if (method.equals("GetMemberList")) {// 获取成员列表
							UserOrganizationModule.getMemberList(gson, je,
									dataList);
						} else if (method.equals("ApplyMemberRole")) {// 成员角色配置
							UserOrganizationModule.applyMemberRole(gson, je,
									dataList);
						} else if (method.equals("DelMember")) {// 删除成员
							UserOrganizationModule
									.delMember(gson, je, dataList);
						} else if (method.equals("GetOrganRightList")) {// 获取权限列表
							UserOrganizationModule.getOrganRightList(gson, je,
									dataList);
						} else if (method.equals("GetOrganRoleList")) {// 获取角色列表
							UserOrganizationModule.getOrganRoleList(gson, je,
									dataList);
						} else if (method.equals("NewOrganRole")) {// 新建角色
							UserOrganizationModule.newOrganRole(gson, je, dataList);
						} else if (method.equals("ApplyOrganRoleRight")) {// 角色权限配置
							UserOrganizationModule.applyOrganRoleRight(gson, je,
									dataList);
						} else if (method.equals("DeleteOrganRole")) {// 删除角色
							UserOrganizationModule.deleteOrganRole(gson, je,
									dataList);
						} else if (method.equals("GetSettledSpaceList")) {// 获取入驻场地列表
							UserOrganizationModule.getSettledSpaceList(gson,
									je, dataList);
						}else if (method.equals("GetServiceOrderList")) {// 获取服务单列表
							UserOrganizationModule.getServiceOrderList(gson,
									je, dataList);
						} else if (method.equals("ApplicationForService")) {// 服务预约申请
							UserOrganizationModule.applicationForService(gson,
									je, dataList);
						} else if (method.equals("CancelApplicationForService")) {// 取消预约申请
							UserOrganizationModule.cancelApplicationForService(
									gson, je, dataList);
						} else if (method.equals("ApplicationForCancelService")) {// 申请取消预约
							UserOrganizationModule.applicationForCancelService(
									gson, je, dataList);
						} else if (method.equals("ConfigStation")) {// 工位配置
							UserOrganizationModule.configStation(gson, je,
									dataList);
						} else if (method.equals("StationRenewals")) {// 工位续费
							UserOrganizationModule.stationRenewals(gson, je,
									dataList);
						} else if (method.equals("GetMeetingList")) {// 获取会议列表
							UserOrganizationModule.getMeetingList(gson, je,
									dataList);
						} else if (method.equals("QueryMeetingDetail")) {// 查询会议详情
							UserOrganizationModule.queryMeetingDetail(gson, je,
									dataList);
						} else if (method.equals("ConfigMeeting")) {// 会议配置
							UserOrganizationModule.configMeeting(gson, je,
									dataList);
						} else if (method.equals("SendMeetingNotification")) {// 发送会议通知
							UserOrganizationModule.sendMeetingNotification(
									gson, je, dataList);
						} else if (method.equals("DelayMeeting")) {// 会议延时
							UserOrganizationModule.delayMeeting(gson, je,
									dataList);
						} else if (method.equals("RecordMeeting")) {// 会议记录
							UserOrganizationModule.recordMeeting(gson, je,
									dataList);
						} else if (method.equals("GetVisitorList")) {// 获取访客列表
							UserOrganizationModule.getVisitorList(gson, je,
									dataList);
						} else if (method.equals("QueryVisitorDetail")) {// 查询访客详情
							UserOrganizationModule.queryVisitorDetail(gson, je,
									dataList);
						} else if (method.equals("AddVisitor")) {// 添加访客
							UserOrganizationModule.addVisitor(gson, je,
									dataList);
						} else if (method.equals("DeleteVisitor")) {// 删除访客
							UserOrganizationModule.deleteVisitor(gson, je,
									dataList);
						} else if (method.equals("GetActivityList")) {// 获取活动列表
							UserOrganizationModule.getActivityList(gson, je,
									dataList);
						} else if (method.equals("GetActivityRegisterList")) {// 获取活动报名列表
							UserOrganizationModule.getActivityRegisterList(gson,
									je, dataList);
						} else if (method.equals("ApplicationForNewActivity")) {// 申请新活动
							UserOrganizationModule.applicationForNewActivity(
									gson, je, dataList);
						} else if (method.equals("QueryActivity")) {// 查看活动
							UserOrganizationModule.queryActivity(gson, je,
									dataList);
						} else if (method.equals("CancelActivity")) {// 取消活动
							UserOrganizationModule.cancelActivity(gson, je,
									dataList);
						} else if (method.equals("ShowArticleUI")) {// 文章展示
							UIModule.showArticleUI(gson, je, dataList);
						} else if (method.equals("GetArticleListByTypeUI")) {// 分类获取文章列表
							UIModule.getArticleListByTypeUI(gson, je, dataList);
						} else if (method.equals("QueryArticleDetailUI")) {// 查询文章详情
							UIModule.queryArticleDetailUI(gson, je, dataList);
						} else if (method.equals("GetArticleTypeListUI")) {// 获取文章分类列表
							UIModule.getArticleTypeListUI(gson, je, dataList);
						} else if (method.equals("ResetPasswordByEmailUI")) {// 邮箱重置密码
							UIModule.resetPasswordByEmailUI(gson, je, dataList);
						} else if (method.equals("ResetPasswordByPhoneUI")) {// 手机号重置密码
							UIModule.resetPasswordByPhoneUI(gson, je, dataList);
						} else if (method.equals("ResetLoginPasswordUI")) {// 重置登录密码
							UIModule.resetLoginPasswordUI(gson, je, dataList);
						} else if (method.equals("GetRegisteredSpaceListUI")) {// 获取注册场地列表
							UIModule.getRegisteredSpaceListUI(gson, je,
									dataList);
						} else if (method
								.equals("QueryRegisteredSpaceDetailUI")) {// 查询注册场地信息
							UIModule.queryRegisteredSpaceDetailUI(gson, je,
									dataList);
						} else if (method.equals("GetSubAreaListUI")) {// 获取子区域列表
							UIModule.getSubAreaListUI(gson, je, dataList);
						} else if (method.equals("QueryAreaDetailUI")) {// 查询区域详细信息
							UIModule.queryAreaDetailUI(gson, je, dataList);
						} else if (method.equals("GetStationListUI")) {// 获取工位列表
							UIModule.getStationListUI(gson, je, dataList);
						} else if (method.equals("QueryStationDetailUI")) {// 查询工位详细信息
							UIModule.queryStationDetailUI(gson, je, dataList);
						} else if (method.equals("GetMeetiongRoomLIstUI")) {// 获取会议室列表
							UIModule.getMeetiongRoomLIstUI(gson, je, dataList);
						} else if (method.equals("GetMeetingRoomDetailUI")) {// 查询会议室详细信息
							UIModule.getMeetingRoomDetailUI(gson, je, dataList);
						} else if (method.equals("GetActivityListUI")) {// 获取活动列表
							UIModule.getActivityListUI(gson, je, dataList);
						} else if (method.equals("SignUpActivity")) {// 活动报名
							UIModule.signUpActivity(gson, je, dataList);
						} else if (method.equals("QueryActivityDetailUI")) {// 查询活动详情
							UIModule.queryActivityDetailUI(gson, je, dataList);
						} else if (method.equals("NewBookViewUI")) {// 新建参观预约申请
							UIModule.newBookViewUI(gson, je, dataList);
						} else if (method.equals("GetRegisteredSpaceList")) { // 场地管理-场地注册管理-获取注册场地列表
							SystemManageModule.getRegisteredSpaceList(gson, je,
									dataList);
						} else if (method.equals("QueryRegisteredSpaceDetail")) {// 场地管理-场地注册管理-查询注册场地信息
							SystemManageModule.queryRegisteredSpaceDetail(gson,
									je, dataList);
						} else if (method.equals("AddNewRegisteredSpace")) { // 场地管理-场地注册管理-注册新场地
							SystemManageModule.addNewRegisteredSpace(gson, je,
									dataList);
						} else if (method.equals("UpdateRegisteredSpaceInfo")) { // 场地管理-场地注册管理-更新场地信息
							SystemManageModule.updateRegisteredSpaceInfo(gson,
									je, dataList);
						} else if (method.equals("DelRegisteredSpace")) { // 场地管理-场地注册管理-删除场地
							SystemManageModule.delRegisteredSpace(gson, je,
									dataList);
						} else if (method.equals("GetSubAreaList")) { // 场地管理-内部区域管理-获取子区域列表
							SystemManageModule.getSubAreaList(gson, je,
									dataList);
						} else if (method.equals("AddNewArea")) { // 场地管理-内部区域管理-新建区域
							SystemManageModule.addNewArea(gson, je, dataList);
						} else if (method.equals("UpdateAreaInfo")) { // 场地管理-内部区域管理-更新区域信息
							SystemManageModule.updateAreaInfo(gson, je,
									dataList);
						} else if (method.equals("DelArea")) { // 场地管理-内部区域管理-删除区域
							SystemManageModule.delArea(gson, je, dataList);
						} else if (method.equals("QueryAreaDetail")) { // 场地管理-内部区域管理-查询区域详细信息
							SystemManageModule.queryAreaDetail(gson, je,
									dataList);
						} else if (method.equals("AddSMSInterface")) { // 添加短信接口
							SystemManageModule.addSMSInterface(gson, je,
									dataList);
						} else if (method
								.equals("GetCurrentUsingSMSConfiguration")) {// 查询正在使用的短信接口
							SystemManageModule
									.getCurrentUsingSMSConfiguration();
						}else if (method.equals("NewBookStationUI")) {// UI模块管理-新建预订工位
							UIModule.newBookStationUI(gson, je, dataList);
						} else if (method.equals("GetRegisteredSpaceList")) {    // 场地管理-场地注册管理-获取注册场地列表
							SystemManageModule.getRegisteredSpaceList(gson, je, dataList);
						} else if (method.equals("QueryRegisteredSpaceDetail")) {// 场地管理-场地注册管理-查询注册场地信息
							SystemManageModule.queryRegisteredSpaceDetail(gson, je, dataList);
						} else if (method.equals("AddNewRegisteredSpace")) {     // 场地管理-场地注册管理-注册新场地
							SystemManageModule.addNewRegisteredSpace(gson, je, dataList);
						} else if (method.equals("UpdateRegisteredSpaceInfo")) { // 场地管理-场地注册管理-更新场地信息
							SystemManageModule.updateRegisteredSpaceInfo(gson, je, dataList);
						} else if (method.equals("DelRegisteredSpace")) {        // 场地管理-场地注册管理-删除场地
							SystemManageModule.delRegisteredSpace(gson, je, dataList);
						} else if (method.equals("GetSubAreaList")) {            // 场地管理-内部区域管理-获取子区域列表
							SystemManageModule.getSubAreaList(gson, je, dataList);
						} else if (method.equals("AddNewArea")) {                // 场地管理-内部区域管理-新建区域
							SystemManageModule.addNewArea(gson, je, dataList);
						} else if (method.equals("UpdateAreaInfo")) {            // 场地管理-内部区域管理-更新区域信息
							SystemManageModule.updateAreaInfo(gson, je, dataList);
						} else if (method.equals("DelArea")) {                   // 场地管理-内部区域管理-删除区域
							SystemManageModule.delArea(gson, je, dataList);
						} else if (method.equals("QueryAreaDetail")) {           // 场地管理-内部区域管理-查询区域详细信息
							SystemManageModule.queryAreaDetail(gson, je, dataList);
						} else if (method.equals("NewBookStation")) {            // 预订工位管理-新建预定工位
							SystemManageModule.newBookStation(gson, je, dataList);
						} else if (method.equals("DelBookStation")) {            // 预定工位管理-删除预定工位
							SystemManageModule.delBookStation(gson, je, dataList);
						} else if (method.equals("ModifyBookStation")) {         // 预定工位管理-修改预订工位
							SystemManageModule.modifyBookStation(gson, je, dataList);
						} else if (method.equals("QueryBookStation")) {          // 预定工位管理-查询预订工位
							SystemManageModule.queryBookStation(gson, je, dataList);
						} else if (method.equals("GetBookStationList")) {        // 预定工位管理-获取预订工位列表
							SystemManageModule.getBookStationList(gson, je, dataList);
						} 
					}
				} else {
					// 如果不是数组
					Result re = new Result(
							Configuration.messages.get("param_error"));
					dataList.add(re);
				}
			}
		} else {
			Result re = new Result(Configuration.messages.get("ip_limit"));
			dataList.add(re);
		}

		return SUCCESS;
	}

	private void qyyInitailize(Gson gson, JsonElement je, List<Object> dataList2) {
		// TODO Auto-generated method stub

	}

	private void detectInitialState(Gson gson, JsonElement je,
			List<Object> dataList2) {
		// TODO Auto-generated method stub

	}

	public static void standardMessageOutput(String fn, int result,
			List<Object> dataList) {
		StandardOutput so = new StandardOutput();
		so.setFn(fn);
		so.setResult(result);
		dataList.add(so);
	}

	/**
	 * 检测权限
	 * 
	 * @param user
	 * @return
	 */
	public boolean checkAuthority(String loginId) {
		boolean result = true;// 暂时设定为所有权限都通过
		/**
		 * 添加检测权限代码
		 */

		return result;
	}
}
