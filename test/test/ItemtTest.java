package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import po.Item;
import service.ItemDaoImpl;
import service.UserDaoImpl;

public class ItemtTest {
	@Autowired
	private ItemDaoImpl itemDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Test
	public void testUpload() {
		byte a[]="sfdsa".getBytes();
		Item item=new Item("10116","2012-11-23",null,"sss","a","adf","",12,"2001");
		itemDaoImpl.upload(item);
		assertNotNull(item);
	}

	@Ignore
	public void testDown() {
		fail("尚未实现");
	}

	@Test
	public void testChange() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", new Integer(1003));
		m.put("name", "safsad");
		m.put("detail", null);
		m.put("classification", null);
		m.put("expect", null);
		m.put("imag", null);
		m.put("price", null);
		itemDaoImpl.change(m);
	}

	@Test
	public void testFind() {
		Map<String,String> mm=new HashMap<String ,String>();
		mm.put("username", "123");
		
		System.out.println(userDaoImpl.getUser(mm));
	}

	@Ignore
	public void testDeleteImg() {
		fail("尚未实现");
	}

}
