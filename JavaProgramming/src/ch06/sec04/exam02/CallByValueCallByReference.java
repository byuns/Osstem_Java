package ch06.sec04.exam02;

public class CallByValueCallByReference {
	//Field
	int field = 10;
	
	//Method
	void method1(int value) {
		value = 20;
	}
	
	void method2(int[] value) {
		value[0] = 20;
	}
	
	void method3(CallByValueCallByReference obj) {
		obj.field = 20;
	}

}
