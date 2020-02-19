package com.OnlineWallet.pl;

import java.io.Console;
import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.DAO.LoginDAO;

public class LoginPl {
	private String loginName;
	private String password;
	public boolean Loginpl() throws SQLException {
		
		System.out.println("Enter Your Login Details");
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Your LoginNAme");
		loginName=scan.nextLine();
		System.out.println("Enter Your Password");
		password=scan.nextLine();
		LoginDAO login=new LoginDAO();
		if(login.LoginService(loginName,password))
		{
			System.out.println("Suucess!!");
			return true;
		}
		else if(login.LoginAdmin(loginName, password))
		{
			System.out.println("Admin Login!!");
			return true;
		}
		else {
			System.out.println("Annyaa");
			return false;
		}

}
	public static void main(String[] args) throws SQLException {
		LoginPl l = new LoginPl();
		l.Loginpl();
	}
}
