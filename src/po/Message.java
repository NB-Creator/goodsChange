package po;

public class Message {

	private String usernameA;//��Ϣ���ͷ�
	private String usernameB;//��Ϣ���շ�
	private String itemId;//��Ʒid
	private String message;//��Ϣ
	private int status;//״̬(0:δ�� 1:�Ѷ�)

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
