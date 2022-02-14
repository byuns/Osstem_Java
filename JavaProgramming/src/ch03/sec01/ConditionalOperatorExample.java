package ch03.sec01;

public class ConditionalOperatorExample {
	public static void main(String args[]) {
		int score = 75;
		char grade = (score>80) ? 'A' : ((score>70) ? 'B' : 'C');
		System.out.println(grade);
	}

}
