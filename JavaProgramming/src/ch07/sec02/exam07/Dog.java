package ch07.sec02.exam07;

public class Dog extends Mammal{
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
	public void houseProtect() {
		System.out.println("낯선 사람인지 유심히 봅니다.");
	}
}
