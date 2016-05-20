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
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public String getFundName() {
		return fundName;
	}

	/**
	 * ���û�������
	 * 
	 * @param fundName
	 */
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	/**
	 * ��ȡ�������
	 * 
	 * @return
	 */
	public String getFundCode() {
		return fundCode;
	}

	/**
	 * ���û������
	 * 
	 * @param fundCode
	 */
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	/**
	 * ��ȡ�����ֵ����
	 * 
	 * @return
	 */
	public String getValuationDate() {
		return valuationDate;
	}

	/**
	 * ���û����ֵ����
	 * 
	 * @param valuationDate
	 */
	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	/**
	 * ��ȡ��λ��ֵ
	 * 
	 * @return
	 */
	public double getUnitValuation() {
		return unitValuation;
	}

	/**
	 * ���õ�λ��ֵ
	 * 
	 * @param unitValuation
	 */
	public void setUnitValuation(double unitValuation) {
		this.unitValuation = unitValuation;
	}

	/**
	 * ��ȡ��ǰ��ֵ
	 * 
	 * @return
	 */
	public double getNowValuation() {
		return nowValuation;
	}

	/**
	 * ���õ�ǰ��ֵ
	 * 
	 * @param nowValuation
	 */
	public void setNowValuation(double nowValuation) {
		this.nowValuation = nowValuation;
	}

	/**
	 * ��ȡ����ǰ�Ƿ�
	 * 
	 * @return
	 */
	public double getValuationIncres() {
		return valuationIncres;
	}

	/**
	 * ���û���ǰ�Ƿ�
	 * 
	 * @param valuationIncres
	 */
	public void setValuationIncres(double valuationIncres) {
		this.valuationIncres = valuationIncres;
	}

	/**
	 * ��ȡ��������ֵʱ��
	 * 
	 * @return
	 */
	public String getValuationTime() {
		return valuationTime;
	}

	/**
	 * ���û������¹�ֵʱ��
	 * 
	 * @param valuationTime
	 */
	public void setValuationTime(String valuationTime) {
		this.valuationTime = valuationTime;
	}

}
