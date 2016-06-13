package com.youyou.grapepage.buss;

import java.util.Date;
import java.util.List;

import com.youyou.grapepage.model.DMFundInfo;

/**
 * ��ȡfundinfo�߼���
 * 
 * @author ziang
 *
 */
public interface IFundInfoOperator {

	/**
	 * ��������ץȡ������Ϣ
	 * 
	 * @param fundCode
	 * @return
	 */
	DMFundInfo getFundInfo(String fundCode);

	/**
	 * ���������Ϣ
	 * 
	 * @param fundInfo
	 * @return
	 */
	boolean saveFundInfo(DMFundInfo fundInfo);

	/**
	 * ��ȡĳ��������ߺ���͵Ļ�����Ϣ
	 * 
	 * @param date
	 * @param selectCount
	 * @param orderType
	 * @return
	 */
	List<DMFundInfo> getTopOrLowFundInfo(Date date, int selectCount, int orderType);

	/**
	 * ���ݻ������ƺͻ�������ѯ������Ϣ
	 * 
	 * @param date
	 * @param code
	 * @param name
	 * @return
	 */
	List<DMFundInfo> getFundinfoByCodeAndName(Date date, String code, String name);
}
