package ch06.sec04.exam02;

public class CallByValueCallByReferenceExample {

	public static void main(String[] args) {
		
		CallByValueCallByReference obj = new CallByValueCallByReference();
		
		//CallByValue
		int value = 10;
		obj.method1(value);
		System.out.println(value);
		
		//CallByvalue
		int[] array = {10};
		obj.method2(array);
		System.out.println(array[0]);
		
		obj.method3(obj);
		System.out.println(obj.field);
		

	}

}
