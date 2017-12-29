package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import po.Message;
import provider.MessageProvider;

public interface MessageMapper {

	@Insert("insert into message values(#{usernameA},#{usernameB},#{excId},#{message},#{statu})")
	public int insert(Message m);
	
	@SelectProvider(type=MessageProvider.class,method="select")
	public List<Message> select(Map<String, String> p);
	
	@Update("update message set statu=#{statu} where excId=#{excId}")
	public int update(Message m);
	
	@Delete("delete from message where excId=#{excId}")
	public int delete(String excId);
	
	@Select("select count(*) from message where usernameB=#{uid} and statu=0")
	public int unread(String uid);
}
