package ch04.sec01;

public class IfElseExample {
	public static void main(String args[]) {
		int score = 79;
		
		if(score >= 90) {
			System.out.println("점수가 90점보다 높습니다.");
			System.out.println("등급은 A입니다.");
		}
		else if(score >= 80) {
			System.out.println("점수가 80점보다 높습니다.");
			System.out.println("등급은 B입니다.");
		}
		else if(score >= 70) {
			System.out.println("점수가 70점보다 높습니다.");
			System.out.println("등급은 C입니다.");
		}
		else {
			System.out.println("점수가 70미만입니다.");
			System.out.println("등급은 D입니다.");
		}
	}

}
