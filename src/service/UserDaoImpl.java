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
	 * 用户登录，检测用户是否存在，密码是否正确，并返回相应的信息（非 Javadoc）
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
	 * 用户注册，检测昵称，邮箱是否已被使用
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
	 * 修改用户资料
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
		// TODO 自动生成的方法存根
		return userMapper.selcet(p);
	}

	public void setUrm(UserRoleMapper urm) {
		this.urm = urm;
	}

}
