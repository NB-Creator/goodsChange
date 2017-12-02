package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.CommentMapper;
import po.Comment;

public class CommentDaoImpl implements CommentDao {

	@Autowired
	private CommentMapper cm;
	
	@Override
	public int addComment(Comment c) {
		return cm.insert(c);
	}

	@Override
	public int deleteComment(int uid) {
		return cm.delete(uid);
	}

	@Override
	public List<Comment> findComment(int gid) {
		return cm.find(gid);
	}

	public void setCm(CommentMapper cm) {
		this.cm = cm;
	}
}
