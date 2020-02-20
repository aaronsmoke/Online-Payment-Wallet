package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.DAO.FundTransferDAO;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class TransferFunds {

	private int reciever_id;
	private int amount;
	Scanner sc = null;
	FundTransferDAO fund = null;

	public void transfer(User user, WalletAccount wallet) throws SQLException, FundTransferException {
		String str, str2;
		sc = new Scanner(System.in);
		fund = new FundTransferDAO();
		System.out.println("Please enter the receiver's Wallet-Id:  ");
		reciever_id = sc.nextInt();
		sc.nextLine();
		str = fund.Search_AccountId(reciever_id, wallet);
		if (str != null) {
			// verify acc_id from database and if exist
			// display name
			System.out.println("Enter the amount to be transfer to " + str + " : ");
			amount = sc.nextInt();
			if (amount > wallet.getAccountbalance()) {
				System.out.println("Wallet has not enough balance!!");
				return;
			} else {
				sc.nextLine();
				System.out.println("Enter some Description :");
				str2 = sc.nextLine();
				if (fund.Transfer(wallet, reciever_id, amount, str2)) {
					System.out.println("Fund Transfer!!!");
				}
			}
		} else
			System.out.println("id doesnt exist");
		// check if balance>amt

	}
}
