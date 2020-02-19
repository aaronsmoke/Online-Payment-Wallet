package com.OnlineWallet.pl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.OnlineWallet.DAO.TransactionDAO;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;
import com.OnlineWallet.bean.WalletHistory;
import com.OnlineWallet.bean.WalletTransactions;

public class ShowTransactions {
	TransactionDAO trans = null;
	WalletHistory WalletH = null;
	WalletTransactions WalletT = null;
	HashMap<WalletHistory, WalletTransactions> hash = null;

	public void display(User user, WalletAccount wallet) throws FileNotFoundException, SQLException {
		PrintWriter out = new PrintWriter("file.txt");
        trans = new TransactionDAO();
		hash = trans.showTransactions(user, wallet);
		String s1 = "Account Id";
		String s2 = " Transaction Id";
		String s3 = "Recivier ID";
		String s4 = "Description";
		String s5 = " Time";
		String s6 = " Amnt";
		String s7 = " Closing Acc. Bal";
		String s8 = "DOT";

		out.format("%10s%16s%16s%16s%16s%16s%16s%16s", s1, s2, s3, s4, s5, s6, s7, s8);
		Set<WalletHistory> set1 = hash.keySet();
		for (WalletHistory wall : set1) {
			WalletT = hash.get(wall);
			out.println();
			int sender_id = wall.getSender_Accountid();
			int transaction_id = wall.getTransactionid();
			int reciever_id = wall.getReciever_Accountid();
			out.format("%10d%16d%16d%16s%16s%16f%16f%16s\n", sender_id, reciever_id, transaction_id,
					WalletT.getDescription(), WalletT.getTimeOfTransaction(), WalletT.getAmount(),
					WalletT.getClosingAccountBalance(), WalletT.getDateOfTransaction());
		}
		out.close();
	}
}
