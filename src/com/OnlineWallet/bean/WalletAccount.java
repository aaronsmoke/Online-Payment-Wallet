package com.OnlineWallet.bean;

import java.util.ArrayList;
import java.util.List;

public class WalletAccount {
	private int AccountId;
	private double Accountbalance;
	private String status;
	private int UserId;
	List<Integer> TransactionHistory=null;
	
	
	public WalletAccount(int accountId, double accountbalance, String status, int userId) {
		super();
		this.AccountId = accountId;
		this.Accountbalance = accountbalance;
		this.status = status;
		this.UserId = userId;
		this.TransactionHistory = new ArrayList<>();		
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public double getAccountbalance() {
		return Accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		Accountbalance = accountbalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public List<Integer> getTransactionHistory() {
		return TransactionHistory;
	}
	public void setTransactionHistory(List<Integer> transactionHistory) {
		TransactionHistory = transactionHistory;
	}
	@Override
	public String toString() {
		return "WalletAccount [AccountId=" + AccountId + ", Accountbalance=" + Accountbalance + ", status=" + status
				+ ", UserId=" + UserId + ", TransactionHistory=" + TransactionHistory + "]";
	}
	
}
