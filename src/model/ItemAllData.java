package model;

import java.util.List;

import po.Comment;
import po.Item;

public class ItemAllData {

	private Item item;
	private int collect;// ��Ʒ�ղ�����
	private int rq;// ��Ʒ�����󽻻��Ĵ���(����Ϊgid_b������)
	private int comment;// ��Ʒ��������
	private List<Comment> commentList;// ��Ʒ�����б�

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCollect() {
		return collect;
	}

	public void setCollect(int collect) {
		this.collect = collect;
	}

	public int getRq() {
		return rq;
	}

	public void setRq(int rq) {
		this.rq = rq;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

}
