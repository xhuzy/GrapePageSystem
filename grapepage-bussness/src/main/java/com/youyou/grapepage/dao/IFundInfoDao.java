package com.youyou.grapepage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.youyou.grapepage.model.DMFundInfo;

/**
 * 基金信息数据库炒作接口
 * 
 * @author zy
 *
 */
public interface IFundInfoDao {

	public int addFundInfo(DMFundInfo fundInfo);

	public List<DMFundInfo> getAllFundInfo(@Param("tableName") String tabeName, @Param("fundCode") String fundCode);

	public List<DMFundInfo> getFundInfoByAddTime(@Param("tableName")String tableName, @Param("fundCode")String fundCode, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}
