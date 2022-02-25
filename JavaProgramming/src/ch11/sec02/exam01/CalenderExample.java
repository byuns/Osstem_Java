package ch11.sec02.exam01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalenderExample {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; // 0~11 + 1
		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + " " + month + " " + day);
	}
}
