package ch14.sec03.exam02;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int value = Integer.parseInt(scanner.nextLine());
			String str = scanner.nextLine();
			System.out.println(value + " : " + str);
		}
		
		//scanner.close();

	}

}
