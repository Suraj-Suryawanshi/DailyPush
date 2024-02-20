package surya.model;

import java.sql.Date;

public class User {
	
	private int userId;
	private String role;
	private String userName;
	private String userEmail;
	private String userDob;
	private String userAddress;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserDob() {
		return userDob;
	}
	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User(int userId, String role, String userName, String userEmail, String userDob, String userAddress,
			String password) {
		super();
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userDob = userDob;
		this.userAddress = userAddress;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", role=" + role + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userDob=" + userDob + ", userAddress=" + userAddress + ", password=" + password + "]";
	}

	

	
	
}
