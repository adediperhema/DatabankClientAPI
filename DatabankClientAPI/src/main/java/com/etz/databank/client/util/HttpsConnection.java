package com.etz.databank.client.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class HttpsConnection {

	static {
		System.setProperty("java.net.useSystemProxies", "true");
		javax.net.ssl.HttpsURLConnection
				.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

					public boolean verify(String hostname,
					javax.net.ssl.SSLSession sslSession) {
						return true;
					}
				});
	}

//	public static void main(String[] args) {
//		try {
//			String response = new HttpsConnection().sendPostRequest("{\r\n" + 
//					"  \"AccountNumber\": \"6090111368\",\r\n" + 
//					"  \"Mobile\": \"0246583910\"\r\n" + 
//					"}", "https://192.168.5.7:8043/api/ZenithCustomer/IsBankCustomer");
//			System.out.println(response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public String sendPostRequest(String sendUrl, String method, String request) throws Exception {

		StringBuffer sbf = new StringBuffer();
		HttpsURLConnection urlConnection = null;
		FileInputStream fis = null;
		try {
			String trustStorePath = "C:\\zenith\\keystore\\zenith.jks";
			String password = "123456";
			KeyStore keyStore = KeyStore.getInstance("JKS");
			fis = new FileInputStream(trustStorePath);
			keyStore.load(fis, password.toCharArray());
			String algorithm = TrustManagerFactory.getDefaultAlgorithm();
			TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
			tmf.init(keyStore);
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, tmf.getTrustManagers(), null);
			URL requestedUrl = new URL(null, sendUrl,new sun.net.www.protocol.https.Handler());
			urlConnection = (HttpsURLConnection) requestedUrl.openConnection();
			urlConnection.setSSLSocketFactory(context.getSocketFactory());
			urlConnection.setRequestMethod("GET");
			urlConnection.setUseCaches(false);
			urlConnection.setRequestProperty("content-type", "application/json");
			urlConnection.setRequestProperty("Authorization", DataBankConfig.getValue("AUTH").trim());
			urlConnection.setRequestProperty("Token", DataBankConfig.getValue("TOKEN_URL").trim());
			urlConnection.setConnectTimeout(30000);
			urlConnection.setReadTimeout(0);
			urlConnection.setRequestProperty("Connection", "Close");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(false);
			urlConnection.connect();
			
            if(method.equalsIgnoreCase("POST")) {
            	urlConnection.setRequestMethod("POST");
            	urlConnection.setDoOutput(true);
    			urlConnection.setDoInput(true);
            	OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream());
    			BufferedWriter buffWriter = new BufferedWriter(osw);
    			buffWriter.write(request.toString());
    			buffWriter.flush();
    			buffWriter.close();
    			osw.close();
            }
		} catch (Exception e) {
			System.out.println("Caught Exception while creating the output stream "+ e);
			throw e;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					System.out.println("Caught Exception while closing FileInputStream: "+ e);
					throw e;
				}
			}
		}

		try {
			InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
			BufferedReader buffRead = new BufferedReader(isr);
			String strResponse = null;
			while ((strResponse = buffRead.readLine()) != null) {
				sbf.append(strResponse);
				sbf.append("\n");
			}
			buffRead.close();
			isr.close();
			urlConnection.disconnect();
		} catch (Exception e) {
			System.out.println("Caught Exception while creating the input stream"+ e);
			throw e;
		}
		return sbf.toString();
	}

}
