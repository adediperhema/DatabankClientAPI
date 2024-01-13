package com.etz.databank.client.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TokenGenerator {

	public static void main(String[]args) {
	
	
	
	}	
	
	public String DateConverter(String date_converter) {
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
		//LocalDate date = LocalDate.parse("2018-04-10T04:00:00.000Z", inputFormatter);
		LocalDate date = LocalDate.parse(date_converter, inputFormatter);
		String formattedDate = outputFormatter.format(date);
		System.out.println(formattedDate); // prints 10-04-2018
		
		return null;
		
		
	}
	
	
	public String tokenGenerator() {
		
		
		
	
		return null;
		
		
	}
}
