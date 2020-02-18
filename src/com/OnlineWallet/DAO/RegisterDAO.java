package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.bean.User;

public class RegisterDAO {

	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static PreparedStatement prepared = null;

	public RegisterDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public static boolean Search(int id) throws SQLException {
		prepared = connection.prepareStatement("select * from WalletUser from UserId=? ");
		prepared.setInt(1, id);
		resultSet = prepared.executeQuery();
		if (resultSet.next())
			return true;
		else
			return false;
	}

	public static boolean Search(String loginName) throws SQLException {
		if (connection == null)
			System.err.println("connection is null");
		prepared = connection.prepareStatement("select userid from WalletUser where loginname = ?");
		prepared.setString(1, loginName);
		resultSet = prepared.executeQuery();
		if (resultSet.next())
			return false;
		else
			return true;
	}

	public boolean RegisterService(User user) throws SQLException {
		prepared = connection.prepareStatement("insert into WalletUser(username,password,phonenumber,loginname,email_address) values(?,?,?,?,?)");
		//prepared.setInt(1, user.getId());
		prepared.setString(1, user.getUserName());
		prepared.setString(2, user.getPassword());
		prepared.setString(3, user.getPhoneNo());
		prepared.setString(4, user.getLoginName());
		prepared.setString(5, user.getEmail());
		int res = prepared.executeUpdate();
		if (res == 1) {

			connection.commit();
			return true;
		} else
			return false;

	}

}
