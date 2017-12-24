package mapper;



import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import po.MyUser;
public interface UserRoleMapper {
	@Select("select *from userRole where username=#{username}")
	 MyUser getUserByName(String username);
	
	@Insert("isnert into userRole value(#{username},#{password},#{role})")
	public void insertUserRole(Map<String,String> m);
	
	@Update("update to userRole set password=#{password} where username=#{username}")
	public void updataPassword(Map<String,String> m);
}
