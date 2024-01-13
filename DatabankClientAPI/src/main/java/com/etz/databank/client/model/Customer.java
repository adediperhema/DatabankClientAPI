package com.etz.databank.client.model;

public class Customer {
	private Account Account;
	private String Error;
	private String Message;
	
	public Account getAccount() {
		return Account;
	}
	public void setAccount(Account account) {
		Account = account;
	}
	public String getError() {
		return Error;
	}
	public void setError(String error) {
		Error = error;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}
