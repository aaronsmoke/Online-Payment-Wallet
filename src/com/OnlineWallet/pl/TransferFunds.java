package com.OnlineWallet.pl;

import java.util.Scanner;

public class TransferFunds {

	Scanner sc = new Scanner(System.in);
	public void transfer() {
		System.out.println("Please enter the receiver's Wallet-Id");
		int acc_id=sc.nextInt();
		sc.nextLine();
		//verify acc_id from database and if exist
		//display name
		System.out.println("Enter the amount to be transfer");
		int amt=sc.nextInt();
		//check if balance>amt
		
	}
}
