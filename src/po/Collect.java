package po;

/**
 * 
 * @author 1850252892@qq.com
 * 收藏
 */
public class Collect {
	private String u_id;// 用户id
	private String g_id;// 商品id
	
	public Collect(String u_id, String g_id) {
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

}
