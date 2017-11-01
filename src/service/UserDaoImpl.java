package service;

import java.util.Map;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.User;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean login(User u) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean register(User u) {
		
		// TODO 自动生成的方法存根
		userMapper.add(u);
		return false;
	}

	@Override
	public void changeInfo(Map<String, String> p) {
		// TODO 自动生成的方法存根
		userMapper.change(p);
	}

}
