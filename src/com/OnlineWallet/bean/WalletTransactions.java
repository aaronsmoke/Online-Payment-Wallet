package com.OnlineWallet.bean;

import java.sql.Time;
import java.util.Date;

public class WalletTransactions {
	private int TransactionId;
	private String Description;
	private Date DateOfTransaction;
	private Time TimeOfTransaction;
	private double Amount;
	private double ClosingAccountBalance;

	public WalletTransactions(int transactionId, String description,Date DateofTransaction,Time time,double amount, double closingAccountBalance) {
		super();
		TransactionId = transactionId;
		Description = description;
		this.DateOfTransaction = DateOfTransaction;
		this.TimeOfTransaction=time;
		Amount = amount;
		ClosingAccountBalance = closingAccountBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ClosingAccountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((DateOfTransaction == null) ? 0 : DateOfTransaction.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + TransactionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WalletTransactions other = (WalletTransactions) obj;
		if (Double.doubleToLongBits(Amount) != Double.doubleToLongBits(other.Amount))
			return false;
		if (Double.doubleToLongBits(ClosingAccountBalance) != Double.doubleToLongBits(other.ClosingAccountBalance))
			return false;
		if (DateOfTransaction == null) {
			if (other.DateOfTransaction != null)
				return false;
		} else if (!DateOfTransaction.equals(other.DateOfTransaction))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (TransactionId != other.TransactionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WalletTransactions [TransactionId=" + TransactionId + ", Description=" + Description
				+ ", DateOfTransaction=" + DateOfTransaction + ", Amount=" + Amount + ", ClosingAccountBalance="
				+ ClosingAccountBalance + "]";
	}

	public int getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDateOfTransaction() {
		return DateOfTransaction;
	}

	public Time getTimeOfTransaction() {
		return TimeOfTransaction;
	}

	public void setTimeOfTransaction(Time timeOfTransaction) {
		TimeOfTransaction = timeOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getClosingAccountBalance() {
		return ClosingAccountBalance;
	}

	public void setClosingAccountBalance(double closingAccountBalance) {
		ClosingAccountBalance = closingAccountBalance;
	}

}
