package com.OnlineWallet.pl;

import java.sql.SQLException;

import com.OnlineWallet.DAO.AmountDAO;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class ShowBalance {

	AmountDAO amount =null;
	public void show(User user,WalletAccount wallet) throws SQLException
	{
		System.out.println("Hello " + user.getUserName() + " !!");
		amount = new AmountDAO();
		System.out.println("Your Wallet Balance is " + amount.showbalance(wallet));
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
