package service;

import java.util.HashMap;
import java.util.Map;

import mapper.UserMapper;
import mapper.UserRoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import po.User;
import po.UserRole;

@Service
@Transactional(readOnly=false,isolation=Isolation.READ_COMMITTED,rollbackFor=java.lang.Exception.class)
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper urm;

	/*
	 * �û���¼������û��Ƿ���ڣ������Ƿ���ȷ����������Ӧ����Ϣ���� Javadoc��
	 * 
	 * @see service.UserDao#login(po.User)
	 */
	@Override
	public String login(User u) {
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
		urm.insertUserRole(new UserRole(u.getUsername(),u.getPassword(),"ROLE_USER"));
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
		userMapper.change(p);
		if(p.get("password")!=null)
			urm.updataPassword((String)p.get("password"),(String)p.get("username"));
	}

	@Override
	public User getUser(Map<String, String> p) {
		// TODO �Զ����ɵķ������
		return userMapper.selcet(p);
	}

	public void setUrm(UserRoleMapper urm) {
		this.urm = urm;
	}

}
