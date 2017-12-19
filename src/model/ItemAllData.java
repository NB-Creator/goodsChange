package model;

import java.util.List;

import po.Comment;

public class ItemAllData {
	String name;//商品名
	String id;//商品
	String date;//商品发布时间
	String type;//商品分类
	String expect;//预期商品
	String price;//估价
	List<String> img;//图片列表
	String detail;//商品描述
	String collect;//商品收藏总数
	String rq;//商品被请求交换的次数(即作为gid_b的数量)
	String comment;//商品评论总数
	List<Comment> commentList;//商品评论列表
	
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
