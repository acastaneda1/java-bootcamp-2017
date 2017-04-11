package Clase4API.Model;

public class User {

	private String userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private int creditCardNumber;

	public User(String id, String name, String email, String password, int creditCardNumberUser) {
		this.userId = id;
		this.userName = name;
		this.userEmail = email;
		this.userPassword = password;
		this.creditCardNumber = creditCardNumberUser;
	}

	public void setUserId(String idU) {
		this.userId = idU;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserName(String nameU) {
		this.userName = nameU;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserEmail(String emailU) {
		this.userEmail = emailU;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserPassword(String passwordU) {
		this.userPassword = passwordU;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserCCNumber(int creditCardNumberU) {
		this.creditCardNumber = creditCardNumberU;
	}

	public int getUserCCNumber() {
		return creditCardNumber;
	}
}
