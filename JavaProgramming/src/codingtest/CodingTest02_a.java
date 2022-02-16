package codingtest;
import java.util.Scanner;

public class CodingTest02_a {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0; // sum을 저장하기 위한 값
		int max = 0; // min을 추출하기 위해 사용할 최대값
		int min = 0; // 최소값을 저장하는 변수
		int chk = 0; // 짝수인 경우를 위한 변수
		
		String[] num = scanner.nextLine().split(", "); // 입력 받은 문자열에서 숫자만 추출해서 배열에 저장
		
		
		int[] numAry = new int[num.length]; // int형 배열 선언
		
		// max값을 구하고 numAry에 String타입의 값을 int형으로 바꿔 저장
		for(int i=0; i<num.length; i++) {
			numAry[i] = Integer.parseInt(num[i]);
			if(max < numAry[i]) { // 최대값을 구하는 조건문
				max = numAry[i];
			}
		}
		
		min = max; // 최소값을 구하기 위해 배열에서 최대값을 min에 넣어 초기화
		
		for(int i=0; i<numAry.length; i++) {
			if(numAry[i] % 2 == 1) { // 홀수인 경우
				sum += numAry[i]; // sum에 추가
				if(min > numAry[i]) { // 최소값을 구하는 조건문
					min = numAry[i];
				}
				chk++; // 홀수인 경우 chk를 1씩 증가
			}
		}
		if(chk == 0) { // 짝수인 경우
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println();
			System.out.println(min);	
		}
		
	}

}
