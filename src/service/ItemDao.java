package service;

import java.util.List;
import java.util.Map;

import po.Item;

public interface ItemDao {

	public boolean upload(Item i);
	
	public boolean down(Item i);
	
	/**
	 *  @param param keyΪҪ�޸ĵ����Ե�����,valueΪ���ڲ�ѯ��ֵ
	 */
	public void change(Map<String, String> p);
	
	public List<Item> find(Map<String,String> p);
	
	public boolean deleteImg(String imgPath,int ItemId);
	
	public List<Item> selectFreeItem(Map<String, String> m);
}
