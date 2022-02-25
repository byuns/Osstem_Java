package ch10.sec03.exam01;
//일반 예외
public class MyException extends Exception {
	
	public MyException() {}
	
	public MyException(String message) {
		super(message);
	}
}
