package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.bean.User;

public class UpdateDAO {
	static Connection connection = null;
	static ResultSet resultSet = null, resultSet2 = null;
	static PreparedStatement prepared = null, prepared2 = null, prepared3 = null;

	public UpdateDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public boolean updateDetails(int ch, User user) throws SQLException, UpdateDataException {
		if (ch == 1) {
			prepared = connection.prepareStatement("update walletuser set loginname = ? where userid=?  ");
			prepared.setString(1, user.getLoginName());
			// System.out.println(user.getLoginName());
			prepared.setInt(2, user.getId());
			int res = prepared.executeUpdate();
			if (res == 1) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				throw new UpdateDataException("Login Name is not updated....roll back!!");
			}
		} else if (ch == 2) {
			prepared = connection.prepareStatement("update walletuser set phonenumber = ? where userid=?  ");
			prepared.setString(1, user.getPhoneNo());
			prepared.setInt(2, user.getId());
			int res = prepared.executeUpdate();
			if (res == 1) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				throw new UpdateDataException("Phone Number is not updated....roll back!!");
			}
		} else if (ch == 3) {
			prepared = connection.prepareStatement("update walletuser set email_address = ? where userid=?  ");
			prepared.setString(1, user.getEmail());
			prepared.setInt(2, user.getId());
			int res = prepared.executeUpdate();
			if (res == 1) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				throw new UpdateDataException("Email Address is not updated....roll back!!");
			}
		}
		return false;
	}
}
