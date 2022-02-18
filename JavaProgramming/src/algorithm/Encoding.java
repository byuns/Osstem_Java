package algorithm;
import java.util.Scanner;

public class Encoding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int caseNum = Integer.parseInt(sc.nextLine()); // case 개수
		String[] print = new String[caseNum]; // 출력할 결과 저장 String 배열
		
		for(int i = 0; i < caseNum; i++) { // case 개수만큼 반복
			int strLength = Integer.parseInt(sc.nextLine()); // 문자열 길이
			String str = sc.nextLine(); //문자열로 읽어들임
			String result = ""; // 변환된 단어를 저장할 변수
			
			
			for(int j = 0; j < str.length(); j++) {
					char ch = str.charAt(j); // 해당 문자열을 char형태로 변환
					ch += 4; // 4번쨰 뒤 문자
					if(ch > 122) { // 'z'를 넘어갈 시 다시 'a'로 돌아가게 -26을 실행
						ch -= 26;
					}
					result += (char)ch; // 변환된 값을 char로 변환 후 저장
			}
			print[i] = result; // 변환된 문자열을 출력 배열에 저장
		}
		
		System.out.println();
		
		for(int i = 0; i<print.length; i++) { //저장된 값 출력
			System.out.println("Case # " + (i+1));
			System.out.println(print[i]);
		}
	}

}
