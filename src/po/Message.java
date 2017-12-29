package po;

public class Message {

	private String usernameA;//消息发送方
	private String usernameB;//消息接收方
	private String  excId;//交换单id
	private String message;//信息
	private Integer statu;//状态(0:未读 1:已读)

	public Message() {}
	public Message(String usernameA, String usernameB, String excId, String message, Integer statu) {
		super();
		this.usernameA = usernameA;
		this.usernameB = usernameB;
		this.excId = excId;
		this.message = message;
		this.setStatu(statu);
	}

	public String getUsernameA() {
		return usernameA;
	}

	public void setUsernameA(String usernameA) {
		this.usernameA = usernameA;
	}

	public String getUsernameB() {
		return usernameB;
	}

	public void setUsernameB(String usernameB) {
		this.usernameB = usernameB;
	}

	public String getExcId() {
		return excId;
	}

	public void setExcId(String excId) {
		this.excId = excId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

}
