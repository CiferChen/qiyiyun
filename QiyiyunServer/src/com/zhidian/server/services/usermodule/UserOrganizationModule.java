package com.zhidian.server.services.usermodule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zhidian.server.configuration.Configuration;
import com.zhidian.server.dao.AccountDAO;
import com.zhidian.server.dao.AccountRecordDAO;
import com.zhidian.server.dao.ActivityDAO;
import com.zhidian.server.dao.ActivityRegisterRecordDAO;
import com.zhidian.server.dao.CertificationDAO;
import com.zhidian.server.dao.DepartmentDAO;
import com.zhidian.server.dao.MemberRelRecordDAO;
import com.zhidian.server.dao.OrganCertificationRelDAO;
import com.zhidian.server.dao.OrganizationDAO;
import com.zhidian.server.dao.OrganizationTypeDAO;
import com.zhidian.server.dao.PersonCertificationRelDAO;
import com.zhidian.server.dao.PersonDAO;
import com.zhidian.server.dao.PersonOrganizationRelDAO;
import com.zhidian.server.dao.PersonRoleRelDAO;
import com.zhidian.server.dao.RightDAO;
import com.zhidian.server.dao.RoleDAO;
import com.zhidian.server.dao.RoleRightRelDAO;
import com.zhidian.server.dao.UserOrganizationRelDAO;
import com.zhidian.server.dao.VisitorDAO;
import com.zhidian.server.model.Account;
import com.zhidian.server.model.AccountRecord;
import com.zhidian.server.model.Activity;
import com.zhidian.server.model.ActivityRegisterRecord;
import com.zhidian.server.model.Certification;
import com.zhidian.server.model.Department;
import com.zhidian.server.model.MemberRelRecord;
import com.zhidian.server.model.OrganCertificationRel;
import com.zhidian.server.model.Organization;
import com.zhidian.server.model.OrganizationType;
import com.zhidian.server.model.Person;
import com.zhidian.server.model.PersonCertificationRel;
import com.zhidian.server.model.PersonOrganizationRel;
import com.zhidian.server.model.PersonRoleRel;
import com.zhidian.server.model.Right;
import com.zhidian.server.model.Role;
import com.zhidian.server.model.RoleRightRel;
import com.zhidian.server.model.UserOrganizationRel;
import com.zhidian.server.model.Visitor;
import com.zhidian.server.model.input.AccountInput;
import com.zhidian.server.model.input.ActivityInput;
import com.zhidian.server.model.input.ApplyMemberRoleInput;
import com.zhidian.server.model.input.ApplyOrganRoleRightInput;
import com.zhidian.server.model.input.CertificationInput;
import com.zhidian.server.model.input.DelOrganRoleInput;
import com.zhidian.server.model.input.DepartmentInput;
import com.zhidian.server.model.input.GetOrganRoleListInput;
import com.zhidian.server.model.input.GetUserOrganListByTypeInput;
import com.zhidian.server.model.input.MemberRelRecordInput;
import com.zhidian.server.model.input.NewOrganRoleInput;
import com.zhidian.server.model.input.OrganCertificationInput;
import com.zhidian.server.model.input.StandardInputWithLoginId;
import com.zhidian.server.model.input.UserOrganInput;
import com.zhidian.server.model.input.VisitorInput;
import com.zhidian.server.model.output.GetActivityListOutput;
import com.zhidian.server.model.output.GetActivityRegisterListOutput;
import com.zhidian.server.model.output.GetCertificationListOutput;
import com.zhidian.server.model.output.GetMemberListOutput;
import com.zhidian.server.model.output.GetOrganAccountRecordListOutput;
import com.zhidian.server.model.output.GetOrganRightListOutput;
import com.zhidian.server.model.output.GetOrganRoleListOutput;
import com.zhidian.server.model.output.GetUserApplyToOrganOutput;
import com.zhidian.server.model.output.GetUserOrganInfoOutput;
import com.zhidian.server.model.output.GetUserOrganListByTypeOutput;
import com.zhidian.server.model.output.GetVisitorList;
import com.zhidian.server.model.output.QueryActivityOutput;
import com.zhidian.server.model.output.QueryOrganAccountOutput;
import com.zhidian.server.model.output.QueryOrganCertificationDetailOutput;
import com.zhidian.server.model.output.QuerySubDepartmentListOutput;
import com.zhidian.server.model.output.QueryVisitorOutput;
import com.zhidian.server.services.QiyiyunService;

/**
 * 会员组织模块
 * @author zb
 *
 */
public class UserOrganizationModule {
	public static Logger log = Logger.getLogger(UserOrganizationModule.class);
	
	
	
	/**
	 * 获取认证列表
	 * @param gson
	 * @param je		input 	[certificationObject:0-个人,1-组织]
	 * 					deal
	 * 					output	List[certificationId,certificationTypeId,relationId:OrganId/PersonId,certificationName,certificationNumber,
	 * 								certificationImg,certificationStatus]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings({ "unchecked" })
	public static void getCertificationList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getCertificationList");
		CertificationInput getCertificationListInput = gson.fromJson(je, CertificationInput.class);
		GetCertificationListOutput getCertificationListOutput = new GetCertificationListOutput();
		
		String loginId = getCertificationListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		String personId = Configuration.getPersonIdByUserId(userId);
		if (userId != null && !userId.equals("")) {
			switch (getCertificationListInput.getInput().getCertificationObject()) {
			case 0:
				//getRels
				PersonCertificationRelDAO personCertificationRelDAO = new PersonCertificationRelDAO();
				List<PersonCertificationRel> personCertificationRels = personCertificationRelDAO.findByPersonId(personId);
				//getIds
				if(personCertificationRels.size()>0){
					StringBuffer strCertificationIds = new StringBuffer();
					strCertificationIds.append("'");
					for (int i = 0; i < personCertificationRels.size(); i++) {
						if (i != personCertificationRels.size()-1) {
							strCertificationIds.append(personCertificationRels.get(i).getCertificationId()
									+ "','");
						}else if (i == personCertificationRels.size()-1){
							strCertificationIds.append(personCertificationRels.get(i).getCertificationId());
						}
					}
					strCertificationIds.append("'");
				
				//getCertifications
				CertificationDAO certificationDAO = new CertificationDAO();
				List<Certification> certifications = certificationDAO.findByIds(strCertificationIds.toString());
				//Output
				Iterator<Certification> it = certifications.iterator();
				List<GetCertificationListOutput.Output> outputs = new ArrayList<GetCertificationListOutput.Output>();
				while(it.hasNext()){
					Certification certification = it.next();
					GetCertificationListOutput.Output output = new GetCertificationListOutput.Output();
					output.setCertificationId(certification.getCertificationId());
					output.setCertificationTypeId(certification.getCertificationTypeId());
					output.setRelationId(personId);
					output.setCertificationName(certification.getCertificationName());
					output.setCertificationNumber(certification.getCertificationNumber());
					output.setCertificationImg(certification.getCertificationImage());
					output.setCertificationStatus(certification.getCertificationStatus().toString());
					outputs.add(output);
					
				}
				
				getCertificationListOutput.setOutput(outputs);
				}
				
				getCertificationListOutput.setFn(getCertificationListInput.getFn());
				getCertificationListOutput.setResult(0);
				
				dataList.add(getCertificationListOutput);
				
				break;
			case 1:
				//getOrganIds
				PersonOrganizationRelDAO personOrganizationRelDAO = new PersonOrganizationRelDAO();
				List<PersonOrganizationRel> personOrganizationRels = personOrganizationRelDAO.findByPersonId(personId);
				StringBuffer sbOrganIds = new StringBuffer();
				if(personOrganizationRels.size()>0){
					sbOrganIds.append("'");
					for (int i = 0; i < personOrganizationRels.size(); i++) {
						if (i != personOrganizationRels.size()-1) {
							sbOrganIds.append(personOrganizationRels.get(i).getOrganId()
									+ "','");
						}else if (i == personOrganizationRels.size()-1){
							sbOrganIds.append(personOrganizationRels.get(i).getOrganId());
						}
					}
					sbOrganIds.append("'");
					
				
				//getCertiIds
					//getOrganCertiRels
					OrganCertificationRelDAO organCertificationRelDAO = new OrganCertificationRelDAO();
					List<OrganCertificationRel> organCertificationRels = organCertificationRelDAO.findByOrganIds(sbOrganIds.toString());
					//IteratorRelsGetCertiIdsAndPutIntoHashMap
					HashMap<String, String> hmOrganCertificationRel = new HashMap<String, String>();
					StringBuffer sbCertificationIds = new StringBuffer();
					if(organCertificationRels.size()>0){
						sbCertificationIds.append("'");
						for (int i = 0; i < organCertificationRels.size(); i++) {
							if (i != organCertificationRels.size()-1) {
								sbCertificationIds.append(organCertificationRels.get(i).getCertificationId()
										+ "','");
							}else if (i == organCertificationRels.size()-1){
								sbCertificationIds.append(organCertificationRels.get(i).getCertificationId());
							}
							hmOrganCertificationRel.put(organCertificationRels.get(i).getCertificationId(), organCertificationRels.get(i).getOrganId());
						}
						sbCertificationIds.append("'");
				
				
				//getCertis
						CertificationDAO certificationDAO = new CertificationDAO();
						List<Certification> certifications = certificationDAO.findByIds(sbCertificationIds.toString());
						List<GetCertificationListOutput.Output> outputs = new ArrayList<GetCertificationListOutput.Output>();
						Iterator<Certification> it = certifications.iterator();
						while (it.hasNext()) {
							//List[certificationId,certificationTypeId,relationId:OrganId/PersonId,certificationName,certificationNumber,
								// * 								certificationImg,certificationStatus]
							GetCertificationListOutput.Output output = new GetCertificationListOutput.Output();
							Certification certification = it.next();
							output.setCertificationId(certification.getCertificationId());
							output.setCertificationTypeId(certification.getCertificationTypeId());
							output.setRelationId(hmOrganCertificationRel.get(certification.getCertificationId()));
							output.setCertificationName(certification.getCertificationName());
							output.setCertificationNumber(certification.getCertificationNumber());
							output.setCertificationImg(certification.getCertificationNumber());
							output.setCertificationStatus(certification.getCertificationStatus()+"");
							outputs.add(output);
							
						}
						
						getCertificationListOutput.setOutput(outputs);
				//Output
					}
				}
				getCertificationListOutput.setFn(getCertificationListInput.getFn());
				getCertificationListOutput.setResult(0);
				dataList.add(getCertificationListOutput);
				break;
			default:
				break;
			}
			
				
		}else{
			QiyiyunService.standardMessageOutput(getCertificationListInput.getFn(), 2,dataList);
		}
	}
	
	
	/**
	 * 组织信息管理-组织基本信息管理-分类获取组织列表
	 * @param gson
	 * @param je input  [getOrganType:0-创建者,1-非创建者]
	 * 	 		 output List[organId,getOrganType,organName,role:List[roleId,roleName]]
	 * 			 result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getUserOrganListByType(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getUserOrganListByType");
		GetUserOrganListByTypeInput getUserOrganListByTypeInput = gson.fromJson(je, GetUserOrganListByTypeInput.class);
		GetUserOrganListByTypeOutput getUserOrganListByTypeOutput = new GetUserOrganListByTypeOutput();
		String loginId = getUserOrganListByTypeInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			
//			//getPersonIdbyuserId
//			UserPersonRelDAO userPersonRelDAO = new UserPersonRelDAO();
//			List<UserPersonRel> userPersonRels = userPersonRelDAO.findByUserId(userId);
//			String personId = "";
//			if(userPersonRels!=null){
//				if(userPersonRels.size()==1){
//					personId = userPersonRels.get(0).getPersonId();
//				}else{
//					log.error("more than 1 persinId finded");
//				}
//			}else{
//				log.error("can not find personId");
//			}
			String personId = Configuration.getPersonIdByUserId(userId);
			log.info("personId:"+personId);
			//getPersonOrganRels
			PersonOrganizationRelDAO personOrganizationRelDAO = new PersonOrganizationRelDAO();
			List<PersonOrganizationRel> personOrganizationRels = null ;
			if(personId != null){
				personOrganizationRels = personOrganizationRelDAO.findByPersonId(personId);
			}
			
			//getOrganIdString
			StringBuffer strOrganId = new StringBuffer();
			if(personOrganizationRels.size()>0){
				strOrganId.append("'");
				for (int i = 0; i < personOrganizationRels.size(); i++) {
					if (i != personOrganizationRels.size()-1) {
						strOrganId.append(personOrganizationRels.get(i).getOrganId()
								+ "','");
					}else if (i == personOrganizationRels.size()-1){
						strOrganId.append(personOrganizationRels.get(i).getOrganId());
					}
				}
				strOrganId.append("'");
			}
			
			log.info("sb:"+strOrganId);
			//getOrganList
			OrganizationDAO organizationDAO = new OrganizationDAO();
			List<Organization> organizations = organizationDAO.findByIds(strOrganId.toString());
			log.info(organizations.size());
			List<GetUserOrganListByTypeOutput.Output> outputs = new ArrayList<GetUserOrganListByTypeOutput.Output>();
			
			switch (getUserOrganListByTypeInput.getInput().getGetOrganType()) {
			case 0:
				log.info("case0");
				Iterator<Organization> it = organizations.iterator();
				while(it.hasNext()){
					Organization organization = it.next();
					GetUserOrganListByTypeOutput.Output output = new GetUserOrganListByTypeOutput.Output();
					
					if(organization.getCreaterId().equals(personId)){
						
						
						output.setOrganId(organization.getOrganId());
						output.setOrganName(organization.getOrganName());
						output.setGetOrganType(0);
						output.setRole(null);
						outputs.add(output);
					}
				}
				getUserOrganListByTypeOutput.setFn(getUserOrganListByTypeInput.getFn());
				getUserOrganListByTypeOutput.setOutput(outputs);
				getUserOrganListByTypeOutput.setResult(0);
				dataList.add(getUserOrganListByTypeOutput);
				break;
			case 1:
				log.info("case1");
				Iterator<Organization> it2 = organizations.iterator();
				while(it2.hasNext()){
					Organization organization = it2.next();
					GetUserOrganListByTypeOutput.Output output = new GetUserOrganListByTypeOutput.Output();
					DepartmentDAO departmentDAO = new DepartmentDAO();
					if(!organization.getCreaterId().equals(personId)){
						PersonRoleRelDAO personRoleRelDAO = new PersonRoleRelDAO();
						RoleDAO roleDAO = new RoleDAO();
						List<PersonRoleRel> personRoleRels = personRoleRelDAO.findByPersonId(personId);
						StringBuffer strRoleId = new StringBuffer();
						if(personRoleRels.size()>0){
							strRoleId.append("'");
							for (int i = 0; i < personRoleRels.size(); i++) {
								if (i != personRoleRels.size()-1) {
									strRoleId.append(personRoleRels.get(i).getRoleId()
											+ "','");
								}else if (i == personRoleRels.size()-1){
									strRoleId.append(personRoleRels.get(i).getRoleId());
								}
							}
							strRoleId.append("'");
						}
						List<Role> roles = roleDAO.findByIds(strRoleId.toString());
						List<GetUserOrganListByTypeOutput.Output.Role> roleOutputs = new ArrayList<GetUserOrganListByTypeOutput.Output.Role>();
						Iterator<Role> it3 = roles.iterator();
						while(it3.hasNext()){
							Role role = it3.next();
							String roleContactOrganId = departmentDAO.findById(role.getDepartmentId()).getOrganId();
							if(organization.getOrganId().equals(roleContactOrganId)){
								GetUserOrganListByTypeOutput.Output.Role roleOutput = new GetUserOrganListByTypeOutput.Output.Role();
								roleOutput.setRoleId(role.getRoleId());
								roleOutput.setRoleName(role.getRoleName());
								roleOutputs.add(roleOutput);
							}
						}
						
						output.setOrganId(organization.getOrganId());
						output.setOrganName(organization.getOrganName());
						output.setGetOrganType(0);
						output.setRole(roleOutputs);
						outputs.add(output);
					}
				}
				getUserOrganListByTypeOutput.setFn(getUserOrganListByTypeInput.getFn());
				getUserOrganListByTypeOutput.setOutput(outputs);
				getUserOrganListByTypeOutput.setResult(0);
				dataList.add(getUserOrganListByTypeOutput);
				break;
			default:
				break;
			}
			
			
			
		}else{
			QiyiyunService.standardMessageOutput(getUserOrganListByTypeInput.getFn(), 2,dataList);
		}
		
	}
	
	/**
	 * 组织信息管理-组织基本信息管理-新建组织
	 * @param gson
	 * @param je input  [organName,organDescription,organAddress,organTypeId,contactName,contactPhone,contactEmail]
	 * 			 deal   [1新建组织,2添加person_organ_rel,3添加user_organ_rel]
	 * 			 output
	 *   		 result
	 * @param dataList
	 */
	public static void newUserOrgan(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->newUserOrgan");
		UserOrganInput newUserOrganInput = gson.fromJson(je, UserOrganInput.class);
		
		String loginId = newUserOrganInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			String personId = Configuration.getPersonIdByUserId(userId);
			//deal1
			OrganizationDAO organizationDAO = new OrganizationDAO();
			Organization organization = new Organization();
			organization.setOrganName(newUserOrganInput.getInput().getOrganName());
			organization.setCreateTime(Calendar.getInstance().getTimeInMillis()+"");
			organization.setCreaterId(personId);
			organization.setOrganDescription(newUserOrganInput.getInput().getOrganDescription());
			organization.setOrganAddress(newUserOrganInput.getInput().getOrganAddress());
			organization.setOrganTypeId(newUserOrganInput.getInput().getOrganTypeId());
			organization.setContactName(newUserOrganInput.getInput().getContactName());
			organization.setContactPhone(newUserOrganInput.getInput().getContactPhone());
			organization.setContactEmail(newUserOrganInput.getInput().getContactEmail());
			
			organizationDAO.save(organization);
			String thisOrganId = organization.getOrganId();
			//deal2
			PersonOrganizationRelDAO personOrganizationRelDAO = new PersonOrganizationRelDAO();
			PersonOrganizationRel personOrganizationRel = new PersonOrganizationRel();
			personOrganizationRel.setPersonId(personId);
			personOrganizationRel.setOrganId(thisOrganId);
			personOrganizationRelDAO.save(personOrganizationRel);
			//deal3
			UserOrganizationRelDAO userOrganizationRelDAO = new UserOrganizationRelDAO();
			UserOrganizationRel userOrganizationRel = new UserOrganizationRel();
			userOrganizationRel.setUserId(userId);
			userOrganizationRel.setOrganId(thisOrganId);
			userOrganizationRelDAO.save(userOrganizationRel);
			
			QiyiyunService.standardMessageOutput(newUserOrganInput.getFn(), 0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(newUserOrganInput.getFn(), 2,dataList);
		}
		
	}
	
	/**
	 * 组织信息管理-组织基本信息管理-查询组织信息
	 * @param gson
	 * @param je	input	[organId]
	 * 				deal
	 * 				output	[organId,organName,creatTime,createrId,createrName,organDesc,organAddreass,
	 * 						organTypeId,organTypeName,contactName,contactPhone,contactEmail]
	 * 				result
	 * @param dataList
	 */
	public static void getUserOrganInfo(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getUserOrganInfo");
		UserOrganInput getUserOrganInfoInput = gson.fromJson(je, UserOrganInput.class);
		GetUserOrganInfoOutput getUserOrganInfoOutput = new GetUserOrganInfoOutput();
		
		String loginId = getUserOrganInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			OrganizationDAO organizationDAO = new OrganizationDAO();
			Organization organization = organizationDAO.findById(getUserOrganInfoInput.getInput().getOrganId());
			
			GetUserOrganInfoOutput.Output output = new GetUserOrganInfoOutput.Output(); 
			output.setOrganId(organization.getOrganId());
			output.setOrganName(organization.getOrganName());
			output.setCreatTime(organization.getCreateTime());
			output.setCreaterId(organization.getCreaterId());
			PersonDAO personDAO = new PersonDAO();
			Person person = personDAO.findById(organization.getCreaterId());
			output.setCreaterName(person.getPersonName());
			output.setOrganDesc(organization.getOrganDescription());
			output.setOrganAddreass(organization.getOrganAddress());
			output.setOrganTypeId(organization.getOrganTypeId());
			OrganizationTypeDAO organTypeDAO = new OrganizationTypeDAO();
			OrganizationType organType = organTypeDAO.findById(organization.getOrganTypeId());
			output.setOrganTypeName(organType.getOrganTypeName());
			output.setContactName(organization.getContactName());
			output.setContactPhone(organization.getContactPhone());
			output.setContactEmail(organization.getContactEmail());
			
			getUserOrganInfoOutput.setFn(getUserOrganInfoInput.getFn());
			getUserOrganInfoOutput.setOutput(output);
			getUserOrganInfoOutput.setResult(0);
			
			dataList.add(getUserOrganInfoOutput);
			
			
		}else{
			QiyiyunService.standardMessageOutput(getUserOrganInfoInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-组织基本信息管理-更新组织信息
	 * @param gson
	 * @param je		input[organId,organDescription,organAddress,organTypeId,contactName,contactPhone,contactEmail]
	 * 					deal
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void updateUserOrganInfo(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->updateUserOrganInfo");
		UserOrganInput updateUserOrganInfoInput = gson.fromJson(je, UserOrganInput.class);
		
		String loginId = updateUserOrganInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			OrganizationDAO organizationDAO = new OrganizationDAO();
			Organization organization = organizationDAO.findById(updateUserOrganInfoInput.getInput().getOrganId());
			
			organization.setOrganDescription(updateUserOrganInfoInput.getInput().getOrganDescription());
			organization.setOrganAddress(updateUserOrganInfoInput.getInput().getOrganAddress());
			organization.setOrganTypeId(updateUserOrganInfoInput.getInput().getOrganTypeId());
			organization.setContactName(updateUserOrganInfoInput.getInput().getContactName());
			organization.setContactPhone(updateUserOrganInfoInput.getInput().getContactPhone());
			organization.setContactEmail(updateUserOrganInfoInput.getInput().getContactEmail());
			
			organizationDAO.attachDirty(organization);
			
			QiyiyunService.standardMessageOutput(updateUserOrganInfoInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(updateUserOrganInfoInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-组织认证信息管理-查询认证详情
	 * @param gson
	 * @param je		input	[certificationId]
	 * 					deal	
	 * 					output  [certificationId,certificationTypeId,certificationObject,certificationName,certificationNumber,
	 * 							certificationImg,certificationStatus]
	 * 					result
	 * @param dataList
	 */
	public static void queryOrganCertificationDetail(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->queryOrganCertificationDetail");
		OrganCertificationInput queryOrganCertificationDetailInput = gson.fromJson(je, OrganCertificationInput.class);
		QueryOrganCertificationDetailOutput queryOrganCertificationDetailOutput = new QueryOrganCertificationDetailOutput();
		
		String loginId = queryOrganCertificationDetailInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			CertificationDAO certificationDAO = new CertificationDAO();
			Certification certification = certificationDAO.findById(queryOrganCertificationDetailInput.getInput().getCertificationId());
			QueryOrganCertificationDetailOutput.Output output = new QueryOrganCertificationDetailOutput.Output();
			output.setCertificationId(certification.getCertificationId());
			output.setCertificationTypeId(certification.getCertificationTypeId());
			output.setCertificationObject(certification.getCertificationObject());
			output.setCertificationName(certification.getCertificationName());
			output.setCertificationNumber(certification.getCertificationNumber());
			output.setCertificationImg(certification.getCertificationImage());
			output.setCertificationStatus(certification.getCertificationStatus());
			
			queryOrganCertificationDetailOutput.setFn(queryOrganCertificationDetailInput.getFn());
			queryOrganCertificationDetailOutput.setOutput(output);
			queryOrganCertificationDetailOutput.setResult(0);
			
			dataList.add(queryOrganCertificationDetailOutput);
			
			
		}else{
			QiyiyunService.standardMessageOutput(queryOrganCertificationDetailInput.getFn(), 2,dataList);
		}
	}
	
	/**
	 * 组织信息管理-组织认证信息管理-修改认证信息
	 * @param gson
	 * @param je		input	[certificationId,certificationTypeId,certificationName,certificationNumber,certificationImg]
	 * 					deal	
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void modifyOrganCertificationInfo(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->modifyOrganCertificationInfo");
		OrganCertificationInput modifyOrganCertificationInfoInput = gson.fromJson(je, OrganCertificationInput.class);
		
		String loginId = modifyOrganCertificationInfoInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			CertificationDAO certificationDAO = new CertificationDAO();
			Certification certification = certificationDAO.findById(modifyOrganCertificationInfoInput.getInput().getCertificationId());
			certification.setCertificationTypeId(modifyOrganCertificationInfoInput.getInput().getCertificationTypeId());
			certification.setCertificationName(modifyOrganCertificationInfoInput.getInput().getCertificationName());
			certification.setCertificationNumber(modifyOrganCertificationInfoInput.getInput().getCertificationNumber());
			certification.setCertificationImage(modifyOrganCertificationInfoInput.getInput().getCertificationImg());
			certification.setCertificationStatus(0);
			certificationDAO.attachDirty(certification);
			
			QiyiyunService.standardMessageOutput(modifyOrganCertificationInfoInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(modifyOrganCertificationInfoInput.getFn(), 2,dataList);
		}
		
		
	}
	
	/**
	 * 组织信息管理-组织认证信息管理-分类获取组织认证列表
	 * @param gson
	 * @param je		input		[organId,cerificationTypeId]
	 * 					deal
	 * 					output		List[certificationId,certificationTypeId,relationId:organId,certificationName,certificationNumber,
	 * 								certificationImg,certificationStatus]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getOrganCertificationListByType(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getOrganCertificationListByType");
		OrganCertificationInput getOrganCertificationListByTypeInput = gson.fromJson(je, OrganCertificationInput.class);
		GetCertificationListOutput getOrganCertificationListByTypeOutput = new GetCertificationListOutput();
		
		String loginId = getOrganCertificationListByTypeInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//getOrganCetificationRels
			OrganCertificationRelDAO organCertificationRelDAO = new OrganCertificationRelDAO();
			List<OrganCertificationRel> organCertificationRels = organCertificationRelDAO.findByOrganId(getOrganCertificationListByTypeInput.getInput().getOrganId()) ;
			//getOrganIdString
			StringBuffer strCertificationIds = new StringBuffer();
			if(organCertificationRels.size()>0){
				strCertificationIds.append("'");
				for (int i = 0; i < organCertificationRels.size(); i++) {
					if (i != organCertificationRels.size()-1) {
						strCertificationIds.append(organCertificationRels.get(i).getCertificationId()
								+ "','");
					}else if (i == organCertificationRels.size()-1){
						strCertificationIds.append(organCertificationRels.get(i).getCertificationId());
					}
				}
				strCertificationIds.append("'");
			}
			log.info( getOrganCertificationListByTypeInput.getInput().getCertificationTypeId());
			CertificationDAO certificationDAO = new CertificationDAO();
			List<Certification> certifications  = certificationDAO.findByCertificationTypeInIds(strCertificationIds.toString(), getOrganCertificationListByTypeInput.getInput().getCertificationTypeId());
			log.info("certifications.size:"+certifications.size());
			Iterator<Certification> it = certifications.iterator();
			List<GetCertificationListOutput.Output> outputs = new ArrayList<GetCertificationListOutput.Output>();
			while(it.hasNext()){
				Certification certification = it.next();
				GetCertificationListOutput.Output output = new GetCertificationListOutput.Output();
				output.setCertificationId(certification.getCertificationId());
				output.setCertificationTypeId(certification.getCertificationTypeId());
				output.setRelationId(getOrganCertificationListByTypeInput.getInput().getOrganId());
				output.setCertificationName(certification.getCertificationName());
				output.setCertificationNumber(certification.getCertificationNumber());
				output.setCertificationImg(certification.getCertificationImage());
				output.setCertificationStatus(certification.getCertificationStatus().toString());
				outputs.add(output);
				
			}
			
			getOrganCertificationListByTypeOutput.setFn(getOrganCertificationListByTypeInput.getFn());
			getOrganCertificationListByTypeOutput.setOutput(outputs);
			getOrganCertificationListByTypeOutput.setResult(0);
			
			dataList.add(getOrganCertificationListByTypeOutput);
			
			
			
		}else{
			QiyiyunService.standardMessageOutput(getOrganCertificationListByTypeInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-组织认证信息管理-申请真实性校验
	 * @param gson
	 * @param je		input	[organId,certificationTypeId,certificationName,certificationNumber,certificationImg]
	 * 					deal	[1添加认证2关联组织项和认证项]
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void applicationForRealCertification(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Sercer--->applicationForRealCertification");
		OrganCertificationInput applicationForRealCertificationInput = gson.fromJson(je, OrganCertificationInput.class);
		
		String loginId = applicationForRealCertificationInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//deal1
			CertificationDAO certificationDAO = new CertificationDAO();
			Certification certification = new Certification();
			
			certification.setCertificationTypeId(applicationForRealCertificationInput.getInput().getCertificationTypeId());
			certification.setCertificationObject(1);
			certification.setCertificationTime(Calendar.getInstance().getTimeInMillis()+"");
			certification.setCertificationName(applicationForRealCertificationInput.getInput().getCertificationName());
			certification.setCertificationNumber(applicationForRealCertificationInput.getInput().getCertificationNumber());
			certification.setCertificationImage(applicationForRealCertificationInput.getInput().getCertificationImg());
			certification.setCertificationStatus(0);
			
			certificationDAO.save(certification);
			
			//deal2
			OrganCertificationRelDAO organCertificationRelDAO = new OrganCertificationRelDAO();
			OrganCertificationRel organCertificationRel = new OrganCertificationRel();
			organCertificationRel.setOrganId(applicationForRealCertificationInput.getInput().getOrganId());
			organCertificationRel.setCertificationId(certification.getCertificationId());
			
			organCertificationRelDAO.save(organCertificationRel);
			
			QiyiyunService.standardMessageOutput(applicationForRealCertificationInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(applicationForRealCertificationInput.getFn(), 2,dataList);
		}
		
		
		
	}

	public static void startOrganRecharge(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void cancelOrganRecharge(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void completeOrganRecharge(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryOrganOrderList(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryOrganOrderDetail(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void submitOrganOrder(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void payOrganOrder(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void completeOrganOrder(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void evaluationOrganOrder(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void cancelOrganOrder(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void applicationForOrganBackOrder(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 组织信息管理-组织架构管理-获取子部门列表
	 * @param gson
	 * @param je	input [organId]
	 * 				deal
	 * 				output List[departmentId,departmentName,organId,departmentDesc,departmentLeaderId,
	 * 							departmentCreatorId,departmentCreateTime]
	 * 				result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void querySubDepartmentList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->newDepartment");
		DepartmentInput querySubDepartmentListInput = gson.fromJson(je, DepartmentInput.class);
		QuerySubDepartmentListOutput querySubDepartmentListOutput = new QuerySubDepartmentListOutput();
		String loginId = querySubDepartmentListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			DepartmentDAO departmentDAO = new DepartmentDAO();
			List<Department> departments = departmentDAO.findByOganId(querySubDepartmentListInput.getInput().getOrganId());
			List<QuerySubDepartmentListOutput.Output> outputs = new ArrayList<QuerySubDepartmentListOutput.Output>();
			Iterator<Department> it = departments.iterator();
			while(it.hasNext()){
				Department department = it.next();
				QuerySubDepartmentListOutput.Output output = new QuerySubDepartmentListOutput.Output();
				output.setDepartmentId(department.getDepartmentId());
				output.setDepartmentName(department.getDepartmentName());
				output.setOrganId(department.getOrganId());
				output.setDepartmentDesc(department.getDepartmentDesc());
				output.setDepartmentLeaderId(department.getDepartmentLeaderId());
				output.setDepartmentCreatorId(department.getCreatorId());
				output.setDepartmentCreateTime(department.getCreateTime());
				outputs.add(output);
			}
			querySubDepartmentListOutput.setFn(querySubDepartmentListInput.getFn());
			querySubDepartmentListOutput.setOutput(outputs);
			querySubDepartmentListOutput.setResult(0);
			
			dataList.add(querySubDepartmentListOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(querySubDepartmentListInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-组织架构管理-新建部门
	 * @param gson
	 * @param je	input [departmentName,organId,departmentDesc,departmentLeaderId]
	 * 				deal
	 * 				output 
	 * 				result
	 * @param dataList
	 */
	public static void newDepartment(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->newDepartment");
		DepartmentInput newDepartmentInput = gson.fromJson(je, DepartmentInput.class);
		String loginId = newDepartmentInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			DepartmentDAO departmentDAO = new DepartmentDAO();
			Department department = new Department();
			department.setDepartmentName(newDepartmentInput.getInput().getDepartmentName());
			department.setOrganId(newDepartmentInput.getInput().getOrganId());
			department.setDepartmentDesc(newDepartmentInput.getInput().getDepartmentDesc());
			department.setCreatorId(Configuration.getPersonIdByUserId(userId));
			department.setDepartmentLeaderId(newDepartmentInput.getInput().getDepartmentLeaderId());
			department.setCreateTime(Calendar.getInstance().getTimeInMillis()+"");
			department.setDepartmentIsDelete(0);
			
			departmentDAO.save(department);
			
			
			QiyiyunService.standardMessageOutput(newDepartmentInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(newDepartmentInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-组织架构管理-更新部门信息
	 * @param gson
	 * @param je	input [departmentId,departmentName,organId,departmentDesc,departmentLeaderId]
	 * 				deal
	 * 				output
	 * 				result
	 * @param dataList
	 */
	public static void changeDepartmentName(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->changeDepartmentName");
		DepartmentInput changeDepartmentNameInput = gson.fromJson(je, DepartmentInput.class);
		String loginId = changeDepartmentNameInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			DepartmentDAO departmentDAO = new DepartmentDAO();
			Department department = departmentDAO.findById(changeDepartmentNameInput.getInput().getDepartmentId());
			department.setDepartmentName(changeDepartmentNameInput.getInput().getDepartmentName());
			department.setOrganId(changeDepartmentNameInput.getInput().getOrganId());
			department.setDepartmentDesc(changeDepartmentNameInput.getInput().getDepartmentDesc());
			department.setCreatorId(Configuration.getPersonIdByUserId(userId));
			department.setDepartmentLeaderId(changeDepartmentNameInput.getInput().getDepartmentLeaderId());
			department.setCreateTime(Calendar.getInstance().getTimeInMillis()+"");
			department.setDepartmentIsDelete(0);
			
			departmentDAO.attachDirty(department);
			
			
			QiyiyunService.standardMessageOutput(changeDepartmentNameInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(changeDepartmentNameInput.getFn(), 2,dataList);
		}
		
	}
	
	/**
	 * 组织信息管理-组织架构管理-删除部门
	 * @param gson
	 * @param je	input [departmentId]
	 * 				deal  1:delete department 2delete role(123)
	 * 				output
	 * 				result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void deleteDepartment(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->deleteDepartment");
		DepartmentInput deleteDepartmentInput = gson.fromJson(je, DepartmentInput.class);
		String loginId = deleteDepartmentInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//deal1
			DepartmentDAO departmentDAO = new DepartmentDAO();
			Department department = departmentDAO.findById(deleteDepartmentInput.getInput().getDepartmentId());
			departmentDAO.delete(department);
			
			//deal2
			RoleDAO roleDAO = new RoleDAO();
			List<Role> roles = roleDAO.findByDepartmentId(deleteDepartmentInput.getInput().getDepartmentId());
			Iterator<Role> it = roles.iterator();
			while(it.hasNext()){
				Role role = it.next();
				//deal2-1
				if(role!=null){
					roleDAO.delete(role);
				}
				//deal2-2
				RoleRightRelDAO roleRightRelDAO = new RoleRightRelDAO();
				roleRightRelDAO.deleteByRoleId(role.getRoleId());
				//deal2-3
				PersonRoleRelDAO personRoleRelDAO = new PersonRoleRelDAO();
				personRoleRelDAO.deleteByRoleId(role.getRoleId());
				
				
			}
			
			
			QiyiyunService.standardMessageOutput(deleteDepartmentInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(deleteDepartmentInput.getFn(), 2,dataList);
		}
	}

	
	/**
	 * 组织信息管理-组织成员管理-获取加入申请列表
	 * @param gson
	 * @param je		input	[organId]
	 * 					deal	1:get member_rel_record by organId and record_direction=0(成员申请) and record_status=0(待审核) 
	 * 					output	List[memberRelRecordId,memberId,organId,recordDirection,recordStatus,recordCreateTime]
	 * 					result
	 * @param dataList
	 */
	public static void getUserApplyToOrgan(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getUserApplyToOrgan");
		MemberRelRecordInput getUserApplyToOrganInput = gson.fromJson(je, MemberRelRecordInput.class);
		GetUserApplyToOrganOutput getUserApplyToOrganOutput = new GetUserApplyToOrganOutput();
		String loginId = getUserApplyToOrganInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<GetUserApplyToOrganOutput.Output> outputs = new ArrayList<GetUserApplyToOrganOutput.Output>();
			List<MemberRelRecord> memberRelRecords = new MemberRelRecordDAO().getUserApplyToOrganListByOrganId(getUserApplyToOrganInput.getInput().getOrganId());
			Iterator<MemberRelRecord> it = memberRelRecords.iterator();
			
			while(it.hasNext()){
				MemberRelRecord memberRelRecord = it.next();
				GetUserApplyToOrganOutput.Output output = new GetUserApplyToOrganOutput.Output();
				
				output.setMemberRelRecordId(memberRelRecord.getMemberRelRecordId());
				output.setMemberId(memberRelRecord.getMemberId());
				output.setOrganId(memberRelRecord.getOrganId());
				output.setRecordDirection(memberRelRecord.getRecordDirection());
				output.setRecordStatus(memberRelRecord.getRecordStatus());
				output.setRecordCreateTime(memberRelRecord.getRecordCreateTime());
				
				outputs.add(output);
				
			}
			
			getUserApplyToOrganOutput.setFn(getUserApplyToOrganInput.getFn());
			getUserApplyToOrganOutput.setOutput(outputs);
			getUserApplyToOrganOutput.setResult(0);
			
			dataList.add(getUserApplyToOrganOutput);
		}else{
			QiyiyunService.standardMessageOutput(getUserApplyToOrganInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-组织成员管理-审核加入申请
	 * @param gson
	 * @param je		input	[memberRelRecordId,recordStatus:1-同意 2-拒绝]
	 * 					deal	1:update member_rel_record 2:if(同意){new person_organ_rel and new user_organ_rel}
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void dealUserApplyToOrgan(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->dealUserApplyToOrgan");
		MemberRelRecordInput dealUserApplyToOrganInput = gson.fromJson(je, MemberRelRecordInput.class);
		String loginId = dealUserApplyToOrganInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			MemberRelRecordDAO memberRelRecordDAO = new MemberRelRecordDAO();
			MemberRelRecord memberRelRecord = memberRelRecordDAO.findById(dealUserApplyToOrganInput.getInput().getMemberRelRecordId());
			
			if(memberRelRecord!=null && memberRelRecord.getRecordStatus()== 0){
				if(dealUserApplyToOrganInput.getInput().getRecordStatus()== 1){
					memberRelRecord.setRecordStatus(1);
					new PersonOrganizationRelDAO().save(new PersonOrganizationRel(memberRelRecord.getMemberId(), memberRelRecord.getOrganId()));
					new UserOrganizationRelDAO().save(new UserOrganizationRel(Configuration.getUserIdByPersonId(memberRelRecord.getMemberId()), memberRelRecord.getOrganId()));
				}
				if(dealUserApplyToOrganInput.getInput().getRecordStatus()== 2){
					memberRelRecord.setRecordStatus(2);
				}
				memberRelRecordDAO.attachDirty(memberRelRecord);
			}
			QiyiyunService.standardMessageOutput(dealUserApplyToOrganInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(dealUserApplyToOrganInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-组织成员管理-邀请个人加入
	 * @param gson
	 * @param je		input	[personId,organId]
	 * 					deal	1check non creator and non invite record 2new member_rel_record
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void newUserInvitePeople(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->newUserInvitePeople");
		MemberRelRecordInput newUserInvitePeopleInput = gson.fromJson(je, MemberRelRecordInput.class);
		String loginId = newUserInvitePeopleInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//deal1
			String personId = newUserInvitePeopleInput.getInput().getPersonId();
			String organId = newUserInvitePeopleInput.getInput().getOrganId();
			Organization organ = new OrganizationDAO().findById(organId);
			if(organ!=null && !personId.equals(organ.getCreaterId())){
				MemberRelRecordDAO memberRelRecordDAO = new MemberRelRecordDAO();
				if(!memberRelRecordDAO.checkInviteIsExsit(personId,organId)){
					//deal2
					MemberRelRecord memberRelRecord = new MemberRelRecord();
					memberRelRecord.setMemberId(personId);
					memberRelRecord.setOrganId(newUserInvitePeopleInput.getInput().getOrganId());
					memberRelRecord.setRecordDirection(1);
					memberRelRecord.setRecordStatus(0);
					memberRelRecord.setRecordCreateTime(Calendar.getInstance().getTimeInMillis()+"");
					memberRelRecord.setRecordIsDelete(0);
					
					memberRelRecordDAO.save(memberRelRecord);
					
					QiyiyunService.standardMessageOutput(newUserInvitePeopleInput.getFn(), 0,dataList);
				}else{
					QiyiyunService.standardMessageOutput(newUserInvitePeopleInput.getFn(), 6,dataList);
				}
			}else{
				QiyiyunService.standardMessageOutput(newUserInvitePeopleInput.getFn(), 9,dataList);
			}
		}else{
			QiyiyunService.standardMessageOutput(newUserInvitePeopleInput.getFn(), 2,dataList);
		}
	}

	/**
	 * 组织信息管理-组织成员管理-获取成员列表
	 * @param gson
	 * @param je		input	[organId]
	 * 					deal
	 * 					output	List[personId]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getMemberList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getMemberList");
		MemberRelRecordInput getMemberListInput = gson.fromJson(je, MemberRelRecordInput.class);
		GetMemberListOutput getMemberListOutput= new GetMemberListOutput();
		String loginId = getMemberListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<GetMemberListOutput.Output> outputs = new ArrayList<GetMemberListOutput.Output>();
			List<PersonOrganizationRel> personOrganizationRels = new PersonOrganizationRelDAO().findByOrganId(getMemberListInput.getInput().getOrganId());
			Iterator<PersonOrganizationRel> it = personOrganizationRels.iterator();
			while (it.hasNext()) {
				PersonOrganizationRel personOrganizationRel= it.next();
				GetMemberListOutput.Output output = new GetMemberListOutput.Output();
				
				output.setPersonId(personOrganizationRel.getPersonId());
				
				outputs.add(output);
				
			}
			
			getMemberListOutput.setFn(getMemberListInput.getFn());
			getMemberListOutput.setOutput(outputs);
			getMemberListOutput.setResult(0);
			
			dataList.add(getMemberListOutput);
		}else{
			QiyiyunService.standardMessageOutput(getMemberListInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-组织成员管理-成员角色配置
	 * @param gson
	 * @param je		input	[personId,roleId]
	 * 					deal	1:check person-organ(by department(by role))-rel is exsit 2:apply
	 * 					output
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void applyMemberRole(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->applyMemberRole");
		ApplyMemberRoleInput applyMemberRoleInput = gson.fromJson(je, ApplyMemberRoleInput.class);
		String loginId = applyMemberRoleInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//deal1
			String personId = applyMemberRoleInput.getInput().getPersonId();
			String roleId = applyMemberRoleInput.getInput().getRoleId();
			
			Role role = new RoleDAO().findById(roleId);
			Department department= new DepartmentDAO().findById(role.getDepartmentId());
			String organId = department.getOrganId();
			if(new PersonOrganizationRelDAO().checkIsExsit(personId,organId)){
				//deal2
				new PersonRoleRelDAO().save(new PersonRoleRel(personId, roleId));
				
				QiyiyunService.standardMessageOutput(applyMemberRoleInput.getFn(), 0,dataList);
			}
			
		}else{
			QiyiyunService.standardMessageOutput(applyMemberRoleInput.getFn(), 2,dataList);
		}
	}

	/**
	 * 组织信息管理-组织成员管理-删除成员
	 * @param gson
	 * @param je		input	[personId,organId]
	 * 					deal	1:check non creator2:delete person_organ_rel 3:delete user_organ_rel 
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void delMember(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->delMember");
		MemberRelRecordInput delMemberInput = gson.fromJson(je, MemberRelRecordInput.class);
		String loginId = delMemberInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//deal1
			String personId = delMemberInput.getInput().getPersonId();
			String organId = delMemberInput.getInput().getOrganId();
			Organization organ = new OrganizationDAO().findById(organId);
			if(organ!=null && !personId.equals(organ.getCreaterId())){
				//deal2
				new PersonOrganizationRelDAO().deleteByPersonIdAndOrganId(personId,organId);
				new UserOrganizationRelDAO().deleteByUserIdAndOrganId(Configuration.getUserIdByPersonId(personId),organId);
			
				QiyiyunService.standardMessageOutput(delMemberInput.getFn(), 0,dataList);
			}else{
				QiyiyunService.standardMessageOutput(delMemberInput.getFn(), 9,dataList);
			}
		}else{
			QiyiyunService.standardMessageOutput(delMemberInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-组织角色与权限管理-获取权限列表
	 * @param gson
	 * @param je input
	 * 			 output list[rightId,rightName,rightType,rightDescription]
	 * 			 result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getOrganRightList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getOrganRightList");
		StandardInputWithLoginId getOrganRightListInput = gson.fromJson(je, StandardInputWithLoginId.class);
		GetOrganRightListOutput getOrganRightListOutput = new GetOrganRightListOutput();
		String loginId = getOrganRightListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			RightDAO rightDAO = new RightDAO();
			List<GetOrganRightListOutput.Output> outputs = new ArrayList<GetOrganRightListOutput.Output>();
			List<Right> rights = new ArrayList<Right>();
			rights = rightDAO.findByRightType(0);
			if(rights!=null){
				Iterator<Right> it = rights.iterator();
				while(it.hasNext()){
					Right right = it.next();
					GetOrganRightListOutput.Output output = new GetOrganRightListOutput.Output();
					output.setRightId(right.getRightId());
					output.setRightName(right.getRightName());
					output.setRightType(right.getRightType());
					output.setRightDescription(right.getRightDescription());
					outputs.add(output);
				}
			}
			getOrganRightListOutput.setFn(getOrganRightListInput.getFn());
			getOrganRightListOutput.setOutput(outputs);
			getOrganRightListOutput.setResult(0);
			
			dataList.add(getOrganRightListOutput);
		}else{
			QiyiyunService.standardMessageOutput(getOrganRightListInput.getFn(), 2,dataList);
		}
	}
	
	/**
	 * 组织信息管理-组织角色与权限管理-获取角色列表
	 * @param gson
	 * @param je input  [departmentId]
	 * 			 output [roleId,roleName;roleDesc] 
	 * 			 result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getOrganRoleList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getOrganRoleList");
		GetOrganRoleListInput getOrganRoleListInput = gson.fromJson(je, GetOrganRoleListInput.class);
		GetOrganRoleListOutput getOrganRoleListOutput = new GetOrganRoleListOutput();
		String loginId = getOrganRoleListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			RoleDAO roleDAO = new RoleDAO();
			List<GetOrganRoleListOutput.Output> outputs = new ArrayList<GetOrganRoleListOutput.Output>();
			List<Role> roles = new ArrayList<Role>();
			roles = roleDAO.findByDepartmentId(getOrganRoleListInput.getInput().getDepartmentId());
			if(roles!=null){
				Iterator<Role> it = roles.iterator();
				while(it.hasNext()){
					Role role = it.next();
					GetOrganRoleListOutput.Output output = new GetOrganRoleListOutput.Output();
					output.setRoleId(role.getRoleId());
					output.setRoleName(role.getRoleName());
					output.setRoleDesc(role.getRoleDesc());
					outputs.add(output);
				}
			}
			getOrganRoleListOutput.setFn(getOrganRoleListInput.getFn());
			getOrganRoleListOutput.setOutput(outputs);
			getOrganRoleListOutput.setResult(0);
			
			dataList.add(getOrganRoleListOutput);
		}else{
			QiyiyunService.standardMessageOutput(getOrganRoleListInput.getFn(), 2,dataList);
		}
	}

	/**
	 * 组织信息管理-组织角色与权限管理-新建角色
	 * @param gson
	 * @param je input  [departmentId,roleName,roleDesc]
	 *           output
	 *           result
	 * @param dataList
	 */
	public static void newOrganRole(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->newOrganRole");
		NewOrganRoleInput newOrganRoleInput = gson.fromJson(je, NewOrganRoleInput.class);
		String loginId = newOrganRoleInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			RoleDAO roleDAO = new RoleDAO();
			Role role = new Role();
			role.setRoleName(newOrganRoleInput.getInput().getRoleName());
			role.setDepartmentId(newOrganRoleInput.getInput().getDepartmentId());
			role.setRoleDesc(newOrganRoleInput.getInput().getRoleDesc());
			role.setRoleIsDelete(0);
			
			roleDAO.save(role);
			
			QiyiyunService.standardMessageOutput(newOrganRoleInput.getFn(), 0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(newOrganRoleInput.getFn(), 2,dataList);
		}
		
		
		
	}

	/**
	 * 组织信息管理-组织角色与权限管理-角色权限配置
	 * @param gson
	 * @param je input  [roleId,rightId]
	 * 			 output
	 * 			 result
	 * @param dataList
	 */
	public static void applyOrganRoleRight(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->applyOrganRoleRight");
		ApplyOrganRoleRightInput applyOrganRoleRightInput = gson.fromJson(je, ApplyOrganRoleRightInput.class);
		String loginId = applyOrganRoleRightInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			RoleRightRelDAO roleRightRelDAO = new RoleRightRelDAO();
			RoleRightRel roleRightRel = new RoleRightRel();
			RoleDAO roleDAO = new RoleDAO();
			RightDAO rightDAO = new RightDAO();
			if(roleDAO.findById(applyOrganRoleRightInput.getInput().getRoleId()) != null && rightDAO.findById(applyOrganRoleRightInput.getInput().getRightId()) != null){
				roleRightRel.setRoleId(applyOrganRoleRightInput.getInput().getRoleId());
				roleRightRel.setRightId(applyOrganRoleRightInput.getInput().getRightId());
				roleRightRelDAO.save(roleRightRel);
			}else{
				log.error("param error");
			}
			
			QiyiyunService.standardMessageOutput(applyOrganRoleRightInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(applyOrganRoleRightInput.getFn(), 2,dataList);
		}
		
	}
	
	/**
	 * 组织信息管理-组织角色与权限管理-删除角色
	 * @param gson
	 * @param je input  [roleId]
	 * 			 deal	1:delete role 2:delete role_right_rel 3:delete person_role_rel 
	 * 			 output
	 * 			 result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void deleteOrganRole(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->deleteOrganRole");
		DelOrganRoleInput delOrganRoleInput = gson.fromJson(je, DelOrganRoleInput.class);
		String loginId = delOrganRoleInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			//deal1
			RoleDAO roleDAO = new RoleDAO();
			Role role = roleDAO.findById(delOrganRoleInput.getInput().getRoleId());
			if(role!=null){
				roleDAO.delete(role);
			}
			//deal2
			RoleRightRelDAO roleRightRelDAO = new RoleRightRelDAO();
			roleRightRelDAO.deleteByRoleId(delOrganRoleInput.getInput().getRoleId());
			//deal3
			PersonRoleRelDAO personRoleRelDAO = new PersonRoleRelDAO();
			personRoleRelDAO.deleteByRoleId(delOrganRoleInput.getInput().getRoleId());
			
			
			QiyiyunService.standardMessageOutput(delOrganRoleInput.getFn(), 0,dataList);
			
		}else{
			QiyiyunService.standardMessageOutput(delOrganRoleInput.getFn(), 2,dataList);
		}
		
	}

	
	/**
	 * 组织信息管理-活动管理-取消活动
	 * @param gson
	 * @param je	input	[activityId]
	 * 				deal	activityStatus -->6
	 * 				output
	 * 				result
	 * @param dataList
	 */
	public static void cancelActivity(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->cancelActivity");
		ActivityInput cancelActivityInput = gson.fromJson(je, ActivityInput.class);
		String loginId = cancelActivityInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			ActivityDAO activityDAO = new ActivityDAO();
			Activity activity = activityDAO.findById(cancelActivityInput.getInput().getActivityId());
			activity.setActivityState("6");
			activityDAO.attachDirty(activity);
			
			QiyiyunService.standardMessageOutput(cancelActivityInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(cancelActivityInput.getFn(), 2,dataList);
		}
	}

	/**
	 * 组织信息管理-活动管理-查询活动
	 * @param gson
	 * @param je	input	[activityId]
	 * 				deal
	 * 				output	[activityId,activityTitle,activityPurpose,activityPersonNumber,
	 * 						activityTime,activityState,activityLeaderName,activityLeaderPhone,
	 * 						activityApplicantsEndTime,userId,userPersonId,organId]
	 * 				result
	 * @param dataList
	 */
	public static void queryActivity(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->queryActivity");
		ActivityInput queryActivityInput = gson.fromJson(je, ActivityInput.class);
		QueryActivityOutput queryActivityOutput = new QueryActivityOutput();
		String loginId = queryActivityInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			ActivityDAO activityDAO = new ActivityDAO();
			Activity activity = activityDAO.findById(queryActivityInput.getInput().getActivityId());
			QueryActivityOutput.Output output = new QueryActivityOutput.Output();
			
			output.setActivityId(activity.getActivityId());
			output.setActivityTitle(activity.getActivityTitle());
			output.setActivityPurpose(activity.getActivityPurpose());
			output.setActivityPersonNumber(activity.getActivityPersonNumber());
			output.setActivityTime(activity.getActivityTime());
			output.setActivityState(activity.getActivityState());
			output.setActivityLeaderName(activity.getActivityLeaderName());
			output.setActivityLeaderPhone(activity.getActivityLeaderPhone());
			output.setActivityApplicantsEndTime(activity.getActivityApplicantsEndTime());
			output.setUserId(activity.getUserId());
			output.setUserPersonId(activity.getUserPersonId());
			output.setOrganId(activity.getOrganId());
			
			
			queryActivityOutput.setFn(queryActivityInput.getFn());
			queryActivityOutput.setOutput(output);
			queryActivityOutput.setResult(0);
			
			dataList.add(queryActivityOutput);
			
			
		}else{
			QiyiyunService.standardMessageOutput(queryActivityInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-活动管理-申请新活动
	 * @param gson
	 * @param je	input	[activityTitle,activityPurpose,activityPersonNumber,
	 * 						activityTime,activityLeaderName,activityLeaderPhone,
	 * 						activityApplicantsEndTime,organId]
	 * 				deal
	 * 				output
	 * 				result
	 * @param dataList
	 */
	public static void applicationForNewActivity(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->applicationForNewActivity");
		ActivityInput applicationForNewActivityInput = gson.fromJson(je, ActivityInput.class);
		String loginId = applicationForNewActivityInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			ActivityDAO activityDAO = new ActivityDAO();
			Activity activity = new Activity();
			activity.setActivityTitle(applicationForNewActivityInput.getInput().getActivityTitle());
			activity.setActivityPurpose(applicationForNewActivityInput.getInput().getActivityPurpose());
			activity.setActivityPersonNumber(applicationForNewActivityInput.getInput().getActivityPersonNumber());
			activity.setActivityTime(applicationForNewActivityInput.getInput().getActivityTime());
			activity.setActivityState("0");
			activity.setActivityLeaderName(applicationForNewActivityInput.getInput().getActivityLeaderName());
			activity.setActivityLeaderPhone(applicationForNewActivityInput.getInput().getActivityLeaderPhone());
			activity.setActivityApplicantsEndTime(applicationForNewActivityInput.getInput().getActivityApplicantsEndTime());
			activity.setUserId(userId);
			activity.setUserPersonId(Configuration.getPersonIdByUserId(userId));
			activity.setOrganId(applicationForNewActivityInput.getInput().getOrganId());
			activity.setAcitivtyIsDelete(0);
			
			activityDAO.save(activity);
			
			
			QiyiyunService.standardMessageOutput(applicationForNewActivityInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(applicationForNewActivityInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-活动管理-获取活动报名列表
	 * @param gson
	 * @param je	input	[organId]
	 * 				deal
	 * 				output	List[activityRegisterId,activityRegisterName,activityRegisterPhone,activityOrganId]
	 * 				result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getActivityRegisterList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getActivityRegisterList");
		ActivityInput getActivityRegisterListInput = gson.fromJson(je, ActivityInput.class);
		GetActivityRegisterListOutput getActivityRegisterListOutput = new GetActivityRegisterListOutput();
		String loginId = getActivityRegisterListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<GetActivityRegisterListOutput.Output> outputs = new ArrayList<GetActivityRegisterListOutput.Output>();
			ActivityRegisterRecordDAO activityRegisterRecordDAO = new ActivityRegisterRecordDAO();
			List<ActivityRegisterRecord> activityRegisterRecords = activityRegisterRecordDAO.findByActivityOrganId(getActivityRegisterListInput.getInput().getOrganId());
			Iterator<ActivityRegisterRecord> it = activityRegisterRecords.iterator();
			
			while(it.hasNext()){
				ActivityRegisterRecord activityRegisterRecord = it.next();
				GetActivityRegisterListOutput.Output output = new GetActivityRegisterListOutput.Output();
				
				output.setActivityRegisterId(activityRegisterRecord.getActivityRegisterId());
				output.setActivityRegisterName(activityRegisterRecord.getActivityRegisterName());
				output.setActivityRegisterPhone(activityRegisterRecord.getActivityRegisterPhone());
				output.setActivityOrganId(activityRegisterRecord.getActivityOrganId());
				
				outputs.add(output);
			}
			
			
			getActivityRegisterListOutput.setFn(getActivityRegisterListInput.getFn());
			getActivityRegisterListOutput.setOutput(outputs);
			getActivityRegisterListOutput.setResult(0);
			
			
			dataList.add(getActivityRegisterListOutput);
		}else{
			QiyiyunService.standardMessageOutput(getActivityRegisterListInput.getFn(), 2,dataList);
		}
	}

	
	/**
	 * 组织信息管理-活动管理-获取活动列表
	 * @param gson
	 * @param je	input	[organId]
	 * 				deal
	 * 				output	List[activityId,activityTitle,activityPurpose,activityPersonNumber,
	 * 						activityTime,activityState,activityLeaderName,activityLeaderPhone,
	 * 						activityApplicantsEndTime,userId,userPersonId,organId]
	 * 				result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getActivityList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getActivityList");
		ActivityInput getActivityListInput = gson.fromJson(je, ActivityInput.class);
		GetActivityListOutput getActivityListOutput = new GetActivityListOutput();
		String loginId = getActivityListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<GetActivityListOutput.Output> outputs = new ArrayList<GetActivityListOutput.Output>();
			ActivityDAO activityDAO = new ActivityDAO();
			List<Activity> activities = activityDAO.findByOrganId(getActivityListInput.getInput().getOrganId());
			Iterator<Activity> it = activities.iterator();
			
			while(it.hasNext()){
				Activity activity = it.next();
				GetActivityListOutput.Output output = new GetActivityListOutput.Output();
				
				output.setActivityId(activity.getActivityId());
				output.setActivityTitle(activity.getActivityTitle());
				output.setActivityPurpose(activity.getActivityPurpose());
				output.setActivityPersonNumber(activity.getActivityPersonNumber());
				output.setActivityTime(activity.getActivityTime());
				output.setActivityState(activity.getActivityState());
				output.setActivityLeaderName(activity.getActivityLeaderName());
				output.setActivityLeaderPhone(activity.getActivityLeaderPhone());
				output.setActivityApplicantsEndTime(activity.getActivityApplicantsEndTime());
				output.setUserId(activity.getUserId());
				output.setUserPersonId(activity.getUserPersonId());
				output.setOrganId(activity.getOrganId());
				
				outputs.add(output);
			}
			
			
			
			getActivityListOutput.setFn(getActivityListInput.getFn());
			getActivityListOutput.setOutput(outputs);
			getActivityListOutput.setResult(0);
			
			
			dataList.add(getActivityListOutput);
		}else{
			QiyiyunService.standardMessageOutput(getActivityListInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-访客管理-删除访客
	 * @param gson
	 * @param je	input	[visitorId]
	 * 				deal
	 * 				output
	 * 				result
	 * @param dataList
	 */
	public static void deleteVisitor(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->deleteVisitor");
		VisitorInput delVisitorInput = gson.fromJson(je,VisitorInput.class);
		String loginId = delVisitorInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			VisitorDAO visitorDAO = new VisitorDAO();
			Visitor visitor = visitorDAO.findById(delVisitorInput.getInput().getVisitorId());
			visitorDAO.delete(visitor);
			
			QiyiyunService.standardMessageOutput(delVisitorInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(delVisitorInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-访客管理-新增访客
	 * @param gson
	 * @param je	input	[visitorName,visitorPhone,visitorEmail,visitorStartTime,organId]
	 * 				deal
	 * 				output
	 * 				result
	 * @param dataList
	 */
	public static void addVisitor(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->addVisitor");
		VisitorInput addVisitorInput = gson.fromJson(je,VisitorInput.class);
		String loginId = addVisitorInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			VisitorDAO visitorDAO = new VisitorDAO();
			Visitor visitor = new Visitor();
			visitor.setVisitorName(addVisitorInput.getInput().getVisitorName());
			visitor.setVisitorPhone(addVisitorInput.getInput().getVisitorPhone());
			visitor.setVisitorEmail(addVisitorInput.getInput().getVisitorEmail());
			visitor.setVisitorStartTime(addVisitorInput.getInput().getVisitorStartTime());
			visitor.setOrganId(addVisitorInput.getInput().getOrganId());
			visitor.setUserId(userId);
			visitor.setUserPersonId(Configuration.getPersonIdByUserId(userId));
			visitor.setVisitorIsDelete(0);
			visitorDAO.save(visitor);
			
			QiyiyunService.standardMessageOutput(addVisitorInput.getFn(), 0,dataList);
		}else{
			QiyiyunService.standardMessageOutput(addVisitorInput.getFn(), 2,dataList);
		}
		
		
	}

	/**
	 * 组织信息管理-访客管理-查询访客详情
	 * @param gson
	 * @param je	input	[visitorId]
	 * 				deal
	 * 				output	[visitorId,visitorName,visitorPhone,visitorEmail,visitorStartTime,organId]
	 * 				result
	 * @param dataList
	 */
	public static void queryVisitorDetail(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->queryVisitorDetail");
		VisitorInput queryVisitorInput = gson.fromJson(je,VisitorInput.class);
		QueryVisitorOutput queryVisitorOutput= new QueryVisitorOutput();
		String loginId = queryVisitorInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			QueryVisitorOutput.Output output = new QueryVisitorOutput.Output();
			VisitorDAO visitorDAO = new VisitorDAO();
			Visitor visitor = visitorDAO.findById(queryVisitorInput.getInput().getVisitorId());
			
			if(visitor != null){
				output.setVisitorId(visitor.getVisitorId());
				output.setVisitorName(visitor.getVisitorName());
				output.setVisitorPhone(visitor.getVisitorPhone());
				output.setVisitorEmail(visitor.getVisitorEmail());
				output.setVisitorStartTime(visitor.getVisitorStartTime());
				output.setOrganId(visitor.getOrganId());
			}
			
			queryVisitorOutput.setFn(queryVisitorInput.getFn());
			queryVisitorOutput.setOutput(output);
			queryVisitorOutput.setResult(0);
			dataList.add(queryVisitorOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(queryVisitorInput.getFn(), 2,dataList);
		}
		
	}

	/**
	 * 组织信息管理-访客管理-获取访客列表
	 * @param gson
	 * @param je	input	[organId]
	 * 				deal
	 * 				output 	List[visitorId,visitorName,visitorStartTime,organId]
	 * 				result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getVisitorList(Gson gson, JsonElement je,List<Object>dataList) {
		log.info("---Server--->getVisitorList");
		VisitorInput getVisitorListInput = gson.fromJson(je,VisitorInput.class);
		GetVisitorList getVisitorListOutput = new GetVisitorList();
		String loginId = getVisitorListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			VisitorDAO visitorDAO = new VisitorDAO();
			List<Visitor> visitors = visitorDAO.findByOrganId(getVisitorListInput.getInput().getOrganId());
			List<GetVisitorList.Output> outputs = new ArrayList<GetVisitorList.Output>();
			
			Iterator<Visitor> it = visitors.iterator();
			
			while(it.hasNext()){
				Visitor visitor = it.next();
				GetVisitorList.Output output = new GetVisitorList.Output();
				output.setVisitorId(visitor.getVisitorId());
				output.setVisitorName(visitor.getVisitorName());
				output.setVisitorStartTime(visitor.getVisitorStartTime());
				output.setOrganId(visitor.getOrganId());
				outputs.add(output);
				
			}
			
			getVisitorListOutput.setFn(getVisitorListInput.getFn());
			getVisitorListOutput.setOutput(outputs);
			getVisitorListOutput.setResult(0);
			dataList.add(getVisitorListOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(getVisitorListInput.getFn(), 2,dataList);
		}
	}

	public static void recordMeeting(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void delayMeeting(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void sendMeetingNotification(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void configMeeting(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryMeetingDetail(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getMeetingList(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void stationRenewals(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void configStation(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void applicationForCancelService(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void cancelApplicationForService(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void applicationForService(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getServiceOrderList(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getSettledSpaceList(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 组织信息管理-组织账户信息管理-查询余额
	 * @param gson
	 * @param je		input	[organId]
	 * 					deal
	 * 					output	[accountId,organId,organBalance]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void queryOrganBalance(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->queryOrganBalance");
		AccountInput queryOrganBalanceInput = gson.fromJson(je, AccountInput.class);
		QueryOrganAccountOutput queryOrganBalanceOutput = new QueryOrganAccountOutput();
		String loginId = queryOrganBalanceInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<Account>  accounts = new AccountDAO().findByAccountOwnerId(queryOrganBalanceInput.getInput().getOrganId());
			QueryOrganAccountOutput.Output output = new QueryOrganAccountOutput.Output();
			
			if(accounts!=null && accounts.size()==1){
				
				output.setAccountId(accounts.get(0).getAccountId());
				output.setOrganId(accounts.get(0).getAccountOwnerId());
				output.setOrganBalance(accounts.get(0).getAccountBalance().toString());
				
			}
			
			
			
			queryOrganBalanceOutput.setFn(queryOrganBalanceInput.getFn());
			queryOrganBalanceOutput.setOutput(output);
			queryOrganBalanceOutput.setResult(0);
			
			dataList.add(queryOrganBalanceOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(queryOrganBalanceInput.getFn(), 2,dataList);
		}
	}

	/**
	 * 组织信息管理-组织账户信息管理-查询保障金
	 * @param gson
	 * @param je		input	[organId]
	 * 					deal
	 * 					output	[accountId,organId,organMarginBalance]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void queryOrganMarginBalance(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->queryOrganMarginBalance");
		AccountInput queryOrganMarginBalanceInput = gson.fromJson(je, AccountInput.class);
		QueryOrganAccountOutput queryOrganMarginBalanceOutput = new QueryOrganAccountOutput();
		String loginId = queryOrganMarginBalanceInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<Account>  accounts = new AccountDAO().findByAccountOwnerId(queryOrganMarginBalanceInput.getInput().getOrganId());
			QueryOrganAccountOutput.Output output = new QueryOrganAccountOutput.Output();
			
			if(accounts!=null && accounts.size()==1){
				
				output.setAccountId(accounts.get(0).getAccountId());
				output.setOrganId(accounts.get(0).getAccountOwnerId());
				output.setOrganMarginBalance(accounts.get(0).getAccountMarginBalance().toString());
				
			}
			
			queryOrganMarginBalanceOutput.setFn(queryOrganMarginBalanceInput.getFn());
			queryOrganMarginBalanceOutput.setOutput(output);
			queryOrganMarginBalanceOutput.setResult(0);
			
			dataList.add(queryOrganMarginBalanceOutput);
			
		}else{
			QiyiyunService.standardMessageOutput(queryOrganMarginBalanceInput.getFn(), 2,dataList);
		}
	}

	/**
	 * 组织信息管理-组织账户信息管理-获取收支明细列表
	 * @param gson
	 * @param je		input	[organId]
	 * 					deal
	 * 					output	List[accountRecordId,organId,operatorId,operateTime,operateReason,operateWay,
	 * 							operateCount,operateType]
	 * 					result
	 * @param dataList
	 */
	@SuppressWarnings("unchecked")
	public static void getOrganAccountRecordList(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->getOrganAccountRecordList");
		AccountInput getOrganAccountRecordListInput = gson.fromJson(je, AccountInput.class);
		GetOrganAccountRecordListOutput getOrganAccountRecordListOutput = new GetOrganAccountRecordListOutput();
		
		String loginId = getOrganAccountRecordListInput.getInput().getLoginId();
		Configuration.resetLoginIdTime(loginId);
		String userId = Configuration.getUserIdByLoginId(loginId);
		if (userId != null && !userId.equals("")) {
			List<AccountRecord> accountRecords = new AccountRecordDAO().findByAccountOwnerId(getOrganAccountRecordListInput.getInput().getOrganId());
			List<GetOrganAccountRecordListOutput.Output> outputs = new ArrayList<GetOrganAccountRecordListOutput.Output>();
			
			Iterator<AccountRecord> it = accountRecords.iterator();
			while(it.hasNext()){
				
				AccountRecord accountRecord = it.next();
				GetOrganAccountRecordListOutput.Output output = new GetOrganAccountRecordListOutput.Output();
				output.setAccountRecordId(accountRecord.getAccountRecordId());
				output.setOrganId(accountRecord.getAccountOwnerId());
				output.setOperatorId(accountRecord.getOperatorId());
				output.setOperateTime(accountRecord.getOperateTime());
				output.setOperateReason(accountRecord.getOperateReason());
				output.setOperateWay(accountRecord.getOperateWay().toString());
				output.setOperateCount(accountRecord.getOperateCount().toString());
				output.setOperateType(accountRecord.getOperateType().toString());
				
				outputs.add(output);
			}
			
			
			getOrganAccountRecordListOutput.setFn(getOrganAccountRecordListInput.getFn());
			getOrganAccountRecordListOutput.setOutput(outputs);
			getOrganAccountRecordListOutput.setResult(0);
			
			dataList.add(getOrganAccountRecordListOutput);
		}else{
			QiyiyunService.standardMessageOutput(getOrganAccountRecordListInput.getFn(), 2,dataList);
		}
		
	}

}
