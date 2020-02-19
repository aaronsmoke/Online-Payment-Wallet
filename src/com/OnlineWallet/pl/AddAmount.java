package com.OnlineWallet.pl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

import com.OnlineWallet.Exception.AddAmountException;

public class AddAmount {
	Scanner sc = null;

	public void addmoney() throws InterruptedException, AddAmountException {
		System.out.println("Enter the amount to be added");
		sc = new Scanner(System.in);
		int amount = sc.nextInt();
		sc.nextLine();
		System.out.flush();
		Thread.sleep(300);
		System.out.println("Now please choose the add payment method\n");
		System.out.println("Enter 1 for debit/credit card");
		System.out.println("Enter 2 for UPI");
		System.out.println("Enter 3 for NetBanking");

		int ch = sc.nextInt();
		sc.nextLine();
		switch (ch) {
		case 1: {
			System.out.println("Enter the 16 digit card number");
			String card_no = sc.nextLine();
			if (!card_no.matches("[0-9]{16}")) {
				throw new AddAmountException("Invalid card number");

			}
			System.out.println("Enter expirary month");
			int ex_month = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter expiry year");
			int ex_year = sc.nextInt();
			sc.nextLine();

			LocalDate currentdate = LocalDate.now();
			Calendar cal = Calendar.getInstance();
			// cal.setTime(currentdate);
			if (currentdate.getYear() > ex_year) {
				throw new AddAmountException("Expired card");
			}
			if (currentdate.getYear() == ex_year) {
				if ((cal.get(Calendar.MONTH)) + 1 > ex_month) {
					throw new AddAmountException("Expired card");
				}
			}
			System.out.println("Enter 3 digit cvv number");
			String cvv_no = sc.nextLine();
			if (!cvv_no.matches("[0-9]{3}")) {
				throw new AddAmountException("Invalid card number");
			}
			
			break;
		}
		case 2: {
			System.out.println("Enter the upi id");
			String upi_id = sc.nextLine();
			break;
		}
		case 3: {
			break;
		}
		}

	}

}
