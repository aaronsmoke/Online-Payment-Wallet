package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.bean.User;

public class AdminDAO implements Admin{
	static Connection connection=null;
	static Statement statement=null;
	static ResultSet resultSet=null,resultSet2=null;
	static PreparedStatement prepared=null;
	HashMap<Integer,User> hashmap ;
	User user=null;
	
	public AdminDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	@Override
	public HashMap<Integer,User> verified_users() throws SQLException {
		// TODO Auto-generated method stub
		hashmap=null;
		int account_id,userid;
		prepared = connection.prepareStatement("Select * from WalletUSer");
		resultSet=prepared.executeQuery();
		while(resultSet.next())
		{
			userid = resultSet.getInt(1);
		   	user = new User(userid,resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));  
		   	prepared = null;
		   	prepared = connection.prepareStatement("Select accountid from walletaccount where userid=?");
		   	prepared.setInt(1,userid);
			resultSet2=prepared.executeQuery();
			if(resultSet2.next())
			{
				hashmap.put(resultSet2.getInt(1), user);
			}
		}
		return hashmap;
		
	}

	@Override
	public HashMap<Integer,User> unverified_users() {
		// TODO Auto-generated method stub
		hashmap=null;
		
		
	}
	
	

}
