package ch02.sec04;

public class KeyCodeExample {

	public static void main(String[] args) throws Exception {
		//변수 선언
		int keyCode;
		
		//키보드로부터 입력된 키 하나를 읽기
		keyCode = System.in.read();
		System.out.println(keyCode);
		
		keyCode = System.in.read();
		System.out.println(keyCode);
		
		keyCode = System.in.read();
		System.out.println(keyCode);

	}

}
