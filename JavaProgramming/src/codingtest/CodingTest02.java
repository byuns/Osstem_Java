package codingtest;
import java.util.Scanner;

public class CodingTest02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] num = sc.nextLine().split(", ");// 콤마(,)와 공백(" ")으로 분할하여 num에 저장
		int count = 0;
		int result = 0;
		int min = Integer.parseInt(num[0]);// 비교하기 위해 가장 첫 번째 값을 최소로 지정
		
		for(String n : num) {
			int ch_n = Integer.parseInt(n); // String을 int로 변형
			if(ch_n % 2 != 0) {//짝수가 아니면 실행
				count++; //홀수 체크
				result += ch_n;// 홀수들의 합
				if(min > ch_n) { // 최소값 변경
					min = ch_n;
				}
			}
		}
		if(count != 0) {
			System.out.println(result);
			System.out.println();
			System.out.println(min);
		}
		else {
			System.out.println("-1");
		}

	}

}
