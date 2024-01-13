package com.etz.databank.api.client;

import com.etz.databank.client.model.Accounts;
import com.etz.databank.client.util.DataBankConfig;
import com.etz.databank.client.util.HttpConnection2;
import com.google.gson.Gson;

public class DataBankClient {

	private static final String QNAME_URL = DataBankConfig.getValue("QNAME_URL").trim();
	private static final String QACCOUNT_URL = DataBankConfig.getValue("QACCOUNT_URL").trim();
	private static final String TOKEN_URL = DataBankConfig.getValue("TOKEN_URL").trim();

	public Accounts getClientInfoByAccount(String accountNumber) {
		String qNUrl = QACCOUNT_URL.replaceAll("<AccountNumber>", accountNumber);
		System.out.println(qNUrl);

		try {
			HttpConnection2 http = new HttpConnection2();
			String respData = http.sendPostRequest(qNUrl, "GET", null);
//			String respData = "{\"Account\":{\"Name\":\"Dominic Adamnor  Nartey\",\"NAccount\":\"4000100138312\",\"OAccount\":\"000054801\",\"CreatedOn\":\"8/2/2016\",\"PhoneNumber\":\"0244451855\",\"FundIds\":[\"EPACK\"]},\"Error\":false,\"Message\":\"status:successful\"}";
//			String respData = "{\"Account\":{\"Name\":\"Databank Housing Account T2\",\"NAccount\":\"6000197169528\",\"OAccount\":\"\",\"CreatedOn\":\"8/25/2021\",\"PhoneNumber\":\"0302610610           \",\"FundIds\":[]},\"Error\":false,\"Message\":\"status:successful\"}";
			if (respData != null) {
				return new Gson().fromJson(respData, Accounts.class);
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Accounts getClientInfoByName(String accountName) {
		String qNUrl = QNAME_URL.replaceAll("<NAME>", accountName);

		try {
			HttpConnection2 http = new HttpConnection2();
			String respData = http.sendPostRequest(qNUrl, "GET", null);

			if (respData != null) {
				return new Gson().fromJson(respData, Accounts.class);
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Accounts generateToken() {

		try {
			HttpConnection2 http = new HttpConnection2();
			String respData = http.sendPostRequest(TOKEN_URL, "GET", null);

			if (respData != null) {
				return new Gson().fromJson(respData, Accounts.class);
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
