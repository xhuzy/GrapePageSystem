package com.youyou.grapepage.model;

import java.util.Calendar;

/**
 * fundInfo
 * 
 * @author ziang
 *
 */
public class FundInfo {
	private String fundName;
	private String fundCode;
	private String valuationDate;
	private double unitValuation;
	private double nowValuation;
	private double valuationIncres;
	private String valuationTime;

	/**
	 * 获取基金名称
	 * 
	 * @return
	 */
	public String getFundName() {
		return fundName;
	}

	/**
	 * 设置基金名称
	 * 
	 * @param fundName
	 */
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	/**
	 * 获取基金代码
	 * 
	 * @return
	 */
	public String getFundCode() {
		return fundCode;
	}

	/**
	 * 设置基金代码
	 * 
	 * @param fundCode
	 */
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	/**
	 * 获取基金估值日期
	 * 
	 * @return
	 */
	public String getValuationDate() {
		return valuationDate;
	}

	/**
	 * 设置基金估值日期
	 * 
	 * @param valuationDate
	 */
	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	/**
	 * 获取单位净值
	 * 
	 * @return
	 */
	public double getUnitValuation() {
		return unitValuation;
	}

	/**
	 * 设置单位净值
	 * 
	 * @param unitValuation
	 */
	public void setUnitValuation(double unitValuation) {
		this.unitValuation = unitValuation;
	}

	/**
	 * 获取当前估值
	 * 
	 * @return
	 */
	public double getNowValuation() {
		return nowValuation;
	}

	/**
	 * 设置当前估值
	 * 
	 * @param nowValuation
	 */
	public void setNowValuation(double nowValuation) {
		this.nowValuation = nowValuation;
	}

	/**
	 * 获取基金当前涨幅
	 * 
	 * @return
	 */
	public double getValuationIncres() {
		return valuationIncres;
	}

	/**
	 * 设置基金当前涨幅
	 * 
	 * @param valuationIncres
	 */
	public void setValuationIncres(double valuationIncres) {
		this.valuationIncres = valuationIncres;
	}

	/**
	 * 获取最近基金估值时间
	 * 
	 * @return
	 */
	public String getValuationTime() {
		return valuationTime;
	}

	/**
	 * 设置基金最新估值时间
	 * 
	 * @param valuationTime
	 */
	public void setValuationTime(String valuationTime) {
		this.valuationTime = valuationTime;
	}

}
