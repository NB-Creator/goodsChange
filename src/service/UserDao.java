package service;

import java.util.Map;

import po.User;

public interface UserDao {

	public String login(User u);
	
	public String register(User u);
	
	/**
	 *  @param param keyΪҪ�޸ĵ����Ե�����,valueΪ���ڲ�ѯ��ֵ
	 */
	public void changeInfo(Map<String, String> p);
	
	public User getUser(Map<String,String>p);
}
