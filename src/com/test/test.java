/*package com.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.Item;
import po.User;
import service.ItemDaoImpl;
import service.UserDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/applicationContext.xml",
		"classpath:/config/springConfig.xml" })
public class test {
	@Autowired
	private ItemDaoImpl itemDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Test
	public void Test() {

		
		 * ������Ʒ�ϼܣ����Բ߳ɹ�
		 * 
		 * byte a[]="sfdsa".getBytes(); Item item=new
		 * Item(1003,"2012-11-23","sss","sss",a,"adf","afds",12,2001);
		 * itemDaoImpl.upload(item);
		 

		
		 * 
		 * ������Ʒ�޸ģ����Գɹ�
		 * 
		 * Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", new Integer(1001));
		m.put("name", "safsad");
		m.put("detail", null);
		m.put("classification", null);
		m.put("expect", null);
		m.put("imag", null);
		m.put("price", null);
		itemDaoImpl.change(m);
		
		
		 * �û�ע����ԣ����Գɹ�
		 * 
		 * 
		 
		User user=new User("123", "dfds", "sdfsda", "dsfs", "dsfds", "sddf");
		userDaoImpl.register(user);
		
		 * 
		 * �û���Ϣ�޸Ĳ���
		 
		Map <String,String> m=new HashMap<String,String>();
		m.put("nickname", "�ɶ���С");
		m.put("username", "123");
		userDaoImpl.changeInfo(m);
	}

}
*/