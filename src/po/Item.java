package po;

public class Item {

	private int id;
	private String time;
	private String name;
	private String detail;
	private byte[] img;
	private String expect;
	private String classification;
	private int price;
	private int uid;

	public Item(int id, String time, String name, String detail, byte[] img,
			String expect, String classification, int price, int uid) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getexpect() {
		return expect;
	}

	public void setexpect(String expect) {
		this.expect = expect;
	}

	public String getclassification() {
		return classification;
	}

	public void setclassification(String classification) {
		this.classification = classification;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
