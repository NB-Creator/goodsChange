package model;

import java.util.List;

import po.Comment;

public class ItemAllData {
	String name;//��Ʒ��
	String id;//��Ʒ
	String date;//��Ʒ����ʱ��
	String type;//��Ʒ����
	String expect;//Ԥ����Ʒ
	String price;//����
	List<String> img;//ͼƬ�б�
	String detail;//��Ʒ����
	String collect;//��Ʒ�ղ�����
	String rq;//��Ʒ�����󽻻��Ĵ���(����Ϊgid_b������)
	String comment;//��Ʒ��������
	List<Comment> commentList;//��Ʒ�����б�
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = new String(price.toString());
	}
	public List<String> getImg() {
		return img;
	}
	public void setImg(List<String> img) {
		this.img = img;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCollect() {
		return collect;
	}
	public void setCollect(String collect) {
		this.collect = collect;
	}
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
}
