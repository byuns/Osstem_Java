package ch07.sec02.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child;
		parent.method();
		parent.method2();
//		parent.metho3(); // 호출 불가능(부모에 정의가 안 되어있다.)

	}

}
