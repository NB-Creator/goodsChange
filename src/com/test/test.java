package com.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.ExchangeDao;
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

	@Autowired
	ExchangeDao excDao;
	
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
		/*Map<String,String> mm=new HashMap<String ,String>();
		mm.put("username", "123");
		
		System.out.println(userDaoImpl.getUser(mm));*/
		 /* �û�ע����ԣ����Գɹ�
		 * 
		 */ 
		 
		/*User user=new User("123", "dfds", "sdfsda", "dsfs", "dsfds", "sddf");
		logger.info(userDaoImpl.register(user));
		*/
		 
		 /* 
		  * �û���Ϣ�޸Ĳ���
		  */
		 
		/*Map <String,Object> m1=new HashMap<>();
		m1.put("nickname", "�ɶ���");
		m1.put("username", "123");
		userDaoImpl.changeInfo(m1);*/
		
		/**
		 * ������������ԣ��ɹ�
		 */
		/*Exchange exc=new Exchange("101128","123","1234",1003,10023,"2012-11-23","��Ϣ","������");
		excDao.addExc(exc);*/
		
		/**
		 * ��������ѯ���ԣ��ɹ�
		 */
		/*Map<String,Object> m=new HashMap<String,Object>();
		m.put("year",2012);
		m.put("month", 11);
		System.out.println(excDao.selectExc(m));*/

		/**
		 * ������ɾ�����ԣ��ɹ�
		 */
		/*System.out.println(excDao.deleteExc("101128"));*/
		
		
		/**
		 * �������޸Ĳ��ԣ��ɹ�
		 */
		/*
		 * Map<String,String> m1=new HashMap<String,String>();
		 * m1.put("id","1001128"); m1.put("statu", "ͬ�⽻��");
		 * System.out.println(excDao.changeExc(m1));
		 */
		
	}

}
