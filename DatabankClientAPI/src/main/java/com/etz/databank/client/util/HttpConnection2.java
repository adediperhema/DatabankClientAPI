package com.etz.databank.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection2 {
	
	private HttpURLConnection con = null;
	private URL url = null;
	private OutputStreamWriter osWriter = null;
	private InputStreamReader isReader = null;
	private BufferedReader reader = null;

	public String sendPostRequest(String url, String httpMethod, String requestBody) {
		
		try {
			this.url = new URL(url);
			this.con = (HttpURLConnection)this.url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		String inputLine;
		StringBuilder response = new StringBuilder();
		
		try {
			
			this.con.setRequestProperty("Content-Type", "application/json");
			this.con.setRequestProperty("Authorization", DataBankConfig.getValue("AUTH").trim());
			this.con.setRequestProperty("Token", DataBankConfig.getValue("TOKEN").trim());
			
			if(httpMethod.equalsIgnoreCase("GET")) {
				this.con.setRequestMethod("GET");
				this.con.setDoOutput(false);
				this.con.setDoInput(true);
			}
			else {
				this.con.setRequestMethod("POST");
				this.con.setDoOutput(true);
				this.con.setDoInput(true);

				this.osWriter = new OutputStreamWriter(con.getOutputStream());
				this.osWriter.write(requestBody);
				this.osWriter.flush();
				this.osWriter.close();
			}
			
			if(this.con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//reading the response
				this.isReader = new InputStreamReader(this.con.getInputStream());
				this.reader = new BufferedReader(this.isReader);
				
				while((inputLine = this.reader.readLine()) != null) {
					response.append(inputLine);
				}
				return response.toString();
			}
			else {
//				throw new RuntimeException("Request Failed : HTTP error code : "
//						+ con.getResponseCode());
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			//close connections
			if (this.isReader != null) {
		        try {
		        	this.isReader.close();
		        } catch (IOException e) {
		        }
		    }
			if (this.osWriter != null) {
		        try {
		        	this.osWriter.close();
		        } catch (IOException e) {
		        }
		    }
		    if (this.con != null) {
		        this.con.disconnect();
		    }
		}
		
	}

}
