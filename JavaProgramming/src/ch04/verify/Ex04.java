package ch04.verify;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1,num2,num3;
		int result=0;
		
		System.out.println("[입력]");
		System.out.print("시작수: ");
		num1 = Integer.parseInt(scan.nextLine());
		System.out.print("끝수: ");
		num2 = Integer.parseInt(scan.nextLine());
		System.out.print("배수 : ");
		num3 = Integer.parseInt(scan.nextLine());
		
		for(int i = num1; i< num2; i ++ ) {
			if(i%num3 == 0) {
				result+= i;
			}
		}
		
		System.out.println("[출력]");
		System.out.println(result);

	}

}
