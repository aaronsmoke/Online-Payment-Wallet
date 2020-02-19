package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.Exception.RegisterException;

public class Home {

	Scanner sc = new Scanner(System.in);

	void homeMenu() throws RegisterException, SQLException {
		System.out.println("Enter 1 for Register new user");
		System.out.println("Enter 2 for Login registered user");
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			RegisterPl register = new RegisterPl();
			register.registerService();
			break;
		}
		case 2: {
			LoginPl login = new LoginPl();
			login.Loginpl();
			break;
		}

		}
	}

	public static void main(String[] args) throws RegisterException, SQLException {
		Home h = new Home();
		h.homeMenu();

	}
}
