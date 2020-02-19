package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.OnlineWallet.Database.DatabaseUtil;

public class LoginDAO {
	static Connection connection=null;
	static Statement statement=null;
	static ResultSet resultSet=null;
	static PreparedStatement prepared=null;

	public LoginDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public boolean LoginService(String loginName, String password) throws SQLException
	{
		prepared = connection.prepareStatement("Select password from WalletUSer where loginname=?");
		prepared.setString(1, loginName);
		resultSet=prepared.executeQuery();
		if(resultSet.next())
		{
			if(resultSet.getString(1).equals(password))
				return true;
			else
				return false;
		}
		return false;
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
}
