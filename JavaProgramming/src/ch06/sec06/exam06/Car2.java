package ch06.sec06.exam06;

public class Car2 {
	private static String company = "현대 자동차";
	private int price;
	private boolean stop;
	
	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		Car2.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	
	

}
