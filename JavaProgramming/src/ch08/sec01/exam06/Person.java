package ch08.sec01.exam06;

public class Person {
	//Field
	private RemoteControl rc;
	
	//Constructor
	public Person(RemoteControl rc) {
		this.rc = rc;
	}
	
	//Method
	public void methodA() {
		this.rc.turnOn();
		this.rc.setVolume(10);
		this.rc.turnOff();
	}
	
	public void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
	}

}
