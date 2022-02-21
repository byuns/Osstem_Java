package ch07.sec02.exam03;

public class Tire {
	
	public int maxRotation;
	public int accumulateRotation;
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	public boolean roll() {
		++accumulateRotation;
		if(accumulateRotation < maxRotation) {
			System.out.println(location + " Tire 수명 : " + (maxRotation-accumulateRotation) + "회 ");
			return true;
		}else {
			System.out.println("***" + location + " Tire 펑크 ***");
			return false;
		}
	}

}
