package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.RegisterException;

public class MainMenu {
	Scanner sc = new Scanner(System.in);

	void m1() throws InterruptedException, AddAmountException, RegisterException, SQLException {
		System.out.println("Enter 1 to Show balance");
		System.out.println("Enter 2 to Transfer funds");
		System.out.println("Enter 3 to Add amount");
		System.out.println("Enter 4 to Update Details");
		System.out.println("Enter 5 to Show Transactions");
		System.out.println("Enter 6 to Logout");
		// System.out.println("Enter 6 to show balance");

		int ch = sc.nextInt();

		switch (ch) {
		case 1: {

		}
		case 2: {

		}
		case 3: {
                AddAmount add = new AddAmount();
                add.addmoney();
                break;
		}
		case 4: {

		}
		case 5: {

		}
		case 6: {
               Home home = new Home();
               home.homeMenu();
		}
		}
	}

}
