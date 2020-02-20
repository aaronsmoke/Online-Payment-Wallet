package com.OnlineWallet.client;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.OnlineWallet.Exception.AddAmountException;
import com.OnlineWallet.Exception.ForgetPasswordException;
import com.OnlineWallet.Exception.FundTransferException;
import com.OnlineWallet.Exception.RegisterException;
import com.OnlineWallet.Exception.UpdateDataException;
import com.OnlineWallet.pl.Home;

public class Client {
	
	public static void main(String[] args) {
		Home home = new Home();
		try {
			home.homeMenu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch( RegisterException e) {
			System.out.println(e.getMessage());
		}catch(SQLException e) {
			//System.out.println(e.getMessage());
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}catch(AddAmountException e)
		{
			System.out.println(e.getMessage());
		}catch(UpdateDataException e) {
			System.out.println(e.getMessage());
		}catch(FundTransferException e) {
			System.out.println(e.getMessage());
		}catch( ForgetPasswordException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
