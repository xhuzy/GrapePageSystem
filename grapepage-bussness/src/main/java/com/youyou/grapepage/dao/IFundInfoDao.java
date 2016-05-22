package com.youyou.grapepage.dao;

import java.util.Date;
import java.util.List;

import com.youyou.grapepage.model.FundInfo;

/**
 * ������Ϣ���ݿ⳴���ӿ�
 * 
 * @author zy
 *
 */
public interface IFundInfoDao {
	
	public int addFundInfo(FundInfo fundInfo);

	public List<FundInfo> getAllFundInfo();

	public List<FundInfo> getFundInfoByAddTime(Date startTime, Date endTime);
}
