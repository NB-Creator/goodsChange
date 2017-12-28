package service;

import java.util.List;
import java.util.Map;

import model.ExcDate;
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
	
	public ExcDate getExcAllDate(String eid);
	
	/**
	 * @param uid_x �����ѯ�Լ��ύ�Ľ�������Ϣ������Ϊuid_a,�����ѯ�Լ��Ǳ����󷽵Ľ�������Ϣ������Ϊuid_b
	 * @param uid �û�id
	 * @return
	 */
	public List<ExcDate> getMyExc(String uid_x,String uid);
}
