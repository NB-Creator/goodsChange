package service;

import java.util.List;
import java.util.Map;

import po.Exchange;

public interface ExchangeDao {
	/**
	 * 
	 * @param keyΪ��Ѱ��������(�����ڲ�ѯʱ��Ҫ����year��month������ֵ)
	 * @return �����б�
	 */
	public List<Exchange> selectExc(Map<String,String> m);
	
	public String addExc(Exchange exc);
	
	/**
	 * 
	 * @param idΪɾ���Ķ���id
	 * @return
	 */
	public String deleteExc(String id);
	
	/**
	 * 
	 * @param keyΪ����id�ͽ���״̬status
	 * @return
	 */
	public String changeExc(Map<String,String> m);
}
