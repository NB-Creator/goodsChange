package model;

public class ExcData {
	String excId;//交换单号
	String excDate;//交换时间
	String gid_a;
	String gname_a;
	String gimg_a;//g_a的第一张图片的地址，即imgpath.get(0)
	String gid_b;
	String gname_b;
	String gimg_b;
	String info;//交换备注信息
	public String getExcId() {
		return excId;
	}
	public void setExcId(String excId) {
		this.excId = excId;
	}
	public String getExcDate() {
		return excDate;
	}
	public void setExcDate(String excDate) {
		this.excDate = excDate;
	}
	public String getGid_a() {
		return gid_a;
	}
	public void setGid_a(String gid_a) {
		this.gid_a = gid_a;
	}
	public String getGname_a() {
		return gname_a;
	}
	public void setGname_a(String gname_a) {
		this.gname_a = gname_a;
	}
	public String getGimg_a() {
		return gimg_a;
	}
	public void setGimg_a(String gimg_a) {
		this.gimg_a = gimg_a;
	}
	public String getGid_b() {
		return gid_b;
	}
	public void setGid_b(String gid_b) {
		this.gid_b = gid_b;
	}
	public String getGname_b() {
		return gname_b;
	}
	public void setGname_b(String gname_b) {
		this.gname_b = gname_b;
	}
	public String getGimg_b() {
		return gimg_b;
	}
	public void setGimg_b(String gimg_b) {
		this.gimg_b = gimg_b;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
