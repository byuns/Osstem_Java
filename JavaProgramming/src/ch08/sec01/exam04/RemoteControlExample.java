package ch08.sec01.exam04;

public class RemoteControlExample {

	public static void main(String[] args) {
		//인터페이스 타입의 변수 선언
		RemoteControl rc;
		
		//인터페이스를 사용하겠다.
		
		rc = new Television();
		
		rc.turnOn();
		rc.setVolume(10);
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();

	}

}
