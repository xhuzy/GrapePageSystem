package com.youyou.grapepage.buss.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youyou.grapepage.buss.IConstractModel;
import com.youyou.grapepage.buss.IFundInfoOperator;
import com.youyou.grapepage.buss.IGrapeBuss;
import com.youyou.grapepage.model.DMFundInfo;

import junit.framework.Assert;

public class TestConstractModelImpl {

	@Test
	public void testSaveFundInfo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IFundInfoOperator buss = (IFundInfoOperator) context.getBean("GetFundInfoLogic");
		DMFundInfo fund = buss.getFundInfo("710001");
		boolean result = buss.saveFundInfo(fund);
		
		Assert.assertEquals(true, result);

	}
	
	@Test
	public void testGetFundInfoByCode() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IFundInfoOperator buss = (IFundInfoOperator) context.getBean("GetFundInfoLogic");
		List<DMFundInfo> lstFundInfo=buss.getFundInfoByFundCode("710001");
		boolean result=lstFundInfo.size()>0;
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		
		for(DMFundInfo fundinfo :lstFundInfo){
			System.out.println(gson.toJson(fundinfo));
		}

		Assert.assertEquals(true, result);

	}
	
	@Test
	public void getFundInfoByCodeAndTime() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IFundInfoOperator buss = (IFundInfoOperator) context.getBean("GetFundInfoLogic");
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(2016, 4, 27, 10, 5, 0);
		Date startTime=calendar.getTime();
		Date endTime=new Date();
		List<DMFundInfo> lstFundInfo=buss.getFundInfoByFundCodeAndTime("710001", startTime, endTime);
		boolean result=lstFundInfo.size()>1;
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		
		for(DMFundInfo fundinfo :lstFundInfo){
			System.out.println(gson.toJson(fundinfo));
		}

		Assert.assertEquals(true, result);
	}

}
