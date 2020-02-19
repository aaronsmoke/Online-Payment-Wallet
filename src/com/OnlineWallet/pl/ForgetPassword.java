package com.OnlineWallet.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.OnlineWallet.DAO.ForgetPasswordDAO;
import com.OnlineWallet.Exception.ForgetPasswordException;

public class ForgetPassword {
	Scanner scan = null;
	ForgetPasswordDAO forget =null;
	private String email;
	private String phoneno;
	private String pass,cpass;

	public void Forgot() throws SQLException, ForgetPasswordException {
		scan=new Scanner(System.in);
		forget = new ForgetPasswordDAO();
		System.out.print("Enter Registered Email-Address:  ");
		email = scan.nextLine();
		System.out.println();
		System.out.println();
		System.out.print("Enter Registered Phone Number:  ");
		phoneno = scan.nextLine();
		System.out.println();
		System.out.println();
		if(forget.Search(email, phoneno)!=null)
		{
			System.out.println("Hello "+forget.Search(email, phoneno)+" !!!");
			System.out.println();
			System.out.print("Please Enter new Password:  ");
			pass = scan.nextLine();
			System.out.println();
			System.out.print("Confirm Password:  ");
			cpass = scan.nextLine();
			if(pass.equals(cpass))
			{
				if(forget.UpdatePass(email, phoneno, pass))
					System.out.println("Password Updated Succesfully");
				else
					System.out.println("Password is not updated!!");
			}
			else
				throw new ForgetPasswordException("Password and Confirm Password do not match!!!......Please enter same password in both....");
		}
		
	}
}
