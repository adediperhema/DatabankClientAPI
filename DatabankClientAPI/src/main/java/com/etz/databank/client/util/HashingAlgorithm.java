package com.etz.databank.client.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class HashingAlgorithm {

	public static String getMD5(String rawString) {

		String generatedMD5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(rawString.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedMD5 = sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return generatedMD5;
	}

	public static String getBasicAuth(String username, String password) {

		Base64 obj = null;
		String toEncodeString = null;
		String encodedString = null;

		try {
			obj = new Base64();
			toEncodeString = username+":"+password;
			encodedString = "Basic "+new String(obj.encode(toEncodeString.getBytes()));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return encodedString;
	}

	public static String formatPhoneNumber(String phoneNumber) {

		String noPrefix = "";
		String mobile = null;
		if(phoneNumber.startsWith("233")) {
			noPrefix = phoneNumber.substring(3, phoneNumber.length());
			if(!noPrefix.startsWith("0")) {
				if(noPrefix.matches("[0-9]{9}")) {
					mobile = phoneNumber;
				}
			}
		}
		else if(phoneNumber.startsWith("0")) {
			noPrefix = phoneNumber.substring(1, phoneNumber.length());
			if(!noPrefix.startsWith("0")) {
				if(noPrefix.matches("[0-9]{9}")) {
					mobile = "233"+noPrefix;
				}
			}
		}
		else if(phoneNumber.startsWith("+233")) {
			noPrefix = phoneNumber.substring(4, phoneNumber.length());
			if(!noPrefix.startsWith("0")) {
				if(noPrefix.matches("[0-9]{9}")) {
					mobile = "233"+noPrefix;
				}
			}
		}
		else if(!phoneNumber.startsWith("0")) {
			if(phoneNumber.matches("[0-9]{9}")) {
				mobile = "233"+phoneNumber;
			}
		}
		return mobile;
	}
	
	public static void main(String[] args) {
		//System.out.println(HashingAlgorithm.getBasicAuth("Tranzact1","YouarelovE0923"));
//		String formattedPhone = formatPhoneNumber("+233242954560");
//		if(formattedPhone != null) {
//			System.out.println("Formatted Phone number => "+formattedPhone);
//		}
//		else {
//			System.out.println("Incorrect Phone Number!");
//		}
	}

}
