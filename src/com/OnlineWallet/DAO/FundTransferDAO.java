package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.bean.WalletAccount;

public class FundTransferDAO {
	static Connection connection = null;
	static ResultSet resultSet = null, resultSet2 = null;
	static PreparedStatement prepared = null, prepared2 = null, prepared3 = null, prepared4 = null, prepared5 = null;

	public FundTransferDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public String Search_AccountId(int reciever_id, WalletAccount wallet) throws SQLException {
		prepared = connection.prepareStatement("select userid  from walletAccount where accountid=?");
		prepared.setInt(1, reciever_id);
		resultSet = prepared.executeQuery();
		if (resultSet.next()) {
			prepared2 = connection.prepareStatement("select username  from walletuser where userid=?");
			prepared2.setInt(1, resultSet.getInt(1));
			resultSet2 = prepared2.executeQuery();
			if (resultSet2.next())
				return resultSet2.getString(1);
		}
		return null;
	}

	public boolean Transfer(WalletAccount wallet, int reciever_id, float amount, String str)
			throws SQLException, FundTransferException {
		float amt1;
		prepared = connection.prepareStatement("select *  from walletaccount where accountid=?");
		prepared.setInt(1, reciever_id);
		resultSet = prepared.executeQuery();
		if (resultSet.next()) {
			amt1 = resultSet.getFloat(2);
			amt1 = amt1 + amount;
			wallet.setAccountbalance(wallet.getAccountbalance() - amount);
			prepared2 = connection.prepareStatement("update walletAccount set accountbalance = ? where accountid = ?");
			prepared2.setFloat(1, amt1);
			prepared2.setInt(2, reciever_id);
			// System.out.println("Heelo 8");
			int res = prepared2.executeUpdate();
			if (res == 1) {
				prepared3 = connection.prepareStatement("update walletAccount set accountbalance = ? where userid = ?");
				prepared3.setDouble(1, wallet.getAccountbalance());
				prepared3.setInt(2, wallet.getUserId());
				int res2 = prepared3.executeUpdate();
				if (res2 == 1) {
					// System.out.println("Heelo 9");
					prepared4 = connection.prepareStatement(
							"insert into walletTransactions(description,amount,accountbalance) values(?,?,?)");
					prepared4.setString(1, str);
					prepared4.setFloat(2, amount);
					prepared4.setFloat(3, (float) wallet.getAccountbalance());
					int res3 = prepared4.executeUpdate();
					if (res3 == 1) {
						prepared5 = connection
								.prepareStatement("insert into transactionhistory(senderid,ReceiverId) values(?,?)");
						prepared5.setInt(1, wallet.getAccountId());
						prepared5.setInt(2, reciever_id);
						int res5 = prepared5.executeUpdate();
						if (res5 == 1) {
							connection.commit();
							System.out.println("All done !!");
							return true;
						} else {
							connection.rollback();
							throw new FundTransferException(
									"Transaction history table is not updated.....roll back....!!");
						}
					} else {
						connection.rollback();
						throw new FundTransferException("Transaction Account table is not updated.....roll back....!!");
					}
				} else {
					connection.rollback();
					throw new FundTransferException("Wallet amount is not updated at senders end.....roll back....!!");
				}
			} else {
				connection.rollback();
				throw new FundTransferException("Wallet amount is not updated at recievers end.....roll back....!!");
			}

		}
		return false;
	}
}
