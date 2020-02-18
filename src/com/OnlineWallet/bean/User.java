package com.OnlineWallet.bean;

public class User {
	private int UserId;
	private String UserName;
	private String password;
	private String phoneNo;
	private String LoginName;
	private String Email;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LoginName == null) ? 0 : LoginName.hashCode());
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
		result = prime * result + UserId;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (LoginName == null) {
			if (other.LoginName != null)
				return false;
		} else if (!LoginName.equals(other.LoginName))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		if (UserId != other.UserId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		return true;
	}

	public User( String userName, String password, String phoneNo, String loginName, String email) {
		super();
		//this.UserId = id;
		UserName = userName;
		this.password = password;
		this.phoneNo = phoneNo;
		LoginName = loginName;
		this.Email =  email;
	}

	public int getId() {
		return UserId;
	}

	public void setId(int id) {
		this.UserId = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLoginName() {
		return LoginName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", LoginName=" + LoginName + "]";
	}

}
