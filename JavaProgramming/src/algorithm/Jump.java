package algorithm;
import java.util.Scanner;

public class Jump {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = Integer.parseInt(sc.nextLine());
		String[][] board = new String[length][length];
		int[][] dp = new int[length+1][length+1];//경로를 저장하기 위한 새로운 배열
		
		dp[0][0] = 1; // 경로 수 저장
		
		for(int i=0; i<board.length; i++) { // 게임 판에 값 저장
			board[i] = sc.nextLine().split(" ");
		}
		
		for(int i = 0; i<board.length; i++) {			
			for(int j = 0; j < board.length; j++) {
				if(i == length-1 && j == length-1 || Integer.parseInt(board[i][j]) == 0) { //끝에 도달하는 것은 제외
					continue;
				}
				int tmp = Integer.parseInt(board[i][j]); 
				int right = tmp + j; // 가로 경로를 저장 , 해당 값 만큼 움직인다
				int down = tmp + i; // 세로 경로를 저장, 해당 값 만큼 움직인다.
		
		
				if(right < board.length) {
					dp[i][right] += dp[i][j]; // dp에 가로 경로를 하나씩 추가
				}
				if(down < board.length) {
					dp[down][j] += dp[i][j]; // dp에 세로 경로를 하나씩 추가
				}

			}

		}
		System.out.println(dp[length-1][length-1]); // 최종 경로의 수를 출력
		
		
	}

}
