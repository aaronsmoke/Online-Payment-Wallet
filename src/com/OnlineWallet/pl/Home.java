package com.OnlineWallet.pl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.DAO.LoginDAO;
import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.ForgetPasswordException;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class Home {

	User user = null;
	WalletAccount wallet = null;
	Scanner sc = null;

	public void homeMenu() throws RegisterException, SQLException, InterruptedException, AddAmountException,
			FileNotFoundException, UpdateDataException, FundTransferException, ForgetPasswordException {
		System.out.println("Enter 1 for Register new user");
		System.out.println("Enter 2 for Login ");
		System.out.println("Enter 3 for Forget Password ");
		sc = new Scanner(System.in);
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			RegisterPl register = new RegisterPl();
			register.registerService();
			break;
		}
		case 2: {
			LoginPl login = new LoginPl();
			user = login.Loginpl();
			wallet = new LoginDAO().getWalletAccount(user);
			MainMenu menu = new MainMenu();
			menu.m1(user, wallet);
			break;
		}
		case 3: {
			System.out.println("--FORGET PASSWORD--");
			ForgetPassword forget = new ForgetPassword();
			forget.Forgot();
			
			System.out.println();
			System.out.println();
			System.out.println();
			Home home = new Home();
			home.homeMenu();
			break;
		}

		}
	}

	public static void main(String[] args)
			throws FileNotFoundException, RegisterException, SQLException, InterruptedException, AddAmountException,
			UpdateDataException, FundTransferException, ForgetPasswordException {
		Home home = new Home();
		home.homeMenu();
	}
}
