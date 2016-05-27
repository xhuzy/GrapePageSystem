package com.youyou.grapepage.buss.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youyou.grapepage.buss.IAnalyData;
import com.youyou.grapepage.buss.IConstractModel;
import com.youyou.grapepage.buss.IFundInfoOperator;
import com.youyou.grapepage.buss.IGrapeBuss;
import com.youyou.grapepage.dao.IFundInfoDao;
import com.youyou.grapepage.model.DMFundInfo;

@Service("GetFundInfoLogic")
public class FundInfooperatorImpl implements IFundInfoOperator {

	@Resource(name = "grapeBuss")
	private IGrapeBuss grapBuss;

	@Resource(name = "analyDataImpl")
	private IAnalyData analyData;

	@Resource(name = "constractModel")
	private IConstractModel constractModelBuss;

	@Resource(name = "fundDao")
	private IFundInfoDao fundDao;

	@Override
	public DMFundInfo getFundInfo(String fundCode) {

		String requestUrl = "http://fundgz.1234567.com.cn/js/" + fundCode + ".js?rt=1463710125206";

		String webMessage = this.grapBuss.grapeByGet(requestUrl, null);

		String fundJson = this.analyData.analyToJson(webMessage);

		DMFundInfo fund = this.constractModelBuss.getFundInfo(fundJson);

		return fund;
	}

	@Override
	public boolean saveFundInfo(DMFundInfo fundInfo) {
		fundInfo.setTableName("nowfundinfo");
		return this.fundDao.addFundInfo(fundInfo) > 0;
	}

	@Override
	public List<DMFundInfo> getFundInfoByFundCode(String fundCode) {
		String tableName = "nowfundinfo";

		return this.fundDao.getAllFundInfo(tableName, fundCode);
	}

	@Override
	public List<DMFundInfo> getFundInfoByFundCodeAndTime(String fundCode, Date startTime, Date endTime) {
		String tableName = "nowfundinfo";
		
		return this.fundDao.getFundInfoByAddTime(tableName, fundCode, startTime, endTime);
	}

}
