package com.etz.databank.client.model;

public class Token {
	
	private String Token;
	private String IssuedOn;
	private String ExpiresOn;
	
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public String getIssuedOn() {
		return IssuedOn;
	}
	public void setIssuedOn(String issuedOn) {
		IssuedOn = issuedOn;
	}
	public String getExpiresOn() {
		return ExpiresOn;
	}
	public void setExpiresOn(String expiresOn) {
		ExpiresOn = expiresOn;
	}
	
	
}
