package ch05.sec03;

public class SeasonExample {

	public static void main(String[] args) {
		Season season = Season.SPRING;
		
		season = Season.FALL;
		
		if(season == Season.SPRING) {
			System.out.println("봄입니다.");
		}
		else if(season == Season.FALL) {
			System.out.println("가을입니다.");
		}
		else {
			System.out.println("여름 또는 겨울입니다.");
		}
	}

}
