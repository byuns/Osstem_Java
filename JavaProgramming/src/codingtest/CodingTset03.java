package codingtest;
import java.util.Scanner;

public class CodingTset03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" "); //주어지는 수 공백 분할(3,10)
		
		String[] memo = new String[Integer.parseInt(num[0])]; // 암기 가능 단어 수 =  memo의 길이
		String[] word = new String[Integer.parseInt(num[1])]; // 주어지는 단어 수 = word의 길이
		int time = 0; // 시간
		
		word = sc.nextLine().split(" "); // 주어지는 단어 공백 분할 (hi hello bye hi what bye good smart creative create)
		
		for(int i = 0; i<word.length; i++) {// 1.단어 탐색 및 시간 증가 2.단어 저장 
			
			// 1. 단어 탐색 및 시간 증가
			
			boolean flag01 = false; // 두 배열에 같은 단어가 존재하는지 판별하는 변수
			int lengthSum = 0; // 문자열 길이 합
			int tmp = -1; // 암기했던 단어 위치 추출하는 변수(index는 '-'가 될 수 없으므로 -1로 선언)
			
			for(int j = 0; j<memo.length; j++) {
				if(memo[j] != null) {// 문자가 존재할 때 실행
					if(memo[j].equals(word[i])) { // 암기 했던 단어인지 파악
						flag01 = true;
						tmp = j; // 암기했던 단어 위치 저장
						break;
					}
					lengthSum += memo[j].length(); //존재하는 문자열 길이의 총 합
				}
			}
			
			if(flag01 == true) {
				time += 1; // 1초 증가
			}
			else {
				time += 3; // 3초 증가
			}
			
			System.out.println(time); // 이해를 돕기 위한 코드
			
			//2. 단어 저장 if-else(같은 단어가 있을 때와 없을 때)
			
			boolean flag02 = false; // 배열이 가득 찼는지 파악하는 변수
			double lengthAvg = (double)lengthSum/memo.length; // 전체 암기 단어 평균 길이 
			
			if(tmp != -1) { // 같은 문자가 존재할 때 실행
				for(int j = tmp; j<memo.length-1; j++) { //뒤의 단어를 한 칸씩 당김
					memo[j] = memo[j+1]; 
				}
				if(memo[memo.length-1] != null) { // 당겨진 배열의 끝을 null로 초기화
					memo[memo.length-1] = null; 
				}
				for(int j = 0; j<memo.length; j++) { // 비어있는 곳을 찾아 저장
					if(memo[j] == null) {
						memo[j] = word[i];
						break;
					}
				}
			}
		
			else { //같은 단어가 존재하지 않고 새로 암기
				for(int j = 0; j<memo.length; j++) {
					if(memo[j] == null) { // 비어있으면 바로 추가
						memo[j] = word[i];
						flag02 = true;
						break;
					}
				}
				if(flag02 != true) {//memo 배열이 가득 차있다. = 기존의 단어를 지울지 말지 판단
					for(int j = 0; j < memo.length; j++) {
						if(memo[j].length() < lengthAvg) {//평균 길이보다 작다면 실행
							if(j != memo.length-1) {//memo 배열의 마지막이 아니라면 실행
								for(int k = j; k<memo.length-1; k++) {
									memo[k] = memo[k+1];
								}
							}
							memo[memo.length-1] = word[i];
							break;
						}
					}
				}

			}
			for(String n : memo) { // 이해를 돕기 위한 코드
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println(time);
	}
}


