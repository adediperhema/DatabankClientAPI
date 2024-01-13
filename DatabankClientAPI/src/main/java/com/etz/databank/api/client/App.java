package com.etz.databank.api.client;

import com.etz.databank.client.model.Account;
import com.etz.databank.client.model.Accounts;
import com.etz.databank.client.node.DBANK;
import com.etz.databank.client.util.FormatFundIDs;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataBankClient client = new DataBankClient();
        Accounts acct = client.getClientInfoByAccount("10");
//        String customer = "{\r\n" + 
//        		"  \"Accounts\": [\r\n" + 
//        		"    {\r\n" + 
//        		"      \"Name\": \"George Cormla Attopany\",\r\n" + 
//        		"      \"NAccount\": \"4000100064850\",\r\n" + 
//        		"      \"OAccount\": \"16745\",\r\n" + 
//        		"      \"CreatedOn\": \"2016-08-02\",\r\n" + 
//        		"      \"FundIds\": [\r\n" + 
//        		"        \"EPACK\",\r\n" + 
//        		"        \"MFUND\"\r\n" + 
//        		"      ]\r\n" + 
//        		"    }\r\n" + 
//        		"  ],\r\n" + 
//        		"  \"Error\": false,\r\n" + 
//        		"  \"Message\": \"status:successful\",\r\n" + 
//        		"  \"Errors\": []\r\n" + 
//        		"}";
//        Accounts acct = new Gson().fromJson(customer, Accounts.class);
        
        if(acct != null) {
        	if(!acct.isError()) {
        		System.out.println(new Gson().toJson(acct));
        		System.out.println("FundIds: "+FormatFundIDs.format(acct.getAccount().getFundIds()));
        	}
        	
        	//System.out.println(acct.getAccount().getName());
        }
        
//        String request = "{\r\n" + 
//        		" \"apiId\":\"xportal\",\r\n" + 
//        		" \"apiSecret\":\"EAE87AA45B443279747E158C6FA5FD2C9DDD49B8BCB2726FEE89F76D679B88BD5599E3E59643EA233454C66\",\r\n" + 
//        		" \"reference\": \"ATUtest004\",\r\n" + 
//        		" \"amount\": \"140.00\",\r\n" + 
//        		" \"product\": \"ATU\",\r\n" + 
//        		" \"action\": \"process\",\r\n" + 
//        		" \"account\": \"10\",\r\n" + 
//        		" \"mobile\":\"233548343909\",\r\n" + 
//        		" \"merchant\": \"KWESEIFLIX\",\r\n" + 
//        		" \"name\": \"EXTERNAL\",\r\n" + 
//        		" \"type\": \"0\",\r\n" + 
//        		" \"type2\": \"null\",\r\n" + 
//        		" \"mode\": \"1\",\r\n" + 
//        		" \"bank\": \"006\",\r\n" + 
//        		" \"client\": \"PAYOUTLET\",\r\n" + 
//        		" \"otherInfo\":\"KWESEIFLIX\"\r\n" + 
//        		"}";
//        DBANK db = new DBANK();
//        String resp = db.query(request);
//        System.out.println(resp);
    }
}
