package ch07.sec03.exam04;

public class ARobot extends Robot{

	public ARobot(String owner) {
		this.setKind("서빙");
		this.setCompany("우리전자");
		this.setOwner(owner);
	}
	
	
	@Override
	public void move() {
		System.out.println("3개의 바퀴로 움직입니다.");
	}
	@Override
	public void work() {
		System.out.println("음식을 나릅니다.");
	}
	
	public void wash() {
		System.out.println("식기를 닦습니다.");
	}
	
	public void selectMenu() {
		System.out.println("메뉴를 선택합니다.");
	}
	
	
}
