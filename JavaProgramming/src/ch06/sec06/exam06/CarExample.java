package ch06.sec06.exam06;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		Car car2 = new Car();
		
		System.out.println(myCar.getCompany());
		
		myCar.setPrice(100000000);
		System.out.println(myCar.getPrice());

		myCar.setStop(true);
		if(myCar.isStop()) {
			System.out.println("멈춥니다.");
		}
		else {
			System.out.println("달립니다.");
		}
		
		
	}
}
