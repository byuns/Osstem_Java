package ch07.sec03.verify;

public class Texi extends PublicTransport{
	public Texi(String name, int money, int time) {
		this.setName(name);
		this.setMoney(money);
		this.setTime(time);
	}
	@Override
	public void payment() {
		System.out.println("택시 요금은 7000원 입니다.");
	}
	
	@Override
	public void runTime() {
		System.out.println("택시 소요 시간은 1시간 입니다.");
	}
	public void sitTogether() {
		System.out.println("일행과 합께 앉아서 갑니다.");
	}

}
