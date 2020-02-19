package com.OnlineWallet.DAO;

import java.sql.SQLException;
import java.util.HashMap;

import com.OnlineWallet.bean.User;

public interface Admin {

	public HashMap<Integer, User> verified_users() throws SQLException;
	public HashMap<Integer, User> unverified_users();
}
