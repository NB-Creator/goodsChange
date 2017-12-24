package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UserRoleMapper;
import po.UserRole;

@Service
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	UserRoleMapper urm;
	@Override
	public void insertUserRole(UserRole u) {
		// TODO 自动生成的方法存根
		urm.insertUserRole(u);
	}

	@Override
	public UserRole selectUserRole(String uid) {
		// TODO 自动生成的方法存根
		return urm.getUserByName(uid);
	}

	@Override
	public void updateUserRole(Map<String, String> m) {
		// TODO 自动生成的方法存根
		urm.updataPassword(m);
	}

}
