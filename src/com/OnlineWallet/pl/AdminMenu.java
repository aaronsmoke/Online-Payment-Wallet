package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.Exception.RegisterException;

public class AdminMenu {
	Scanner sc = new Scanner(System.in);
	public void Display() throws RegisterException, SQLException {
		System.out.println("Press 1 for  view Verified customers");
		System.out.println("Press 2 for unverified customers");
		System.out.println("Press 3 for logout");
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
			
			}
			case 2:{
				
			}
			case 3:{
				Home home = new Home();
				home.homeMenu();
			}
		}
		
		
	}

}
