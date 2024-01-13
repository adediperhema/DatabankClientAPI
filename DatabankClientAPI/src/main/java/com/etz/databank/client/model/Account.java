package com.etz.databank.client.model;

public class Account {
	
	private String Name;
	private String NAccount;
	private String OAccount;
	private String CreatedOn;
	private String PhoneNumber;
	private Object[] FundIds;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNAccount() {
		return NAccount;
	}
	public void setNAccount(String nAccount) {
		NAccount = nAccount;
	}
	public String getOAccount() {
		return OAccount;
	}
	public void setOAccount(String oAccount) {
		OAccount = oAccount;
	}
	public String getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Object[] getFundIds() {
		return FundIds;
	}
	public void setFundIds(Object[] fundIds) {
		FundIds = fundIds;
	}
	
}
