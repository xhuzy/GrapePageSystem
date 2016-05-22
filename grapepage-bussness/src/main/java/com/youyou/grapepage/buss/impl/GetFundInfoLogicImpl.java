package com.youyou.grapepage.buss.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youyou.grapepage.buss.IAnalyData;
import com.youyou.grapepage.buss.IConstractModel;
import com.youyou.grapepage.buss.IGetFundInfoLogic;
import com.youyou.grapepage.buss.IGrapeBuss;
import com.youyou.grapepage.dao.IFundInfoDao;
import com.youyou.grapepage.model.FundInfo;

@Service("GetFundInfoLogic")
public class GetFundInfoLogicImpl implements IGetFundInfoLogic {

	@Resource(name = "grapeBuss")
	private IGrapeBuss grapBuss;

	@Resource(name = "analyDataImpl")
	private IAnalyData analyData;

	@Resource(name = "constractModel")
	private IConstractModel constractModelBuss;

	@Resource(name = "fundDao")
	private IFundInfoDao fundDao;

	@Override
	public int GetFundInfo(String fundCode) {

		String requestUrl = "http://fundgz.1234567.com.cn/js/" + fundCode + ".js?rt=1463710125206";

		String webMessage = this.grapBuss.grapeByGet(requestUrl, null);

		String fundJson = this.analyData.AnalyToJson(webMessage);

		FundInfo fund = this.constractModelBuss.GetFundInfo(fundJson);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

		String fundStr = gson.toJson(fund);
		System.out.println(fundStr);

		return this.fundDao.addFundInfo(fund);

	}

}
