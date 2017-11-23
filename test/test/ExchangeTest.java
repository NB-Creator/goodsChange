package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import po.Exchange;
import service.ExchangeDao;

public class ExchangeTest {

	@Autowired
	ExchangeDao excDao;
	@Test
	public void testSelectExc() {
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("year",2012);
		m.put("month", 11);
		excDao.selectExc(m);
		assertNotNull(m);
	}

	@Test
	public void testAddExc() {
		Exchange exc=new Exchange("101128","123","1234","1003","10023","2012-11-23","信息","待处理");
		excDao.addExc(exc);
		assertNotNull(exc);
	}

	@Test
	public void testDeleteExc() {
		excDao.deleteExc("101128");
	assertNotNull(excDao);
	}

	@Test
	public void testChangeExc() {
		 Map<String,String> m1=new HashMap<String,String>();
		 m1.put("id","1001128");
		 m1.put("statu", "同意交换");
		 System.out.println(excDao.changeExc(m1));
		 assertEquals("同意交换", m1.get("statu"));
	}

}
