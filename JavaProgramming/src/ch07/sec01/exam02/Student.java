package ch07.sec01.exam02;

public class Student extends People {
	public int studnentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name,ssn); // 고정 값이 아니기 때문에 값을 받아 부모 생성자에 넘겨주어야 한다.
		this.studnentNo = studentNo;
	}
	@Override
	public void work() {
		System.out.println("공부를 합니다.");

	}

}
