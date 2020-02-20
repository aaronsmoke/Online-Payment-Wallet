package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

import com.OnlineWallet.DAO.AmountDAO;
import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class AddAmount {
	private int add_amount;
	Scanner sc = null;
	AmountDAO am = null;

	public void addmoney(User user, WalletAccount wallet) throws InterruptedException, RegisterException, SQLException, AddAmountException {
		System.out.print("Enter the amount to be added: ");
		sc = new Scanner(System.in);
		am = new AmountDAO();
		add_amount = sc.nextInt();
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
				throw new RegisterException("Invalid card number");

			}
			StringBuffer str = new StringBuffer(card_no);
			str.insert(4, "-");
			str.insert(9, "-");
			str.insert(14, "-");
			// str.insert(19, "-");
			card_no = str.toString();
			System.out.println("Enter expiry month");
			int ex_month = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter expiry year");
			int ex_year = sc.nextInt();
			sc.nextLine();

			LocalDate currentdate = LocalDate.now();
			Calendar cal = Calendar.getInstance();
			// cal.setTime(currentdate);
			if (currentdate.getYear() > ex_year) {
				throw new RegisterException("Expired card");
			}
			if (currentdate.getYear() == ex_year) {
				if ((cal.get(Calendar.MONTH)) + 1 > ex_month) {
					throw new RegisterException("Expired card");
				}
			}
			System.out.println("Enter 3 digit cvv number");
			String cvv_no = sc.nextLine();
			if (!cvv_no.matches("[0-9]{3}")) {
				throw new RegisterException("Invalid card number");

			}
		if(	am.CardCheck(card_no, ex_month, ex_year, cvv_no, add_amount, wallet.getAccountId()))
			System.out.println("Amount is added");
		else
			System.out.println("Amount is not added");
			break;
		}
		case 2: {
			System.out.println("Enter the upi id");
			String upi_id = sc.nextLine();
			System.out.println("Sorry we are working on this!!!\nSorry for the inconvenience");
			break;
		}
		case 3: {
			System.out.println("Sorry we are working on this!!!\\nSorry for the inconvenience");
			break;
		}
		}

	}
}
