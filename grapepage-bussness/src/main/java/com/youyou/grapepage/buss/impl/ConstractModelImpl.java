package com.youyou.grapepage.buss.impl;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youyou.grapepage.buss.IConstractModel;
import com.youyou.grapepage.model.FundInfo;

@Service("constractModel")
public class ConstractModelImpl implements IConstractModel {

	@Override
	public FundInfo GetFundInfo(String jsonStr) {
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			com.youyou.grapepage.vmodel.FundInfo vfundinfo = gson.fromJson(jsonStr,
					com.youyou.grapepage.vmodel.FundInfo.class);

			FundInfo result = new FundInfo();
			SimpleDateFormat simpleFormar = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleFormar2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			result.setFundCode(vfundinfo.getFundcode());
			result.setFundName(vfundinfo.getName());
			result.setNowValuation(vfundinfo.getGsz());
			result.setUnitValuation(vfundinfo.getDwjz());
			result.setValuationDate(simpleFormar.parse(vfundinfo.getJzrq()));
			result.setValuationIncres(vfundinfo.getGszzl());
			result.setValuationTime(simpleFormar2.parse(vfundinfo.getGztime()));

			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
