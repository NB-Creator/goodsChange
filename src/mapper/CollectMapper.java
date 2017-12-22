package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import po.Collect;
import po.Item;
import provider.CollectProvider;

public interface CollectMapper {

	@Insert("insert into collect values(#{u_id},#{g_id})")
	public int insert(Collect c);
	
	@Delete("delete from collect where u_id=#{uid} and g_id=#{gid}")
	public int delete(@Param("uid")String uid,@Param("gid")String gid);
	
	/*@Select("select * from collect where u_id=#{uid}")
	public List<Collect> find(String uid);
	
	@Select("select * from collect where u_id=#{uid} and g_id=#{gid}")
	public List<Collect> select(@Param("uid")String uid,@Param("gid")String gid);*/
	
	@SelectProvider(method="select",type=CollectProvider.class)
	public List<Collect> select(Map<String, String> m);
	
	@Select("select count(*) from collect where g_id=#{gid}")
	public int getCollectedCount(String gid);
	
	@Select("select DISTINCT i.id,i.time,i.name,i.detail,i.img,i.expect,i.classification,i.price,i.uid "+
				"from tb_item i,collect c where c.u_id=#{uid}  AND i.id=c.g_id")
	public List<Item> getMyCollect(String uid);
}
