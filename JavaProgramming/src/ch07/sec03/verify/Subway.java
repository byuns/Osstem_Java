package ch07.sec03.verify;

public class Subway extends PublicTransport{
	public Subway(String name, int money, int time) {
		this.setName(name);
		this.setMoney(money);
		this.setTime(time);
	}
	@Override
	public void payment() {
		System.out.println("지하철 요금은 2500원 입니다.");
	}
	
	@Override
	public void runTime() {
		System.out.println("지하철 소요 시간은 3시간입니다.");
	}
	
	public void sit() {
		System.out.println("앉아서 갑니다.");
	}

}
