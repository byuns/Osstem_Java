package ch04.sec02;

public class ForPrintExample {

	public static void main(String[] args) {
		int sum = 0 ;
		
		for(int i = 3; i<=100; i += 3) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		
	}

}
