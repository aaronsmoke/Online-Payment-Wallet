package com.OnlineWallet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OnlineWallet.Database.DatabaseUtil;
import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.bean.WalletAccount;

public class AmountDAO {
	static Connection connection = null;
	static ResultSet resultSet = null, resultSet2 = null;
	static PreparedStatement prepared = null, prepared2 = null, prepared3 = null;
	static PreparedStatement prepared4 = null;

	public AmountDAO() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	public boolean CardCheck(String str, int mon, int year, String cvv, int amount, int id)
			throws SQLException, AddAmountException {
		prepared = connection.prepareStatement("Select * from storedcard where cardno=?");
		prepared.setString(1, str);
		float Ava, Ava2;
		resultSet = prepared.executeQuery();
		if (resultSet.next()) {

			if (resultSet.getInt(2) == mon && resultSet.getInt(3) == year && resultSet.getString(4).equals(cvv)) {
				//System.out.println("Heelo 4");
				Ava = resultSet.getFloat(5);
				if (Ava > amount) {
					//System.out.println("Heelo 5");
					prepared2 = connection
							.prepareStatement("select accountbalance from walletAccount where accountid =?");
					prepared2.setInt(1, id);
					//System.out.println("Heelo 6");
					resultSet2 = prepared2.executeQuery();
					if (resultSet2.next()) {
						// System.out.println("Heelo 7");
						Ava2 = resultSet2.getInt(1);
						Ava2 = Ava2 + amount;
						Ava = Ava - amount;
						prepared3 = connection
								.prepareStatement("update walletAccount set accountbalance = ? where accountid = ?");
						prepared3.setFloat(1, Ava2);
						prepared3.setInt(2, id);
						// System.out.println("Heelo 8");
						int res = prepared3.executeUpdate();
						if (res == 1) {
							prepared4 = connection
									.prepareStatement("update storedcard set amount = ? where cardno = ?");
							prepared4.setFloat(1, Ava);
							prepared4.setString(2, str);
							int res2 = prepared4.executeUpdate();
							if (res == 1) {
								// System.out.println("Heelo 9");
								connection.commit();
								System.out.println("Amount Updated Succesfully........... !!");
								return true;
							} else {
								connection.rollback();
								throw new AddAmountException(
										"Amount is not updated at Saved Card Details....rollback....!!!");
							}
						} else {

							connection.rollback();
							throw new AddAmountException("Amount is not updated at Wallet ....rollback....!!!");
						}

					}
				}
			}
		}
		return false;
	}
	public double showbalance(WalletAccount wallet) throws SQLException
	{
		prepared = connection.prepareStatement("select * from walletaccount where accountid=?");
		prepared.setInt(1, wallet.getAccountId());
		resultSet = prepared.executeQuery();
		if(resultSet.next())
		{
			return resultSet.getDouble(2);
		}
		return 0.0;
		
	}
	
}
