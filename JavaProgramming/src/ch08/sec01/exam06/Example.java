package ch08.sec01.exam06;

public class Example {

	public static void main(String[] args) {
		Person p1 = new Person(new Television());//인터페이스 매개변수 이므로 
		p1.methodA();
		p1.methodB(new Television());
		
		Person p2 = new Person(new Audio());
		p2.methodA();
		p2.methodB(new Audio());

	}

}
