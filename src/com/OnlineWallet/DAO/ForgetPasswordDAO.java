package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OnlineWallet.Database.DatabaseUtil;

public class ForgetPasswordDAO {

	static Connection connection = null;
	static ResultSet resultSet = null;
	static PreparedStatement prepared = null;

	public ForgetPasswordDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public String Search(String email, String phoneno) throws SQLException {
		prepared = connection
				.prepareStatement("select username from walletuser where email_address=? and phonenumber = ? ");
		prepared.setString(1, email);
		prepared.setString(2, phoneno);
		resultSet = prepared.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1);
		return null;
	}

	public boolean UpdatePass(String email, String phoneno, String pass) throws SQLException {
		prepared = connection
				.prepareStatement("update walletuser set password = ? where phonenumber = ? and email_address=?");
		prepared.setString(1, pass);
		prepared.setString(3, email);
		prepared.setString(2, phoneno);
		int res = prepared.executeUpdate();
		if (res == 1) {
			connection.commit();
			return true;
		} else
			return false;
	}
}
