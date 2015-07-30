package com.zhidian.server.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zhidian.server.dao.BookstationDAO;
import com.zhidian.server.model.Bookstation;
import com.zhidian.server.model.input.BookStationInput;

/**
 * UI模块
 * @author zb
 *
 */
public class UIModule {
	public static Logger log = Logger.getLogger(UIModule.class);

	public static void newBookViewUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryActivityDetailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void signUpActivity(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getActivityListUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getMeetingRoomDetailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getMeetiongRoomLIstUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryStationDetailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getStationListUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryAreaDetailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getSubAreaListUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryRegisteredSpaceDetailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getRegisteredSpaceListUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void resetLoginPasswordUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void resetPasswordByPhoneUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void showArticleUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getArticleListByTypeUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void queryArticleDetailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void getArticleTypeListUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	public static void resetPasswordByEmailUI(Gson gson, JsonElement je,List<Object>dataList) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * UI模块管理-UI新建预订工位
	 * @param gson
	 * @param je		input [bookStationName,bookStationPhone,bookStationEmail]
	 * 					deal
	 * 					output
	 * 					result
	 * @param dataList
	 */
	public static void newBookStationUI(Gson gson, JsonElement je,List<Object> dataList) {
		log.info("---Server--->newBookStationUI");
		BookStationInput newBookStationUIInput = gson.fromJson(je, BookStationInput.class);
		
		log.info("name and phone : "+newBookStationUIInput.getInput().getBookStationName()+" " + newBookStationUIInput.getInput().getBookStationPhone());
		BookstationDAO bookstationDAO = new BookstationDAO();
		Bookstation bookstation = new Bookstation();
		bookstation.setBookstationName(newBookStationUIInput.getInput().getBookStationName());
		bookstation.setBookstationPhone(newBookStationUIInput.getInput().getBookStationPhone());
		bookstation.setBookstationEmail(" ");
		
		
		bookstationDAO.save(bookstation);
		
		QiyiyunService.standardMessageOutput(newBookStationUIInput.getFn(), 0, dataList);
		
	}

}
