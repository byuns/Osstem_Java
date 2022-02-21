package ch07.sec03.verify;

public class Bus extends PublicTransport{
	
	public Bus(String name, int money, int time) {
		this.setName(name);
		this.setMoney(money);
		this.setTime(time);
	}
	@Override
	public void payment() {
		System.out.println("버스 요금은 3500원 입니다.");
	}
	
	@Override
	public void runTime() {
		System.out.println("버스 소요 시간은 2시간 입니다.");
	}
	public void stand() {
		System.out.println("서서 갑니다.");
	}

}
