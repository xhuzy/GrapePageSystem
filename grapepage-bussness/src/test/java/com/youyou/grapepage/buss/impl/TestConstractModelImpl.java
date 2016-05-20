package com.youyou.grapepage.buss.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.youyou.grapepage.buss.IConstractModel;
import com.youyou.grapepage.buss.IGetFundInfoLogic;
import com.youyou.grapepage.buss.IGrapeBuss;
import com.youyou.grapepage.model.FundInfo;

public class TestConstractModelImpl {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IGetFundInfoLogic buss = (IGetFundInfoLogic) context.getBean("GetFundInfoLogic");
		FundInfo fund=buss.GetFundInfo("710001");
		
		String fundJson=new Gson().toJson(fund);
		
		System.out.println(fundJson);
	}

}
