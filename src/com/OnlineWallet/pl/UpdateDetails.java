package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.DAO.RegisterDAO;
import com.OnlineWallet.DAO.UpdateDAO;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.bean.User;
import com.OnlineWallet.bean.WalletAccount;

public class UpdateDetails {
	Scanner sc = null;
	UpdateDAO update = null;
	RegisterDAO register = null;
	private String loginname;
	private String email;
	private String phoneno;

	void update(User user, WalletAccount wallet) throws SQLException, RegisterException, UpdateDataException {
		register = new RegisterDAO();
		update = new UpdateDAO();
		sc = new Scanner(System.in);
		System.out.println("Your Details");
		System.out.println("Name : " + user.getUserName());
		System.out.println("Phone No : " + user.getPhoneNo());
		System.out.println("Email : " + user.getEmail());
		System.out.println("Wallet Id : " + wallet.getAccountId());
		System.out.println("Login Name : " + user.getLoginName());
		System.out.println("Enter 1 to update the loginname");
		System.out.println("Enter 2 to update the phone number");
		System.out.println("Enter 3 to update the email-address");
		int ch = sc.nextInt();
		sc.nextLine();
		String str;
		switch (ch) {
		case 1: {
			System.out.println("Enter updated loginname");
			user.setLoginName(sc.nextLine());
			if (!register.Search(loginname))
				throw new RegisterException("LoginName is Already in use");
			break;
		}
		case 2: {
			System.out.println("Enter updated Phone Number");
			user.setPhoneNo(sc.nextLine());
			if (!user.getPhoneNo().matches("[0-9]{10}"))
				throw new RegisterException("PhoneNumber must be of 10 digits");
			break;
		}
		case 3: {
			System.out.println("Enter updated Email");
			user.setEmail(sc.nextLine());
			if (!user.getEmail().matches(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
				throw new RegisterException("Email Convention is not followed properly");
			break;
		}
		}
		if (update.updateDetails(ch, user))
			System.out.println("Updated Succesfully!!");
		else
			System.out.println("Not Updated!!!");
	}

}
