package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import po.UserRole;

public interface UserRoleMapper {
	@Select("select *from userRole where username=#{username}")
	 public UserRole getUserByName(String username);
	
	@Insert("insert into userRole value(#{username},#{password},#{role})")
	public void insertUserRole(UserRole u);
	
	@Update("update to userRole set password=#{password} where username=#{username}")
	public void updataPassword(Map<String,String> m);
}
