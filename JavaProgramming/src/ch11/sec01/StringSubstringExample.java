package ch11.sec01;

public class StringSubstringExample {

	public static void main(String[] args) {
		String ssn = "971117-1000000";
		
		String firstNum = ssn.substring(0,6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);

	}

}
