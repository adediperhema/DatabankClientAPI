package com.etz.databank.client.model;

import java.util.ArrayList;

public class Accounts {

	private ArrayList<Account> Accounts;
	private Token token;
	private Account Account;
	private boolean Error;
	private String Message;

	public ArrayList<Account> getAccounts() {
		return Accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		Accounts = accounts;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Account getAccount() {
		return Account;
	}

	public void setAccount(Account account) {
		this.Account = account;
	}

	public boolean isError() {
		return Error;
	}

	public void setError(boolean error) {
		Error = error;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "Accounts [Accounts=" + Accounts + ", token=" + token + ", Account=" + Account + ", Error=" + Error
				+ ", Message=" + Message + "]";
	}

}
