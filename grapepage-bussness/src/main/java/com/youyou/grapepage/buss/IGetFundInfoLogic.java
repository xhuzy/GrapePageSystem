package com.youyou.grapepage.buss;

import com.youyou.grapepage.model.FundInfo;

/**
 * ��ȡfundinfo�߼���
 * 
 * @author ziang
 *
 */
public interface IGetFundInfoLogic {
	FundInfo GetFundInfo(String fundCode);
}