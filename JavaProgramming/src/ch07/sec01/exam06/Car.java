package ch07.sec01.exam06;

public class Car {
	public int speed;
	
	public void speedUp() {speed += 1;}
	
	public void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}

}
