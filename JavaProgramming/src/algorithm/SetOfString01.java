package algorithm;
import java.util.Scanner;

public class SetOfString01 {
	
	//main메소드 이외에 재귀함수 re(int num, int index)를 사용하기 위한 정적 필드 정의
	public static int[] operator = new int[4];//연산자 총 4개
	public static int[] set;// 수열 배열
	public static int max = Integer.MIN_VALUE; // 최대값 초기화
	public static int min = Integer.MAX_VALUE; // 최소값 초기화
	public static int n; // 입력받을 숫자 개수
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = Integer.parseInt(sc.nextLine()); // 숫자 개수 입력
		set = new int[n];//입력 받은 개수를 set 배열의 길이로 설정
		
		String[] set_input = sc.nextLine().split(" "); // 수열 입력
		
		for(int i = 0; i < set_input.length; i++) {
			set[i] = Integer.parseInt(set_input[i]);
		}
		
		String[] operator_input = sc.nextLine().split(" ");//입력받기 위한 String 배열
		for(int i = 0; i<operator.length; i++) { //정수로 변환
			operator[i] = Integer.parseInt(operator_input[i]);
		}
		
		re(set[0],1); // 연산을 위해 set배열의 첫 값이 들어가야 한다.
		
		System.out.println(max);
		System.out.println(min);
		
	}
	public static void re(int num, int index) {
		if(index == n) { // index가 해당 경우의 수의 마지막을 만나면 max와 min을 저장
			if(max < num) {
				max = num;
			}
			if(min > num) {
				min = num;
			}
		}
		
		for(int i = 0; i < operator.length; i++) { // 모든 경우의 수
			if(operator[i] > 0) {
				operator[i]--; //한 번 실행될 때마다 operator에 있는 값이 1씩 감소 
				
				switch(i) {
					case 0:// '+'
						re(num + set[index], index + 1);
						break;
					case 1:// '-'
						re(num - set[index], index + 1);
						break;
					case 2:// '*'
						re(num * set[index], index + 1);
						break;
					case 3:// '/'
						re(num / set[index], index + 1);
						break;
				}
				operator[i]++;//다른 경우의 수를 계산하기 위해 초기화를 위한 값 증가
			}
		}
	}

}
