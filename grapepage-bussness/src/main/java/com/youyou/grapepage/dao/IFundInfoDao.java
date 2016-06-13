package com.youyou.grapepage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.youyou.grapepage.model.DMFundInfo;

/**
 * ������Ϣ���ݿ⳴���ӿ�
 * 
 * @author zy
 *
 */
public interface IFundInfoDao {
	/**
	 * �����ݿ����������
	 * 
	 * @param fundInfo
	 * @return
	 */
	int addFundInfo(DMFundInfo fundInfo);

	/**
	 * ��ȡĳ��������߻�����͵�ǰ���ٻ���
	 * 
	 * @param tableName
	 * @param limit
	 * @param orderType
	 * @return
	 */
	List<DMFundInfo> selectToporlowFundInfo(@Param("tableName") String tableName, @Param("limit") int limit,
			@Param("orderType") String orderType);

	/**
	 * ��ѯĳ���������Ϣ
	 * 
	 * @param tableName
	 * @param code
	 * @param name
	 * @return
	 */
	List<DMFundInfo> selectSpecifyFundInfo(@Param("tableName") String tableName, @Param("code") String code,
			@Param("name") String name);
}
