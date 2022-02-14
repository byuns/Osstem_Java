package ch02.verify;
import java.util.Scanner;
public class Exam03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name,num,phone;
		
		
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름 : ");
		name = scanner.nextLine();
		System.out.print("2. 주민번호 앞 6자리 : ");
		num = scanner.nextLine();
		System.out.print("3. 전화번호 : ");
		phone = scanner.nextLine();
		

		System.out.println("\n[입력한 내용]");
		System.out.println(name);
		System.out.println(num);
		System.out.println(phone);
	

	}

}
