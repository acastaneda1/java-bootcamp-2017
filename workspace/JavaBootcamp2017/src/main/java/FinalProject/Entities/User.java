package FinalProject.Entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int userId;

	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "creditcard_number")
	private int creditCardNumber;

	public User() {

	}

	public User(String name, String email, String password, int creditCardNumberUser) {
		this.userName = name;
		this.userEmail = email;
		this.userPassword = password;
		this.creditCardNumber = creditCardNumberUser;
	}

	public void setUserId(int idU) {
		this.userId = idU;
	}

	public int getUserId() {
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

