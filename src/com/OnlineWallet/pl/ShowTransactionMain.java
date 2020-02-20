package com.OnlineWallet.pl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.OnlineWallet.DAO.TransactionDAO;
import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.ForgetPasswordException;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;
import com.OnlineWallet.bean.WalletHistory;
import com.OnlineWallet.bean.WalletTransactions;

public class ShowTransactionMain {
	TransactionDAO trans = null;
	HashMap<WalletHistory, WalletTransactions> hash = null;
	WalletHistory WalletH = null;
	WalletTransactions WalletT = null;

	Scanner sc = null;

	public void display(User user, WalletAccount wallet)
			throws FileNotFoundException, InterruptedException, AddAmountException, RegisterException, SQLException,
			UpdateDataException, FundTransferException, ForgetPasswordException {
		sc = new Scanner(System.in);
		System.out.println();
		System.out.println();
		int ch;
		System.out.println(
				"Enter 1 to show transaction in Console\nEnter 2 to show transaction in .txt file\\Enter 3 for Main Menu");
		ch = sc.nextInt();
		switch (ch) {
		case 1: {
			new ShowTransactionMain().transactions(user, wallet);
			break;
		}
		case 2: {
			ShowTransactions show = new ShowTransactions();
			show.display(user, wallet);
			break;
		}
		case 3: {
			new MainMenu().m1(user, wallet);
			break;
		}
		}
	}

	public void transactions(User user, WalletAccount wallet) throws SQLException {
		trans = new TransactionDAO();
		hash = trans.showTransactions(user, wallet);
		System.out.println();
		System.out.println();

		String s1 = "Account Id";
		String s2 = " Transaction Id";
		String s3 = "Recivier ID";
		String s4 = "Description";
		String s5 = " Time";
		String s6 = " Amnt";
		String s7 = " Closing Acc. Bal";
		String s8 = "DOT";

		System.out.format("%10s%16s%16s%16s%16s%16s%16s%16s", s1, s2, s3, s4, s5, s6, s7, s8);
		Set<WalletHistory> set1 = hash.keySet();
		for (WalletHistory wall : set1) {
			WalletT = hash.get(wall);
			System.out.println();
			int sender_id = wall.getSender_Accountid();
			int transaction_id = wall.getTransactionid();
			int reciever_id = wall.getReciever_Accountid();
			System.out.format("%10d%16d%16d%16s%16s%16f%16f%16s\n", sender_id, reciever_id, transaction_id,
					WalletT.getDescription(), WalletT.getTimeOfTransaction(), WalletT.getAmount(),
					WalletT.getClosingAccountBalance(), WalletT.getDateOfTransaction());
			
		}
	}

}
