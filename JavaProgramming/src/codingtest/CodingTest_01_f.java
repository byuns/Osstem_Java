package codingtest;
import java.util.Scanner;

public class CodingTest_01_f {

	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		
		int target = Integer.parseInt(scanner.nextLine()); // 과녁 개수
		int sum = 0; // 총점
		
		String[] inputScores = scanner.nextLine().split(" "); // 점수
		String[] target1 = scanner.nextLine().split(""); // 과녁
		String[] target2 = scanner.nextLine().split(""); // 과녁
		
		for(int i=0; i<target; i++) {
			// 1번, 2번 과녁이 같고, 과녁이 O
			if(target1[i].equals(target2[i]) && target1[i].equals("O")) {
				sum += Integer.parseInt(inputScores[i]); // sum에 점수를 더한다
			}
		}
		// 출력
		System.out.println("총 점수");
		System.out.println();
		System.out.println(sum);

	}

}
