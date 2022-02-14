package ch04.sec01;

public class IfDiceExample {

	public static void main(String[] args) {
		
//		double num1 = Math.random(); // 0.0 <= ~ <1.0
//		System.out.println(num1);
//		
//		// *10
//		num1 *= 6;
//		System.out.println(num1);
//		
//		int num2 = (int)num1;
//		
//		num2 += 1;
//		System.out.println(num2);
//		
//		int num3 = (int)(Math.random()*6) + 1;
//		System.out.println(num3);
		
		int num = (int)(Math.random()*100) + 1;
		
		if(num%2 == 0) {
			System.out.println("난수 값은 " + num + "이므로 짝수 입니다.");
		}
		else {
			System.out.println("난수 값은 " + num + "이므로 홀수 입니다.");
			
		}
		
	
		
	}

}
