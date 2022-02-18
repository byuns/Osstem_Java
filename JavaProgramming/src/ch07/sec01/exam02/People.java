package ch07.sec01.exam02;

public class People {
	//Field
	public String name;
	public String ssn;
	
	public People() {
		System.out.println("People()");
	}
	//Constructor
	public People(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		System.out.println("People(String name, String ssn, int studentNo)");
	}
	public void work() {
		System.out.println("일을 합니다.");
	}
}
