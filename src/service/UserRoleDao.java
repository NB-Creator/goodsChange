package service;

import java.util.Map;

import po.UserRole;

public interface UserRoleDao {
	
	public void insertUserRole(UserRole u);
	
	public UserRole selectUserRole(String uid);
	
	public void updateUserRole(Map<String,String> m);
}
