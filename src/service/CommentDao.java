package service;

import java.util.List;

import po.Comment;

public interface CommentDao {

	public int addComment(Comment c);
	
	public int deleteComment(int uid);
	
	public List<Comment> findComment(int gid);
}
