package ch04.sec01;

public class SwitchExample {

	public static void main(String[] args) {
		int num = (int)(Math.random() * 6) + 1;
		
		switch(num) {
			case 1:
				System.out.println("1이(가) 나왔습니다.");
				break;
			case 2:
				System.out.println("2이(가) 나왔습니다.");
				break;
			case 3:
				System.out.println("3이(가) 나왔습니다.");
				break;
			case 4:
				System.out.println("4이(가) 나왔습니다.");
				break;
			case 5:
				System.out.println("5이(가) 나왔습니다.");
				break;
			case 6:
				System.out.println("6이(가) 나왔습니다.");
				break;
		}

	}

}
