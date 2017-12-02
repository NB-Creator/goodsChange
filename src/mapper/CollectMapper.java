package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import po.Collect;

public interface CollectMapper {

	@Insert("insert into collect values(#{u_id},#{g_id})")
	public int insert(Collect c);
	
	@Delete("delete from collect where uid=#{uid}")
	public int delete(int uid);
	
	@Select("select * from collect where uid=#{uid}")
	public List<Collect> find(int uid);
}
