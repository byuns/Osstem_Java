package ch02.sec03;

public class ByteOperationExample {
	public static void main(String args[]) {
		byte result = 10 + 20; //컴파일 단계에서 변환가능하거나 계산 가능한 것은 가능하다
		System.out.println(result);
		
		byte x = 10;
		byte y = 20;
		int result2 = x + y; //모든 타입 연산은 int 타입으로 변환된다. 
		System.out.println(result);
		
		int a = 1;
		int b = 2;
		double c = a / b;
		System.out.println(c);
	}

}
