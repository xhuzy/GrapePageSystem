package com.youyou.grapape.scanexe.logic;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youyou.grapepage.buss.IFundInfoOperator;
import com.youyou.grapepage.model.DMFundInfo;

@Service("eachfunddeallogic")
public class EachFundDealLogic {

	@Resource(name = "GetFundInfoLogic")
	private IFundInfoOperator fundlogic;

	public void dealEachFund(String fundCode) {

		DMFundInfo fundInfo = this.fundlogic.getFundInfo(fundCode);
		boolean resutl = this.fundlogic.saveFundInfo(fundInfo);

		System.out.println("获取并保存基金代码为：" + fundCode + "，的基金");

	}

}
