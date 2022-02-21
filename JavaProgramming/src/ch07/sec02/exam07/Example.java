package ch07.sec02.exam07;

public class Example {

	public static void method1(Animal animal) {
		animal.sound();
	}
	public static void method2(Mammal mammal) {
		mammal.grow();
		
		if(mammal instanceof Dog) {
			Dog dog = (Dog)mammal;
			dog.houseProtect();
		}
	}
	public static void method3(Dog dog) {
		dog.sound();
		dog.grow();
		dog.houseProtect();
	}
	
	public static void main(String[] args) {
		
		method1(new Animal());
		method1(new Mammal());
		method1(new Dog());
		method1(new Cat());
		
		method2(new Mammal());
		method2(new Dog());
		method2(new Cat());
		
		method3(new Dog());
	}

}
