package po;

/**
 * 
 * @author 1850252892@qq.com ��������
 */
public class Comment {
	private String u_id;// �û�id
	private String g_id;// ��Ʒid
	private String info;// ��������
	private String date;// ����ʱ��

	public Comment(){
	}
	
	public Comment(String u_id, String g_id) {
		super();
		this.u_id = u_id;
		this.g_id = g_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getG_id() {
		return g_id;
	}

	public void setG_id(String g_id) {
		this.g_id = g_id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
