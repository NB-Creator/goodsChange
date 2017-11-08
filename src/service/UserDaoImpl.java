package service;

import java.util.HashMap;
import java.util.Map;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.User;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;

	/*
	 * �û���¼������û��Ƿ���ڣ������Ƿ���ȷ����������Ӧ����Ϣ���� Javadoc��
	 * 
	 * @see service.UserDao#login(po.User)
	 */
	@Override
	public String login(User u) {
		// TODO �Զ����ɵķ��������
		Map<String, String> m = new HashMap<String, String>();
		m.put("username", u.getUsername());
		m.put("password", u.getPassword());
		u = userMapper.selcet(m);
		if (u == null)
			return "FALSE";
		else
			return "SUCCESS";
	}

	/*
	 * �û�ע�ᣬ����ǳƣ������Ƿ��ѱ�ʹ��
	 * 
	 * @see service.UserDao#register(po.User)
	 */
	@Override
	public String register(User u) {
		User uT;
		Map<String, String> m = new HashMap<String, String>();
		m.put("username", u.getUsername());
		uT = userMapper.selcet(m);
		if (uT != null)
			return "USERNA EXIST";
		m.put("nickname", u.getNickname());
		uT = userMapper.selcet(m);
		if (uT != null) {
			return "NICKNAME EXIST";
		}
		m.clear();
		m.put("mail", u.getMail());
		uT = userMapper.selcet(m);
		if (uT != null) {
			return "MAIL EXIST";
		}
		
		userMapper.add(u);
		return "SUCCESS";

	}

	/*
	 * �޸��û�����
	 * 
	 * @see service.UserDao#changeInfo(java.util.Map)
	 */
	@Override
	public void changeInfo(Map<String, Object> p) {
		// TODO �Զ����ɵķ������
		userMapper.change(p);
	}

	@Override
	public User getUser(Map<String, String> p) {
		// TODO �Զ����ɵķ������
		return userMapper.selcet(p);
	}

}
