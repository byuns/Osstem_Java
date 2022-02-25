package ch10.sec03.exam01;

public class ThrowExample {

	public static void main(String[] args) {
		try {
			method1(-1);
		}catch(MyException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.toString());
			e.printStackTrace();
		}
		try {
			method2(2);
		}catch(MyRunTimeException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void method1(int value) throws MyException {
		//예외 발생 코드
		if(value <0)
			throw new MyException("예외 발생 이유입니다.(~한 이유 때문에~)");
		
	}
	public static void method2(int value) throws MyRunTimeException{
		if(value > 0)
			throw new MyRunTimeException("~한 이유 때문에 예외 발생");
	}

}
