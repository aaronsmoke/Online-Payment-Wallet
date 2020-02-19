package com.OnlineWallet.bean;

public class WalletHistory {
	private int transactionid;
	private int sender_Accountid;
	private int reciever_Accountid;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public int getSender_Accountid() {
		return sender_Accountid;
	}
	public void setSender_Accountid(int sender_Accountid) {
		this.sender_Accountid = sender_Accountid;
	}
	public int getReciever_Accountid() {
		return reciever_Accountid;
	}
	public void setReciever_Accountid(int reciever_Accountid) {
		this.reciever_Accountid = reciever_Accountid;
	}
	public WalletHistory(int transactionid, int sender_Accountid, int reciever_Accountid) {
		super();
		this.transactionid = transactionid;
		this.sender_Accountid = sender_Accountid;
		this.reciever_Accountid = reciever_Accountid;
	}

}
