package com.youyou.grapepage.buss;

/*
 * ҳ��ץȡҵ���߼��ӿ�
 * 
 */
public interface IGrapeBuss {

	/**
	 * ץȡָ��ҳ�����Ϣ
	 * 
	 * @param url
	 *            ҳ���ַ
	 * @return ҳ��html����
	 */
	String grapeByUrl(String url,String param);

}
