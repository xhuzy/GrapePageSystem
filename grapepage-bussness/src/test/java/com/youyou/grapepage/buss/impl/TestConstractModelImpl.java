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

}
