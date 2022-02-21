package ch07.sec02.exam06;

public class InstanceofExample {
	
	public static void method1(Parent parent) { // 자동 형변환
		parent.parentMethod();
		if(parent instanceof Child) { // 변환되어 온 parent가 Child 타입으로부터 왔나
			Child child = (Child)parent;
			child.childMethod();
		}
		
	}
	
	public static void main(String[] args) {
//		Parent parent = new Parent();
		method1(new Child());
		method1(new Parent());

	}

}
