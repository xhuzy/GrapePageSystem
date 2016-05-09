package com.youyou.grapepage.buss;

/*
 * 页面抓取业务逻辑接口
 * 
 */
public interface IGrapeBuss {

	/**
	 * 抓取指定页面的信息
	 * 
	 * @param url
	 *            页面地址
	 * @return 页面html代码
	 */
	String grapeByUrl(String url,String param);

}
