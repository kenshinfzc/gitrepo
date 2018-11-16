package com.fzc.javatest.riqi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toString());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = df.format(date);
		System.out.println(date1);
	}

}
