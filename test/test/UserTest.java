package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.test;

import mapper.UserMapper;
import po.User;
import service.UserDao;
import service.UserDaoImpl;

public class UserTest {
	
	private static final Log logger = LogFactory
			.getLog(test.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Test
	public void testLogin() {
		User u;
		Map<String, String> m = new HashMap<String, String>();
		m.put("username","user" );
		m.put("password","123");
		u = userMapper.selcet(m);
		assertNotNull(m);
	}

	@Test
	public void testRegister() {
		User user=new User("123", "dfds", "sdfsda", "dsfs", "dsfds", "sddf");
		logger.info(userDaoImpl.register(user));
		assertNotNull(user);
	}

	@Test
	public void testChangeInfo() {
		User u;
		Map <String,Object> m1=new HashMap<>();
		m1.put("nickname", "³É¶¼´ó");
		m1.put("username", "123");
		userDaoImpl.changeInfo(m1);
	}

	@Test
	public void testGetUser() {
		Map<String,String> m=new HashMap<String ,String>();
		m.put("username", "123");
	 assertEquals("use", userDaoImpl.getUser(m));
	}

}
