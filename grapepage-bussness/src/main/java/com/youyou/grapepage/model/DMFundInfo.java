package com.youyou.grapepage.model;

import java.util.Calendar;
import java.util.Date;

/**
 * fundInfo
 * 
 * @author ziang
 *
 */
public class DMFundInfo {
	private String fundName;
	private String fundCode;
	private Date valuationDate;
	private double unitValuation;
	private double nowValuation;
	private double valuationIncres;
	private Date valuationTime;
	private int id;
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	public Date getValuationDate() {
		return valuationDate;
	}

	/**
	 * ���û����ֵ����
	 * 
	 * @param valuationDate
	 */
	public void setValuationDate(Date valuationDate) {
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
	public Date getValuationTime() {
		return valuationTime;
	}

	/**
	 * ���û������¹�ֵʱ��
	 * 
	 * @param valuationTime
	 */
	public void setValuationTime(Date valuationTime) {
		this.valuationTime = valuationTime;
	}

}
