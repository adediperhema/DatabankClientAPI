package com.etz.databank.client.node;

import java.util.Map;

import org.apache.log4j.Logger;

import com.etz.databank.api.client.DataBankClient;
import com.etz.databank.client.model.Accounts;
import com.etz.databank.client.util.FormatFundIDs;
import com.etz.vas.host.VASNode;
import com.google.gson.Gson;

public class DBANK extends VASNode {

//	private Logger log = configure("DBANK");
	private Logger log = Logger.getLogger(DBANK.class.getSimpleName());

	public Logger getLog() {
		return log;
	}

	public static void main(String[] args) {
		String json = "{\"account\":\"4000100138312\"}";
		System.out.println(new DBANK().query(json));
	}

	@Override
	public String query(String jsonData) {
		this.log.info(":: QUERY RECEIVED:: " + jsonData);
		Map<String, String> jmap = null;
		String retData = "";
		try {
			jmap = (Map) new Gson().fromJson(jsonData, Map.class);

			String accountNumber = (String) jmap.get("account");
			// String phoneNumber = (String)jmap.get("mobile");

			DataBankClient client = new DataBankClient();
			Accounts account = client.getClientInfoByAccount(accountNumber);

			if (account != null) {
				this.log.info(":: QUERY RETURNED:: " + new Gson().toJson(account));
				if (!account.isError()) {
					jmap.put("error", "00");
					jmap.put("fault",
							account.getAccount().getName() + "#" + account.getAccount().getNAccount() + "#"
									+ account.getAccount().getOAccount() + "#"
									+ FormatFundIDs.format(account.getAccount().getFundIds()));
					this.log.info(new Gson().toJson(account));
				} else {
					jmap.put("error", "05");
					jmap.put("fault", account.getMessage() + "=>Error: " + account.isError());
					this.log.info("DataBank Query=>" + account.getMessage() + "=>Error: " + account.isError());
				}
			} else {
				jmap.put("error", "06");
				jmap.put("fault", "Error processing request. DataBank null response");
			}
			retData = new Gson().toJson(jmap);
			this.log.info(":: QUERY RETURNED:: " + retData);
		} catch (Exception e) {
			e.printStackTrace();
			this.log.info(e.getMessage());
			jmap.put("error", "06");
			jmap.put("fault", "Error processing request." + e.getMessage());
			retData = new Gson().toJson(jmap);
			this.log.info(":: QUERY RETURNED:: " + retData);
		}
		return retData;
	}

	@Override
	public String process(String arg0) {
		throw new UnsupportedOperationException();
	}

}
