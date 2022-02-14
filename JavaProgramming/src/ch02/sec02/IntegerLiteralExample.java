package ch02.sec02;

public class IntegerLiteralExample {

	public static void main(String[] args) {
		//정수 타입 변수 선언
		byte	 var1 = 10; // -128~127
		short	 var2 = 100; // ~
		char	 var3 = 44032;
		int		 var4; //~+-21억
		long	 var5 = 30000000000l; // 'l'or'L'을 뒤에 작성
		
		System.out.println("var3 : " + var3);
		
		//다앙한 숫자 리터럴
		byte var6 = 0b1011;
		System.out.println("var6 : " + var6);
		
		int var7 = 'A';
		System.out.println("var7 : " + var7);
		
		//String 문자열 타입 변수 선언
		String name = "홍길동";
		String job = "프로그래머";
		
		System.out.println("name : " + name);
		System.out.println("job : " + job);
		

	}

}
