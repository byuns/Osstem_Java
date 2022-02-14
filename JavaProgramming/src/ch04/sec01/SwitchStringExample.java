package ch04.sec01;

public class SwitchStringExample {

	public static void main(String[] args) {
		String position = "과장";
		
		switch(position) {
			case "부장":
				System.out.println("700만원");
				break;
			case "과장":
				System.out.println("500만원");
				break;
			default:
				System.out.println("300만원");
		}
		float a = 10f;
		float b = a/100;
		System.out.println(b);
		if(b >= 0.1) {
			System.out.println("a");
		}

	}

}
