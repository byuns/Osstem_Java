package assignment;
import java.util.Scanner;

public class CodingTest_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int apple_Count;
		int result = 0;
		int[] scores = null;
		String[] barrel_01 = null;
		String[] barrel_02 = null;
		
		System.out.print("사과의 개수 > ");
		apple_Count = Integer.parseInt(scan.nextLine());
		
		scores = new int[apple_Count];
		barrel_01 = new String[apple_Count];
		barrel_02 = new String[apple_Count];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.print((i+1)+"번 사과 점수 > ");
			scores[i] = Integer.parseInt(scan.nextLine());
		}
		for(int i = 0; i < barrel_01.length; i++) {
			System.out.print("첫 번째 줄" + (i+1)+ "번 장애물 > ");
			barrel_01[i] = scan.nextLine();
		}
		for(int i = 0; i < barrel_02.length; i++) {
			System.out.print("두 번째 줄 " + (i+1) + "번 장애물 > ");
			barrel_02[i] = scan.nextLine();
		}
		
		for(int i = 0; i<scores.length; i++) {
			if(barrel_01[i].equals("O") && barrel_02[i].equals("O")) {
				result += scores[i];
			}
		}
		System.out.println("총점은" + result +"이다.");

	}

}
