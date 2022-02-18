package ch06.sec06.exam06;

public class Car {
	private static String company = "현대 자동차";
	
	public static String getCompany() { // 인스턴스 필드를 사용하지 않을 경우 static을 선언하여 사용
		return Car.company;
	}
	
	//------------------------------------
	
	private int price;
	
	public int getPrice() {
		int won = price * 1000;
		return price;
	}
	
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	
	//------------------------------------
	private boolean stop;
	
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
