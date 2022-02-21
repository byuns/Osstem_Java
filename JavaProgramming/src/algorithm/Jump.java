package algorithm;
import java.util.Scanner;

public class Jump {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int route = 0; // 경로의 개수
		boolean rightFlag = false;
		boolean downFlag = false;
		
		int length = Integer.parseInt(sc.nextLine());
		String[][] board = new String[length][];
		
		for(int i=0; i<board.length; i++) { // 게임 판에 값 저장
			board[i] = sc.nextLine().split(" ");
		}
		
		for(int i = 0; i<board.length; i++) {			
			for(int j = 0; j < board.length; j++) {
				if(!(Integer.parseInt(board[i][j]) > (length - (j+1)))) { // 가로 남은 칸의 수가 현재 적힌 수 보다 크다면 실행
					rightFlag = true;
					break;
				}
				else {
					rightFlag = false;
				}
			}
			
			
		}
		
		
	}

}
