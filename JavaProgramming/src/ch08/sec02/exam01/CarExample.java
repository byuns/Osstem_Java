package ch08.sec02.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.backLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		
		myCar.run();

	}

}
