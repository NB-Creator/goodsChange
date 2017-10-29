package service;

import java.util.Map;

import po.User;

public interface UserDao {

	public boolean login(User u);
	
	public boolean register(User u);
	
	/**
	 *  @param param keyΪҪ�޸ĵ����Ե�����,valueΪ���ڲ�ѯ��ֵ
	 */
	public void changeInfo(Map<String, String> p);
}
