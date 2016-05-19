package com.youyou.grapepage.buss.impl;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyou.grapepage.buss.IGrapeBuss;

import junit.framework.Assert;

public class TestGrapeBuss {

	@SuppressWarnings("deprecation")
	@Test
	public void testGet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IGrapeBuss buss = (IGrapeBuss) context.getBean("grapeBuss");
		String result = buss.grapeByGet("http://www.jd.com/", null);

		System.out.println(result);
		Boolean iscontainhtmlTag = result.contains("</html>");
		Assert.assertTrue(iscontainhtmlTag);
	}

	@Test
	public void testPost() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
		IGrapeBuss buss = (IGrapeBuss) context.getBean("grapeBuss");
		List<NameValuePair> lstkeyvalue = new LinkedList<NameValuePair>();
		lstkeyvalue.add(new BasicNameValuePair("currentCollectionName", "Acc20160511"));
		lstkeyvalue.add(new BasicNameValuePair("strMonth", "	2016-05"));
		String result = buss.grapeByPost("http://cd.log.517na.com/NewAcc/GetCollectionNamesFromMonth", lstkeyvalue);

		System.out.println(result);
		Boolean iscontainhtmlTag = result.contains("Acc20160104");
		Assert.assertTrue(iscontainhtmlTag);
	}

	@Test
	public void testLogin() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
			IGrapeBuss buss = (IGrapeBuss) context.getBean("grapeBuss");
			List<NameValuePair> lstkeyvalue = new LinkedList<NameValuePair>();
			lstkeyvalue.add(new BasicNameValuePair("txtPsw", "Zy5255996688"));
			lstkeyvalue.add(new BasicNameValuePair("txtUserName", "ziang"));
			lstkeyvalue.add(new BasicNameValuePair("LoginType", "PlatformBusineSys"));
			lstkeyvalue.add(new BasicNameValuePair("btnLogin", "µÇ Â¼"));

			lstkeyvalue.add(new BasicNameValuePair("__VIEWSTATE",
					"euiXBqemqV4ocJis809J2HNGrtAmlj/g3fJ0kuZiS6hNpJ9bBOlVp0x44Y9KWxiQPQAH+qvkY4LQd2YLKR5YxV8W9kGYkvfUVNGAkkxkMEg="));
			lstkeyvalue.add(new BasicNameValuePair("__EVENTVALIDATION",
					"JQF5O5NeluOxiN+2zjFGIZJ1zfV2cFJVuwbsLbWGEHikIDxRxCLTs0IXB7S7+E5kJuJRDyZwM/Rk/gMh9diVNCrNV5AaNOL+uaIUCVAly7XAsjqb0W+9MXo6uSy/mS+/6utTfxsBDCnsnVhYecn+d9x7evZZIq6hYsO5vv7W3xs="));

			CloseableHttpClient httpClient = (CloseableHttpClient) buss
					.login("http://192.168.1.135:9494/Login.aspx", lstkeyvalue);

			if (httpClient != null) {
				HttpGet httpGet = new HttpGet("http://192.168.1.135:9494/UnityParameter/SysParameterList");
				CloseableHttpResponse reponse = httpClient.execute(httpGet);
				HttpEntity entity = reponse.getEntity();
				String value = EntityUtils.toString(entity);
				System.out.println(value);
				try {
					reponse.close();
					httpClient.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// System.out.println(result);
		// Boolean iscontainhtmlTag=result.contains("Acc20160104");
		// Assert.assertTrue(iscontainhtmlTag);
	}

}
