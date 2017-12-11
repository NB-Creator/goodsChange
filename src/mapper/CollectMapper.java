package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import po.Collect;

public interface CollectMapper {

	@Insert("insert into collect values(#{u_id},#{g_id})")
	public int insert(Collect c);
	
	@Delete("delete from collect where u_id=#{uid} and g_id=#{gid}")
	public int delete(@Param("uid")String uid,@Param("gid")String gid);
	
	@Select("select * from collect where u_id=#{uid}")
	public List<Collect> find(String uid);
	
	@Select("select * from collect where u_id=#{uid} and g_id=#{gid}")
	public List<Collect> select(@Param("uid")String uid,@Param("gid")String gid);
}
