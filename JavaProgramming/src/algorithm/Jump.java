package algorithm;
import java.util.Scanner;

public class Jump {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int length = Integer.parseInt(sc.nextLine());
		String[][] board = new String[length][];
		int[][] dp = new int[101][101];
		
		dp[0][0] = 1;
		
		for(int i=0; i<board.length; i++) { // 게임 판에 값 저장
			board[i] = sc.nextLine().split(" ");
		}
		
		for(int i = 0; i<board.length; i++) {			
			for(int j = 0; j < board.length; j++) {
				if(i == board.length-1 && j == board.length-1) {
					continue;
				}
				int dist = Integer.parseInt(board[i][j]);
				int down = dist + i;
				int right = dist + j;
				
				if(down < board.length) {
					dp[down][j] += dp[i][j];
				}
				if(right < board.length) {
					dp[i][right] += dp[i][j];
				}

			}

		}
		System.out.println(dp[length-1][length-1]);
		
		
	}

}
