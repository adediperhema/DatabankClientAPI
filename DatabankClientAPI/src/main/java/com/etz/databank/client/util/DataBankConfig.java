package com.etz.databank.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBankConfig {
	
	public static String getValue(String key) {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			//input = new FileInputStream("D:\\vasGate\\bin\\cfg\\DataBank.properties");
			input = new FileInputStream(new File("cfg/DataBank.properties"));
			prop.load(input);
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getChannelCode(String channel)
	{
		String response;
		if ((channel.equalsIgnoreCase("Payoutlet")) || (channel.equalsIgnoreCase("webconnectplus")))
		{
			response = "01";
		}
		else if ((channel.equalsIgnoreCase("MobileGate")) || (channel.equalsIgnoreCase("Smsinterface")) || (channel.equalsIgnoreCase("billprocessor")))
		{
			response = "02";
		}
		else if (channel.equalsIgnoreCase("POS"))
		{
			response = "03";
		}
		else if (channel.equalsIgnoreCase("POS"))
		{
			response = "03";
		}
		else if (channel.equalsIgnoreCase("Console"))
		{
			response = "05";
		}
		else if ((channel.equalsIgnoreCase("FundGate")) || (channel.equalsIgnoreCase("FundGatePlus"))) {
			response = "09";
		}
		else {
			response = "99";
		}

		return response;
	}

}
