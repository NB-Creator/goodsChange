package model;

import java.util.List;

public class ExcDate {
	private String excId;// 交换单号
	private String excDate;// 交换时间
	private String gid_a;
	private String gname_a;
	private List<String> gimg_a;// g_a的第一张图片的地址，即imgpath.get(0)
	private String gid_b;
	private String gname_b;
	private List<String> gimg_b;
	private String info;// 交换备注信息

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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<String> getGimg_a() {
		return gimg_a;
	}

	public void setGimg_a(List<String> gimg_a) {
		this.gimg_a = gimg_a;
	}

	public List<String> getGimg_b() {
		return gimg_b;
	}

	public void setGimg_b(List<String> gimg_b) {
		this.gimg_b = gimg_b;
	}

}
