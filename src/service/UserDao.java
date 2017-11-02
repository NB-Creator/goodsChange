package service;

import java.util.Map;

import po.User;

public interface UserDao {

	public String login(User u);
	
	public String register(User u);
	
	/**
	 *  @param param key为要修改的属性的名字,value为用于查询的值
	 */
	public void changeInfo(Map<String, String> p);
	
	public User getUser(Map<String,String>p);
}
