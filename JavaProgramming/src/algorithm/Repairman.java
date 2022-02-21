package algorithm;
import java.util.Scanner;

public class Repairman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		int num = Integer.parseInt(input[0]);
		double lengthT = Double.parseDouble(input[1]); // 테이프 하나 당 길이
		String[] leaks = sc.nextLine().split(" ");
		
		double tmp = 0; // 누수된 곳 양 옆을 체크
		double lengthR = 0; //실제 사용하는 길이
		int tape = 0; // 필요한 테이프 개수
		
		for(int i=0; i<leaks.length; i++) {
			if(Integer.parseInt(leaks[i]) - 0.5 == tmp) { // 누수된 곳으로 부터 0.5떨어진 곳과 다음 누수된 곳이 겹치는지
				lengthR += 0.5;
			}
			else {
				lengthR += 1;
			}
	
			tmp = Integer.parseInt(leaks[i]) + 0.5; // 누수된 곳 +0.5를 하여 다음 누수된 곳과 체크
			
		}
		tape = (int)(lengthR/lengthT + 0.5); //0.5가 있으면 반올림을 위해 +0.5
		
		System.out.println(tape);
 
	}

}
