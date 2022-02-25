package ch11.sec02.exam01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		//현재 컴퓨터의 날짜와 시간을 읽고, LocalDateTime 객체 생성
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		System.out.println(now.format(dtf));
		//덧셈 : 오늘부터 30일 뒤의 날짜는?
		
		LocalDateTime result1 = now.plusDays(30);
		System.out.println(result1.format(dtf));
		System.out.println(result1);
		
		//비교 : 오늘부터 올해의 12월25일까지 남은 일?
		LocalDateTime chrismas = LocalDateTime.of(now.getYear(),12,25,0,0);
		long remainDays = now.until(chrismas,ChronoUnit.DAYS);
		
		System.out.println(remainDays);

	}

}
