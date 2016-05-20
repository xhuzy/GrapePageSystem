package com.youyou.grapepage.buss.impl;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.youyou.grapepage.buss.IConstractModel;
import com.youyou.grapepage.model.FundInfo;

@Service("constractModel")
public class ConstractModelImpl implements IConstractModel {

	@Override
	public FundInfo GetFundInfo(String jsonStr) {
		Gson gson = new Gson();
		com.youyou.grapepage.vmodel.FundInfo vfundinfo = gson.fromJson(jsonStr,
				com.youyou.grapepage.vmodel.FundInfo.class);

		FundInfo result = new FundInfo();

		result.setFundCode(vfundinfo.getFundcode());
		result.setFundName(vfundinfo.getName());
		result.setNowValuation(vfundinfo.getGsz());
		result.setUnitValuation(vfundinfo.getDwjz());
		result.setValuationDate(vfundinfo.getJzrq());
		result.setValuationIncres(vfundinfo.getGszzl());
		result.setValuationTime(vfundinfo.getGztime());

		return result;
	}

}
