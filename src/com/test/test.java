package com.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private static final Log logger = LogFactory
			.getLog(test.class);
	
	@Autowired
	private ItemDaoImpl itemDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Test
	public void Test() {

		
		 /*������Ʒ�ϼܣ����Բ߳ɹ�
		  */
		/* byte a[]="sfdsa".getBytes(); Item item=new
		 Item(10116,"2012-11-23",null,"sss",a,"adf","afds",12,2001);
		 itemDaoImpl.upload(item);*/
		 

		
		/* 
		 * ������Ʒ�޸ģ����Գɹ�
		 * 
		 */
		/*Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", new Integer(1003));
		m.put("name", "safsad");
		m.put("detail", null);
		m.put("classification", null);
		m.put("expect", null);
		m.put("imag", null);
		m.put("price", null);
		itemDaoImpl.change(m);*/
		
		/*
		 * �û���ѯ����
		 */
		Map<String,String> mm=new HashMap<String ,String>();
		mm.put("username", "123");
		
		System.out.println(userDaoImpl.getUser(mm));
		 /* �û�ע����ԣ����Գɹ�
		 * 
		 */ 
		 
		User user=new User("123", "dfds", "sdfsda", "dsfs", "dsfds", "sddf");
		logger.info(userDaoImpl.register(user));
		
		 
		 /* 
		  * �û���Ϣ�޸Ĳ���
		  */
		 
		Map <String,Object> m1=new HashMap<>();
		m1.put("nickname", "�ɶ���");
		m1.put("username", "123");
		userDaoImpl.changeInfo(m1);
	}

}
