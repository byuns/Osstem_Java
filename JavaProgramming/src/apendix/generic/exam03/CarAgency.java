package apendix.generic.exam03;

public class CarAgency implements Rentable <Car> {
	
	@Override
	public Car rent() {
		return new Car();
	}

}
