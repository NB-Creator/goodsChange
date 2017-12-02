package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import po.Comment;

public interface CommentMapper {

	@Insert("insert into comment values(#{u_id},#{g_id},#{info},#{date})")
	public int insert(Comment comment);
	
	@Delete("delete from comment where uid=#{uid}")
	public int delete(int uid);
	
	@Select("select * from comment where gid=#{gid}")
	public List<Comment> find(int gid);
}
