package assignment;
import java.util.Scanner;

public class Ch03_Ex09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num1,num2;
		double result;
		
		System.out.print("첫 번째 수 : ");
		num1 = scan.nextLine();
		System.out.print("두 번째 수 : ");
		num2 = scan.nextLine();
		
		result = Double.parseDouble(num1) / Double.parseDouble(num2);
		System.out.println("-------------------");
		if(Double.parseDouble(num2) == 0.0) {
			System.out.println("결과 : 무한대");
		}else {
			System.out.println("결과 : "+ result);
		}
	}

}

