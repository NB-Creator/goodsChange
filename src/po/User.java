package po;

public class User {

	private String username;
	private String nickname;
	private String password;
	private String mail;
	private String name;
	private String address;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String nickname, String password, String mail, String name, String address) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.mail = mail;
		this.name = name;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

}
