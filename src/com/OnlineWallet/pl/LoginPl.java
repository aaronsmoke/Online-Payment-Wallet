package com.OnlineWallet.pl;

import java.io.Console;
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

public class LoginPl {
	private String loginName;
	private String password;

	public User Loginpl() throws SQLException, RegisterException, InterruptedException, AddAmountException,
			FileNotFoundException, UpdateDataException, FundTransferException, ForgetPasswordException {
		Console console = System.console();

		System.out.println("----------------Login-----------------");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your LoginNAme");
		loginName = scan.nextLine();
		System.out.println("Enter Your Password");
		password = new String(console.readPassword());
		//System.out.println(password);
		LoginDAO login = new LoginDAO();
		if (login.LoginService(loginName, password) != null) {
			System.out.println("Suucess , You are logined!!");
			System.out.println();
			System.out.println();
			User user = login.LoginService(loginName, password);
			return user;
		} else if (login.LoginAdmin(loginName, password)) {
			System.out.println("Admin Login!!");
			new AdminMenu().Display();
			return null;
		} else {
			System.out.println("Wrong Username or Password!!");
			return null;
		}
 
	}

}
