package ch07.sec03.exam04;

public abstract class Robot {
	private String kind;
	private String company;
	private String owner;
	

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void powerOn() {
		System.out.println("전원을 넣습니다.");
	}
	
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	public abstract void move();
	
	public abstract void work();
	


}
