package ch07.sec03.verify;

public abstract class PublicTransport {
	private String name;
	private int money;
	private int time;
	
	public void take() {
		System.out.println("탑승합니다.");
	}
	public void getOff() {
		System.out.println("하차합니다.");
	}
	public abstract void payment();
	public abstract void runTime();
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
