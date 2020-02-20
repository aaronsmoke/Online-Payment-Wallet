package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class LoginDAO {
	static Connection connection=null;
	static Statement statement=null;
	static ResultSet resultSet=null,resultSet2=null;
	static PreparedStatement prepared=null,prepared2=null;
	User user = null;
	WalletAccount wallet=null;
	List<Integer> list1=null;

	public LoginDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public User LoginService(String loginName, String password) throws SQLException
	{
		prepared = connection.prepareStatement("Select * from WalletUSer where loginname=?");
		prepared.setString(1, loginName);
		resultSet=prepared.executeQuery();
		if(resultSet.next())
		{
			if(resultSet.getString(3).equals(password))
			{
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
				return user;
			}
			else
				return null;
		}
		return null;
	}
	
	public boolean LoginAdmin(String loginName, String password) throws SQLException
	{
		prepared = connection.prepareStatement("Select * from admin where username=?");
		prepared.setString(1, loginName);
		resultSet=prepared.executeQuery();
		//System.out.println("hello 1 ");
		if(resultSet.next())
		{
			//System.out.println("hello 2" +resultSet.getString(1));
			if(resultSet.getString(1).equals(password))
				return true;
			else
				return false;
		}
		return false;
	}
	public WalletAccount getWalletAccount(User user) throws SQLException
	{
		list1 = new ArrayList<>();
		prepared = connection.prepareStatement("Select * from walletaccount where userid=?");
		if(prepared==null)
			System.out.println("prepared is null");
		if(connection==null)
			System.out.println("conn is null");
		prepared.setInt(1, user.getId());
		resultSet=prepared.executeQuery();
		if(resultSet.next())
		{
			prepared2 = connection.prepareStatement("Select transactionid from transactionhistory where senderid=? or receiverid=?");
			prepared2.setInt(1, resultSet.getInt(1));
			prepared2.setInt(2, resultSet.getInt(1));
			resultSet2=prepared2.executeQuery();
			while(resultSet2.next())
				list1.add(resultSet2.getInt(1));
			wallet = new WalletAccount(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getString(3),resultSet.getInt(4),list1);
			return wallet;
		}
		return null;
	}
}
