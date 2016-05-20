package com.youyou.grapepage.buss;

import com.youyou.grapepage.model.FundInfo;

/**
 * 构造基金信息对象
 * 
 * @author ziang
 *
 */
public interface IConstractModel {

	FundInfo GetFundInfo(String jsonStr);
}
