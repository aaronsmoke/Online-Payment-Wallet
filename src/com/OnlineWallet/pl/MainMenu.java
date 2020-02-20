package com.OnlineWallet.pl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.ForgetPasswordException;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class MainMenu {
	Scanner sc = null;

	void m1(User user, WalletAccount wallet) throws InterruptedException, AddAmountException, RegisterException,
			SQLException, FileNotFoundException, UpdateDataException, FundTransferException, ForgetPasswordException {
		System.out.println("Enter 1 to Show balance");
		System.out.println("Enter 2 to Transfer funds");
		System.out.println("Enter 3 to Add amount");
		System.out.println("Enter 4 to Update Details");
		System.out.println("Enter 5 to Show Transactions");
		System.out.println("Enter 6 to Logout");
		sc = new Scanner(System.in);
		// System.out.println("Enter 6 to show balance");

		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println();
			System.out.println();
			System.out.println();
			new ShowBalance().show(user, wallet);
			break;
		}
		case 2: {
			System.out.println();
			System.out.println();
			System.out.println();
			TransferFunds funds = new TransferFunds();
			funds.transfer(user, wallet);
			break;

		}
		case 3: {
			System.out.println();
			System.out.println();
			System.out.println();
			AddAmount add = new AddAmount();
			add.addmoney(user, wallet);
			break;
		}
		case 4: {
			System.out.println();
			System.out.println();
			System.out.println();
			UpdateDetails update = new UpdateDetails();
			update.update(user, wallet);
			break;

		}
		case 5: {
			System.out.println();
			System.out.println();
			System.out.println();
			ShowTransactionMain show = new ShowTransactionMain();
			show.display(user, wallet);
			break;

		}
		case 6: {
			System.out.println();
			System.out.println();
			System.out.println();
			Home home = new Home();
			home.homeMenu();
			break;
		}
		}
		sc.nextLine();
		System.out.println("Enter home to go to Main Menu!!! : ");
		String str = sc.nextLine();
		if(str.equals("home"))
		{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		MainMenu main = new MainMenu();
		main.m1(user, wallet);
		}
	}

}
