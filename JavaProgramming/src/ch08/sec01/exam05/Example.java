package ch08.sec01.exam05;

public class Example {

	public static void main(String[] args) {
		//인터페이스 변수 선언
		RemoteControl remoteControl = null;
		Searchable searchable = null;
		
		//인터페이스 SmartTelevsion
		SmartTelevision st = new SmartTelevision();
		
		remoteControl = st;
		
		
		//인터페이스 사용
		remoteControl.turnOn();
		remoteControl.setVolume(5);
		remoteControl.turnOff();
		
		searchable = st;
		searchable.search("www.naver.com");
		

	}

}
