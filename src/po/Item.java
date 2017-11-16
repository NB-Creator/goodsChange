package po;

import java.util.List;

public class Item {

	private String id;
	private String time;
	private String name;
	private String detail;
	private String img;
	private List<String> imgpath;
	private String expect;
	private String classification;

	private Integer price;
	private String uid;

	public Item(String id, String time, String name, String detail, String img,
			String expect, String classification, Integer price, String uid) {
		super();
		this.id = id;
		this.time = time;
		this.name = name;
		this.detail = detail;
		this.img = img;
		this.expect = expect;
		this.classification = classification;
		this.price = price;
		this.uid = uid;
	}

	public Item() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<String> getImgpath() {
		return imgpath;
	}

	public void setImgpath(List<String> imgpath) {
		this.imgpath = imgpath;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	
}
