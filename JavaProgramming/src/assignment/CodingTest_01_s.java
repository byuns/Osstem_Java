package assignment;

import java.util.Scanner;

public class CodingTest_01_s {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int apple_Count;
		int result = 0;
		String[] scores = null;
		String[] barrel_01 = null;
		String[] barrel_02 = null;
		
		System.out.print("사과의 개수 > ");
		apple_Count = Integer.parseInt(scan.nextLine());
		
		scores = new String[apple_Count];
		barrel_01 = new String[apple_Count];
		barrel_02 = new String[apple_Count];
		
		System.out.print("사과 점수 > ");
		scores = scan.nextLine().split(" ");
		
		System.out.print("첫 번째 줄 장애물 > ");
		barrel_01 = scan.nextLine().split("");
		
		System.out.print("두 번째 줄 장애물 > ");
		barrel_02 = scan.nextLine().split("");
		
		for(int i = 0; i<scores.length; i++) {
			if(barrel_01[i].equals("O") && barrel_02[i].equals("O")) {
				result += Integer.parseInt(scores[i]);
			}
		}
		
		System.out.println("총점은" + result +"이다.");
	}

}
