package com.youyou.grapepage.buss;

/**
 * 从获取到的页面中解析需要的数据
 * 
 * @author ziang
 *
 */
public interface IAnalyData {

	/**
	 * 将元数据解析为Json字符串
	 * 
	 * @param originHtml
	 * @return
	 */
	String AnalyToJson(String originHtml);
}
