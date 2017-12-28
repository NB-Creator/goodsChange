package po;

public class Message {

	private String usernameA;//消息发送方
	private String usernameB;//消息接收方
	private String itemId;//商品id
	private String message;//信息
	private int status;//状态(0:未读 1:已读)

	public Message(String usernameA, String usernameB, String itemId, String message, int status) {
		super();
		this.usernameA = usernameA;
		this.usernameB = usernameB;
		this.itemId = itemId;
		this.message = message;
		this.setStatus(status);
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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
