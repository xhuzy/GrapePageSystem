package com.youyou.grapepage.buss;

import com.youyou.grapepage.model.DMFundInfo;

/**
 * 构造基金信息对象
 * 
 * @author ziang
 *
 */
public interface IConstractModel {

	DMFundInfo getFundInfo(String jsonStr);
}
