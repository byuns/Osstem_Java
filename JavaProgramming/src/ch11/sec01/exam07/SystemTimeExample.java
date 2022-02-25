package ch11.sec01.exam07;

import java.util.*;

public class SystemTimeExample {

	public static void main(String[] args) {
		
		long time1 = System.currentTimeMillis();
		
		int sum = 0;
		for(int i=1; i<1000000; i++) {
			sum += i;
		}
		long time2 = System.currentTimeMillis();
		
		System.out.println("합 : " + sum);
		System.out.println((time2 - time1)/1000.0);
		
	}

}
