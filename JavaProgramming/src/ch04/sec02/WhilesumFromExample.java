package ch04.sec02;

public class WhilesumFromExample {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println(sum);

	}

}
