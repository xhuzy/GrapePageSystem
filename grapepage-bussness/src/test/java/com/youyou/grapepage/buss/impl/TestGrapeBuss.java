package com.youyou.grapepage.buss.impl;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyou.grapepage.buss.IGrapeBuss;

import junit.framework.Assert;

public class TestGrapeBuss {

	@SuppressWarnings("deprecation")
	@Test
	public void testGet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IGrapeBuss buss = (IGrapeBuss) context.getBean("grapeBuss");
		String result=buss.grapeByGet("http://www.jd.com/", null);
		
		System.out.println(result);
		Boolean iscontainhtmlTag=result.contains("</html>");
		Assert.assertTrue(iscontainhtmlTag);
	}
	
	@Test
	public void testPost() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IGrapeBuss buss = (IGrapeBuss) context.getBean("grapeBuss");
		List<NameValuePair> lstkeyvalue=new LinkedList<NameValuePair>();
		lstkeyvalue.add(new BasicNameValuePair("currentCollectionName","Acc20160511"));
		lstkeyvalue.add(new BasicNameValuePair("strMonth","	2016-05"));
		String result=buss.grapeByPost("http://cd.log.517na.com/NewAcc/GetCollectionNamesFromMonth", lstkeyvalue);
		
		System.out.println(result);
		Boolean iscontainhtmlTag=result.contains("Acc20160104");
		Assert.assertTrue(iscontainhtmlTag);
	}


}
