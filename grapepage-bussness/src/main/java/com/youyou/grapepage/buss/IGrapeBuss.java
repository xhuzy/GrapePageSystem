package com.youyou.grapepage.buss;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.NameValuePair;

/*
 * ҳ��ץȡҵ���߼��ӿ�
 * 
 */
public interface IGrapeBuss {

	/**
	 * request page by method of get
	 * 
	 * @param url   
	 *               the address of page
	 * @param param  
	 *                the data that we want to send to web
	 * @return   
	 *                the page context
	 * @throws UnsupportedEncodingException 
	 */
	String grapeByGet(String url, List<NameValuePair> param);

	/**
	 * request page by method of post
	 * 
	 * @param url   
	 *               the address of page
	 * @param param  
	 *                the data that we want to send to web
	 * @return   
	 *                the page context
	 */
	String grapeByPost(String url, List<NameValuePair> param);

}
