package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import po.User;
import provider.UserPro;

public interface UserMapper {

	/**
	 *  @param param key为要用于查询的数据库的列名,value为用于查询的值
	 */
	@SelectProvider(method="select",type=UserPro.class)
	public User selcet(Map<String , String> param);
	
	@Insert("inser into values(#{username},#{nickname},#{password},#{mail},#{name},#{adress})")
	public int add(User u);
	
	/**
	 *  @param param key为要更改的数据的数据库的列名,value为更改的值
	 */
	@UpdateProvider(method="update",type=UserPro.class)
	public int change(Map<String , String> param);
}
