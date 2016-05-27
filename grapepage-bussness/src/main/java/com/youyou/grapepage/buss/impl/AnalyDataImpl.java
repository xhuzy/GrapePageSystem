package com.youyou.grapepage.buss.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.youyou.grapepage.buss.IAnalyData;

/**
 * 
 * 从网站抓取的数据中获取需要的数据
 * 
 * @author ziang
 *
 */
@Service("analyDataImpl")
public class AnalyDataImpl implements IAnalyData {

	@Override
	public String analyToJson(String originHtml) {
		String patternStr = "\\{.*\\}";

		Pattern pattern = Pattern.compile(patternStr);

		Matcher matcher = pattern.matcher(originHtml);

		if (matcher.find()) {
			return matcher.group(0);
		}

		return "";

	}

}
