package service;

import java.util.Map;

import po.Item;

public interface ItemDao {

	public boolean upload(Item i);
	
	public boolean down(Item i);
	
	/**
	 *  @param param key为要修改的属性的名字,value为用于查询的值
	 */
	public void change(Map<String, Object> p);
}
