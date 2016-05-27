package com.youyou.grapepage.buss;

import java.util.Date;
import java.util.List;

import com.youyou.grapepage.model.DMFundInfo;

/**
 * ªÒ»°fundinfo¬ﬂº≠¿‡
 * 
 * @author ziang
 *
 */
public interface IFundInfoOperator {

	DMFundInfo getFundInfo(String fundCode);

	boolean saveFundInfo(DMFundInfo fundInfo);

	List<DMFundInfo> getFundInfoByFundCode(String fundCode);

	List<DMFundInfo> getFundInfoByFundCodeAndTime(String funcCode, Date startTime, Date endTime);
}
