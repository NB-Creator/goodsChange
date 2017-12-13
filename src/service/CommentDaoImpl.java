package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mapper.CommentMapper;
import po.Comment;

@Service
@Transactional(readOnly=false,isolation=Isolation.READ_COMMITTED,rollbackFor=java.lang.Exception.class)
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private CommentMapper cm;

	@Override
	public int addComment(Comment c) {
		return cm.insert(c);
	}

	@Override
	public int deleteComment(String uid,String gid) {
		return cm.delete(uid,gid);
	}

	@Override
	public List<Comment> findComment(String gid) {
		return cm.find(gid);
	}

	public void setCm(CommentMapper cm) {
		this.cm = cm;
	}
}
