package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.bean.User;

public class AdminDAO implements Admin {
	static Connection connection = null;
	static ResultSet resultSet = null, resultSet2 = null;
	static PreparedStatement prepared = null, prepared2 = null, prepared3 = null;
	HashMap<Integer, User> hashmap=null;
	User user = null;

	public AdminDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	@Override
	public HashMap<Integer, User> verified_users() throws SQLException {
		// TODO Auto-generated method stub
		hashmap = new HashMap<>();
		int account_id, userid;
		prepared = connection.prepareStatement("Select * from WalletUSer");
		resultSet = prepared.executeQuery();
		while (resultSet.next()) {
			userid = resultSet.getInt(1);
			// System.out.println("hello i am hetre "+userid);
			user = new User(userid, resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getString(5), resultSet.getString(6));
			prepared2 = connection.prepareStatement("Select accountid from walletaccount where userid=?");
			prepared2.setInt(1, userid);
			resultSet2 = prepared2.executeQuery();
			if (resultSet2.next()) {
				account_id = resultSet2.getInt(1);
				// System.out.println("hello i am hetre "+account_id+" "+user);
				hashmap.put(account_id, user);
			}
		}
		return hashmap;

	}

	@Override
	public HashMap<Integer, User> unverified_users() throws SQLException {
		// TODO Auto-generated method stub
		hashmap = new HashMap<>();
		int userid;
		prepared = connection.prepareStatement("Select * from TempWalletUSer");
		resultSet = prepared.executeQuery();
		while (resultSet.next()) {
			userid = resultSet.getInt(1);
			user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getString(5), resultSet.getString(6));
			hashmap.put(userid, user);
		}

		return hashmap;

	}

	public boolean Adminappprove(char ch, User user, int key) throws SQLException {
		if (ch == 'A' || ch == 'a') {
			prepared = connection.prepareStatement("insert into WalletUser values(?,?,?,?,?,?)");
			prepared.setInt(1, key);
			prepared.setString(2, user.getUserName());
			prepared.setString(3, user.getPassword());
			prepared.setString(4, user.getPhoneNo());
			prepared.setString(5, user.getLoginName());
			prepared.setString(6, user.getEmail());
			int res = prepared.executeUpdate();
			if (res == 1) {
				AdminDAO admin = new AdminDAO();
				if ((admin.DeleteTemp(user, key))) {
					if ((admin.WalletAccount(user, key))) {
						connection.commit();
						return true;
					}
				} 
				
					connection.rollback();
					//System.out.println("Hello i am here 1");
					return false;
			} else
				return false;
		} else {
			if (new AdminDAO().DeleteTemp(user, key)) {
				connection.commit();
				return true;
			} else
				return false;
		}

	}

	public boolean DeleteTemp(User user, int key) throws SQLException {
		prepared2 = null;
		prepared2 = connection.prepareStatement("delete from TempWalletUser where userid=?");
		prepared2.setInt(1, key);

		int res = prepared2.executeUpdate();
		// System.out.println("Hello i am here 7 "+res);
		if (res == 1) {
			// System.out.println("Hello i am here 2");
			return true;
		} else
			return false;
	}

	public boolean WalletAccount(User user, int key) throws SQLException {
		prepared3 = null;
		String status = "Active";
		prepared3 = connection
				.prepareStatement("insert into WalletAccount(AccountBalance,status,userid) values(?,?,?)");
		// prepared.setInt(1, user.getId());
		prepared3.setFloat(1, 50); // Initial balance is 50
		prepared3.setString(2, status);
		prepared3.setInt(3, key+1);
		int res = prepared3.executeUpdate();
		if (res == 1)
			return true;
		else
			return false;
	}
}
