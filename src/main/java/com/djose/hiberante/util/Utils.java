package com.djose.hiberante.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    
	/**
	 * 
	 * @param inputDate
	 * @return
	 */
	public static Date formatDate(String inputDate) {

		String date_s = " 2011-01-18 00:00:00.0";
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
		Date date = null;
		try {
			date = dt.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static void printMessage(String message){		
		System.out.println("\033[32m ------" + message +"------"+"\033[0m");		
	}
}
