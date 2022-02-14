package ch02.sec04;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		String inputData;
		while(true) {
			System.out.print("입력: ");
			inputData = Scanner.nextLine();
			System.out.println("입력된 문자열 : \"" + inputData + "\"");
			if(inputData.equals("q")) {
				break;
			}
		}
		System.out.println("q를 입력했습니다. \n프로그램을 종료합니다.");
	}

}
