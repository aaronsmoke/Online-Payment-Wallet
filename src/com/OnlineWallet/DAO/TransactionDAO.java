package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;
import com.OnlineWallet.bean.WalletHistory;
import com.OnlineWallet.bean.WalletTransactions;

public class TransactionDAO {
	HashMap<WalletHistory,WalletTransactions> list2=null;
	static Connection connection = null;
	static ResultSet resultSet = null,resultSet2=null;
	static PreparedStatement prepared = null,prepared2=null,prepared3=null;
	WalletHistory walletH=null;
	WalletTransactions walletT=null;
	
	public TransactionDAO() throws SQLException
	{
		connection = DatabaseUtil.myconnection();
	}
	
	public HashMap<WalletHistory,WalletTransactions> showTransactions(User user, WalletAccount wallet) throws SQLException
	{
		list2 = new HashMap<>();
		for(Integer i: wallet.getTransactionHistory())
		{
			//System.out.println(i);
			prepared = connection.prepareStatement("select * from transactionhistory where transactionid=?");
			prepared.setInt(1, i);
			resultSet = prepared.executeQuery();
			if(resultSet.next())
			{
		       walletH = new WalletHistory(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3));
		       prepared2 = connection.prepareStatement("select * from wallettransactions where transactionid=?");
				prepared2.setInt(1, i);
				resultSet2 = prepared2.executeQuery();
				if(resultSet2.next())
				{
					walletT = new WalletTransactions(resultSet2.getInt(1),resultSet2.getString(2),resultSet2.getDate(3),resultSet2.getTime(4),resultSet2.getDouble(5),resultSet2.getDouble(6));
					list2.put(walletH, walletT);
				}
		       
			}
		}
		return list2;
	}

}
