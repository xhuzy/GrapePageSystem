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
	/**
	 * 向数据库中添加数据
	 * 
	 * @param fundInfo
	 * @return
	 */
	int addFundInfo(DMFundInfo fundInfo);

	/**
	 * 获取某天收益最高或者最低的前多少基金
	 * 
	 * @param tableName
	 * @param limit
	 * @param orderType
	 * @return
	 */
	List<DMFundInfo> selectToporlowFundInfo(@Param("tableName") String tableName, @Param("limit") int limit,
			@Param("orderType") String orderType);

	/**
	 * 查询某个基金的信息
	 * 
	 * @param tableName
	 * @param code
	 * @param name
	 * @return
	 */
	List<DMFundInfo> selectSpecifyFundInfo(@Param("tableName") String tableName, @Param("code") String code,
			@Param("name") String name);
}
