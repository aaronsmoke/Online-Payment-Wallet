package com.OnlineWallet.pl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.OnlineWallet.DAO.AdminDAO;
import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.ForgetPasswordException;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.bean.User;

public class AdminMenu {
	Scanner sc = null;
	AdminDAO admin = null;
	HashMap<Integer,User> hashmap=null;
	User user=null;
	

	public void Display() throws RegisterException, SQLException, InterruptedException, AddAmountException, FileNotFoundException, UpdateDataException, FundTransferException, ForgetPasswordException {
		sc = new Scanner(System.in);
		admin = new AdminDAO();
		System.out.println("Press 1 for  view Verified customers");
		System.out.println("Press 2 for unverified customers");
		System.out.println("Press 3 for logout");
		System.out.flush();
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
                 hashmap = admin.verified_users();
                 new AdminMenu().viewHashmap(hashmap);
                 
                 break;
		}
		case 2: {
			hashmap=admin.unverified_users();
			new AdminMenu().viewHashmap2(hashmap);

		}
		case 3: {
			new Home().homeMenu();
			break;
		}
		}

	}
	public void viewHashmap(HashMap<Integer,User> hos)
	{
		Set<Integer> set1 = hos.keySet();
		System.out.println("Wallet ID   UserId   UserName   UserPhone   UserEmail");
		for(Integer key:set1)
		{
			user = hos.get(key);
			System.out.println(key+"   "+user.getId()+"   "+user.getUserName()+"   "+user.getPhoneNo()+"   "+user.getEmail());
		}
	}
	public void viewHashmap2(HashMap<Integer,User> hos) throws SQLException
	{
		Set<Integer> set1 = hos.keySet();
		char ch;
		sc = new Scanner(System.in);
		admin = new AdminDAO();
		System.out.println("UserId   UserName   UserPhone   UserEmail    LoginName");
		for(Integer key:set1)
		{
			user = hos.get(key);
			System.out.println(key+"   "+user.getUserName()+"   "+user.getPhoneNo()+"   "+user.getEmail()+"    "+user.getLoginName());
			System.out.println("Enter A/a for approval!!!\n Press any key to Reject\n");
			ch  = sc.next().charAt(0);
			if(ch=='A'||ch=='a')
			{
				if(admin.Adminappprove(ch, user,key))
					System.out.println("Approved By admin!!");
				else
					System.out.println("Approval fail!!");
			}
			else
			{
				if(admin.Adminappprove(ch, user,key))
					System.out.println("DisApproved By admin!!");
				else
					System.out.println("DisApproval fail!!");	
			}
		}
	}

}
