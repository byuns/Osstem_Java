package ch11.sec02.exam01;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateExample {

	public static void main(String[] args) {
		
		Date now = new Date();
		System.out.println(now.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a");
		System.out.println(sdf.format(now));
	}
}
