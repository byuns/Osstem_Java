package ch12.sec01.exam07;

public class MainThreadExample {
	public static void main(String[] args) {
		//공유 객체 생성
		Calculator calc = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calc);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calc);
		user2.start();
	}

}
