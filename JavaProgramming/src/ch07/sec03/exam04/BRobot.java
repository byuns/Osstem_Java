package ch07.sec03.exam04;

public class BRobot extends Robot{
	
	
	public BRobot(String owner) {
		this.setKind("전투");
		this.setCompany("국방전자");
		this.setOwner(owner);
	}
	
	@Override
	public void move() {
		System.out.println("무한궤도로 움직입니다.");
	}
	@Override
	public void work() {
		System.out.println("전투를 합니다.");
	}
	
	public void shoot() {
		System.out.println("미사일을 쏩니다.");
	}
	
	public void fire() {
		System.out.println("불을 쏩니다.");
	}
	
	

}
