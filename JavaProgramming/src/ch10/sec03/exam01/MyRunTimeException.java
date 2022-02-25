package ch10.sec03.exam01;
//실행 예외
public class MyRunTimeException extends RuntimeException {
	public MyRunTimeException() {}
	public MyRunTimeException(String message) {
		super(message);
	}

}
