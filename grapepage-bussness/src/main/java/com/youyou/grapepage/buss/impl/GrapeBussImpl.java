package com.youyou.grapepage.buss.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.stream.Stream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.youyou.grapepage.buss.IGrapeBuss;

@Service("grapeBussImpl")
public class GrapeBussImpl implements IGrapeBuss {
	@Override
	public String grapeByUrl(String url, String param) {

		String result = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpGet httppost = new HttpGet("http://www.jd.com");
		// 创建参数队列
		// List<namevaluepair> formparams = new ArrayList<namevaluepair>();
		// formparams.add(new BasicNameValuePair("username", "admin"));
		// formparams.add(new BasicNameValuePair("password", "123456"));
		// UrlEncodedFormEntity uefEntity;
		try {
			// uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			// httppost.setEntity(uefEntity);
			// System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {

					result = EntityUtils.toString(entity, "UTF-8");
					System.out.println("--------------------------------------");
					System.out.println("Response content: " + result);
					System.out.println("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
