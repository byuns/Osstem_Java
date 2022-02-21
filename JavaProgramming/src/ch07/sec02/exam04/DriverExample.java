package ch07.sec02.exam04;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Texi texi = new Texi();
		Bicycle bicycle = new Bicycle();
		
		driver.drive(bus);
		driver.drive(texi);
		driver.drive(bicycle);

	}

}
