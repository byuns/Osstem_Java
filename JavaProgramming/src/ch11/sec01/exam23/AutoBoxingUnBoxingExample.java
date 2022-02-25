package ch11.sec01.exam23;

public class AutoBoxingUnBoxingExample {

	public static void main(String[] args) {
		
		Integer obj = 100;
		System.out.println("value : " + obj);
		
		int value = obj;
		System.out.println("value : " + value);
		
		int result = value;
		System.out.println("result : " + result);
	}	
}
