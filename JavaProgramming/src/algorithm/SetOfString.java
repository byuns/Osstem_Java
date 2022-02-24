package algorithm;
import java.util.Scanner;

public class SetOfString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine()); // 숫자 개수 입력
		String[] set = sc.nextLine().split(" "); // 수열 입력
		String[] operator_input = sc.nextLine().split(" ");//입력받기 위한 String 배열
		int[] operator = new int[operator_input.length];
		for(int i = 0; i<operator.length; i++) { //정수로 변환
			operator[i] = Integer.parseInt(operator_input[i]);
		}
		
		int result = Integer.parseInt(set[0]); // 결과를 저장할 변수(가장 처음 값이 들어가야 연산이 가능)
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
			for(int i = 0; i < operator.length; i++) {
				if(operator[i] < 0) { // 1이상의 값이 저장되어있다면 해당 연산 실행
					operator[i]--; // 사용되면 1씩 감소

					switch(i) {
						case 0:
							result += Integer.parseInt(set[i]);
							break;
						case 1:
							result -= Integer.parseInt(set[i]);
							break;
						case 2:
							result *= Integer.parseInt(set[i]);
							break;
						case 3: 
							result /= Integer.parseInt(set[i]);
							break;
					}
					operator[i]++;
				}
				System.out.println(result);
			
			
			}
		
	}

}
