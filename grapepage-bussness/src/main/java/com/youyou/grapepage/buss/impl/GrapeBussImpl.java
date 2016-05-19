package com.youyou.grapepage.buss.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Stream;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.youyou.grapepage.buss.IGrapeBuss;

@Service("grapeBuss")
public class GrapeBussImpl implements IGrapeBuss {

	/**
	 * request page by method of get
	 * 
	 * @param url
	 *            the address of page
	 * @param param
	 *            the data that we want to send to web
	 * @return the page context
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public String grapeByGet(String url, List<NameValuePair> param) {
		String result = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		StringBuilder builder = new StringBuilder();
		if (param != null && param.size() > 0) {
			//// 构造请求参数
			builder.append("?");
			try {
				for (NameValuePair nvpair : param) {

					builder.append(URLEncoder.encode(nvpair.getName(), "UTF-8"));
					builder.append("=");
					builder.append(URLEncoder.encode(nvpair.getValue(), "UTF-8"));
					builder.append("&");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			builder.setLength(builder.length() - 1);
		}

		builder.insert(0, url);

		// 创建httpGet
		HttpGet httpget = new HttpGet(builder.toString());
		//// httpget.setHeader("Content-Encoding", "gzip");
		try {

			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				HttpEntity entity = response.getEntity();
				//// String
				//// contentType=response.getHeaders("Content-Encoding")[0].toString();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");

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

	/**
	 * request page by method of post
	 * 
	 * @param url
	 *            the address of page
	 * @param param
	 *            the data that we want to send to web
	 * @return the page context
	 */
	@Override
	public String grapeByPost(String url, List<NameValuePair> param) {
		String result = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);

		UrlEncodedFormEntity uefEntity;
		try {
			if (param != null && param.size() > 0) {
				uefEntity = new UrlEncodedFormEntity(param, "UTF-8");
				httppost.setEntity(uefEntity);
			}
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {

					result = EntityUtils.toString(entity, "UTF-8");
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

	/**
	 * 
	 * 登录
	 * 
	 * @param url
	 *            web url
	 * @param param
	 * 
	 *            param
	 * @return cookie info
	 */
	public HttpClient login(String url, List<NameValuePair> param) {
		NameValuePair result = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		CloseableHttpResponse response = null;
		UrlEncodedFormEntity uefEntity;
		try {
			if (param != null && param.size() > 0) {
				uefEntity = new UrlEncodedFormEntity(param, "UTF-8");
				httppost.setEntity(uefEntity);
			}
			response = httpclient.execute(httppost);
			response.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return httpclient;
	}

}
