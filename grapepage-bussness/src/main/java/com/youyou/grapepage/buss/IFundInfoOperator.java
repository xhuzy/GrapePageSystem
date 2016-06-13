package com.youyou.grapepage.buss;

import java.util.Date;
import java.util.List;

import com.youyou.grapepage.model.DMFundInfo;

/**
 * 获取fundinfo逻辑类
 * 
 * @author ziang
 *
 */
public interface IFundInfoOperator {

	/**
	 * 从网络上抓取基金信息
	 * 
	 * @param fundCode
	 * @return
	 */
	DMFundInfo getFundInfo(String fundCode);

	/**
	 * 保存基金信息
	 * 
	 * @param fundInfo
	 * @return
	 */
	boolean saveFundInfo(DMFundInfo fundInfo);

	/**
	 * 获取某天收益最高和最低的基金信息
	 * 
	 * @param date
	 * @param selectCount
	 * @param orderType
	 * @return
	 */
	List<DMFundInfo> getTopOrLowFundInfo(Date date, int selectCount, int orderType);

	/**
	 * 根据基金名称和基金代码查询基金信息
	 * 
	 * @param date
	 * @param code
	 * @param name
	 * @return
	 */
	List<DMFundInfo> getFundinfoByCodeAndName(Date date, String code, String name);
}
