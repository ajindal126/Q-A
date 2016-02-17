package com.misc;

import java.util.Date;

public class DateTimeStamp {

	public String dateTime()
	{
		Date dt=new Date();
		return dt.toLocaleString();
	}
	public static void main(String[] args) {
	DateTimeStamp dts=new DateTimeStamp();
	String s=dts.dateTime();
    System.out.println(s);
	}

}
