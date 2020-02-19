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

	void m1(User user, WalletAccount wallet) throws InterruptedException, AddAmountException, RegisterException, SQLException, FileNotFoundException, UpdateDataException, FundTransferException, ForgetPasswordException {
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
           System.out.println("Your Wallet Balance is "+wallet.getAccountbalance());
           break;
		}
		case 2: {
			TransferFunds funds = new TransferFunds();
			funds.transfer(user,wallet);

		}
		case 3: {
                AddAmount add = new AddAmount();
                add.addmoney(user,wallet);
                break;
		}
		case 4: {
			UpdateDetails update = new UpdateDetails();
			update.update(user, wallet);
			break;

		}
		case 5: {
			ShowTransactions show = new ShowTransactions();
			show.display(user, wallet);
			break;

		}
		case 6: {
               Home home = new Home();
               home.homeMenu();
               break;
		}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		Home home = new Home();
        home.homeMenu();
	}
	

}
