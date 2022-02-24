package algorithm;
import java.util.Scanner;

public class Set {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String tmp[] = sc.nextLine().split(" ");
		String[] set = new String[Integer.parseInt(tmp[0])]; // 단어 집합
		String[] test = new String[Integer.parseInt(tmp[1])]; // 테스트할 단어들
		
		for(int i = 0; i < set.length; i++) { // n개의 문자열 집합 저장
			set[i] = sc.nextLine();
		}
		for(int i = 0; i < test.length; i++) { // m개의 문자열 저장
			test[i] = sc.nextLine();
		}
		
		int result = 0;
		
		for(int i=0; i<test.length; i++) {
			for(int j=0; j<set.length; j++) {
				if(test[i].equals(set[j])) { // 포함되면 결과를 +1
					result++;
				}
			}
		}
		System.out.println(result);

	}

}
