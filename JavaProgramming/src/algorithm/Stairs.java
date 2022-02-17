package algorithm;
import java.util.Scanner;

public class Stairs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int kcal = 0; // 층 별 칼로리 소모량
		int total = 0;// 총 칼로리 소모량
		int up = 0; // "#"의 개수 카운팅 변수
		
		String[] stairs = scan.next().split(""); //한 문자 씩 분할하여 0번 index부터 저장
		boolean flag = false;
		
		for(int i = 0; i< stairs.length; i++) {//문자 하나씩 읽어 칼로리 소모량 계산(1."#"이 아닌 경우, 2."#"인 경우)
			
			if(!stairs[i].equals("#")) { //1."#"이 아닌 경우
				if(flag == false) { //flag가 false이면 #이 없거나 끝났다는 의미
					if(stairs[i].equals("(")) { // "("이면 층이 올라가면서 소모되는 칼로리 1씩 증가
						kcal++;
					}
					
					total += kcal; // 총 소모 칼로리(정상적인 증가)
					//System.out.println(total); // 이해를 돕기 위한 코드
					
					if(stairs[i].equals(")")) { // ")"이면 층이 내려가면서 소모되는 칼로리 1씩 감소
						kcal--;
					}

				}
				else {// flag가 true이면 #이 시작 되었다는 의미
					if(stairs[i].equals("(")) { // "("이면 층이 올라가면서 소모되는 칼로리 1씩 증가
						kcal++;
					}
					
					total += (kcal*2);// 총 소모 칼로리(두 배로 증가)
					//System.out.println(total); // 이해를 돕기 위한 코드
					
					if(stairs[i].equals(")")) {// ")"이면 층이 내려가면서 소모되는 칼로리 1씩 감소
						kcal--;
					}
					
				}
			}
			else { // 2."#"인 경우 and "#"이 홀수면 시작점, 짝수면 끝점
				up++; //"#" 개수 증가
				if(up%2 != 0) {
					flag = true;
				}
				else {
					flag = false;
				}

			}
		}
		System.out.println(total);
	}

}
