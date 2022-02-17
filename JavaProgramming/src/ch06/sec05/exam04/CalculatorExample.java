package ch06.sec05.exam04;

public class CalculatorExample {

	public static void main(String[] args) {
		//Field 값 읽기
		
		Calculator cal1 = new Calculator();
		Calculator cal2 = new Calculator();
		//각각 객체의 메모리의 값을 설정
		cal1.memory = 100;
		cal2.memory = 200;
		
		System.out.println("cal1.memory = "+cal1.memory);
		System.out.println("cal2.memory = "+cal2.memory);
		
		//정적 필드 값 설정
		cal1.color = "검정"; // 올바르지 않은 코드
		cal2.color = "빨강"; // 올바르지 않은 코드
		
		System.out.println(cal1.color); 
		System.out.println(cal2.color);
		
		cal1.print("안녕1"); // 올바르지 않은 코드
		cal2.print("안녕"); // 올바르지 않은 코드
		Calculator.print("안녕하세요"); // 올바른 코드
	}

}
