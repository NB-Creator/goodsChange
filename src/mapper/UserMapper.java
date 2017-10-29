package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import po.User;
import provider.UserPro;

public interface UserMapper {

	/**
	 *  @param param keyΪҪ���ڲ�ѯ�����ݿ������,valueΪ���ڲ�ѯ��ֵ
	 */
	@SelectProvider(method="select",type=UserPro.class)
	public User selcet(Map<String , String> param);
	
	@Insert("inser into values(#{username},#{nickname},#{password},#{mail},#{name},#{adress})")
	public int add(User u);
	
	/**
	 *  @param param keyΪҪ���ĵ����ݵ����ݿ������,valueΪ���ĵ�ֵ
	 */
	@UpdateProvider(method="update",type=UserPro.class)
	public int change(Map<String , String> param);
}
