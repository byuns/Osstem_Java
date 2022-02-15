package ch11.sec01;

public class StringLengthExample {

	public static void main(String[] args) {
		String ssn = "1234451351323";
		int length = ssn.length();
		if(length == 13) {
			System.out.println("주민번호의 자리수가 맞습니다.");
		}
		else {
			System.out.println("주민번호의 자리수가 틀립니다.");
			System.out.println(length);
		}

	}

}
