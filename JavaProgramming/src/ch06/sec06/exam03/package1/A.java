package ch06.sec06.exam03.package1;

public class A {

	//Field
	public int field;
	//Constructor
	 public A(){
		
	}
	
	//Method
	 public void method() {
		 A a = new A();
	 }
	 
	 public static void method2() {
		 A a = new A();
		 a.field = 1;
	 }
	 
	 public void method3() {
		 method();
		 A.method2();
	 }
}
