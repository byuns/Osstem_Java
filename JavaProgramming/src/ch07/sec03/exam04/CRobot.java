package ch07.sec03.exam04;

public class CRobot extends Robot{
	
	public CRobot(String owner) {
		this.setKind("안내");
		this.setCompany("국민전자");
		this.setOwner(owner);
	}

	@Override
	public void move() {
		System.out.println("4개의 바퀴로 움직입니다.");
	}
	@Override
	public void work() {
		System.out.println("건물 내부를 안내합니다.");
	}
	
	public void speak() {
		System.out.println("대화를 합니다.");
	}

}
