package algorithm;
import java.util.Scanner;

public class EncodingAno {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine()); //테스트 케이스의 개수를 넘긴다.
		String[] passwordCase = new String[t]; //테스트 케이스 크기만큼의 배열을 만든다.
		char[] charArr; //변환된 암호를 배열로 담아 놓는다.
		String str = null; //변환된 암호를 한 단어로 담을 변수를 선언
		char z = 'z'; //알파벳의 마지막 문자인 z의 아스키코드를 이용하기 위해 선언
		char a = 'a'; //알파벳의 첫번째 문자인 a의 아스키코드를 이용하기 위해 선언
    
    
		for (int i=0; i<t; i++) {
			int len = Integer.parseInt(sc.nextLine()); //패스워드의 길이를 입력한다
			charArr = new char[len]; //패스워드의 길이만큼의 배열을 만든다
			String password = sc.nextLine(); //패스워드 입력
       
			for (int j=0; j<password.length(); j++) { //패스워드 길이 만큼 반복
				char c = password.charAt(j); //패스워드 문자를 하나씩 꺼내서 아스키코드로 변환하고 4번째 뒤 문자의 아스키코드를 구한다
				int ascii = ((int) c) + 4;
           
				if (ascii >  (int) z) { //만약 아스키코드가 알파벳의 마지막 문자인 z보다 크다면 다시 a부터 시작해야 하므로 알파벳 길이 만큼 빼준다. 알파벳 길이는 26.
					ascii -= (((int) z - (int) a) + 1);
				}
           
				char newAlpa = (char) ascii; //4번째 뒤인 문자의 아스키코드를 다시 알파벳으로 변환하고 배열에 넣는다.
				charArr[j] = newAlpa;
				str = new String(charArr); //배열에 있는 문자를 하나의 문자열로 묶는다.
			}
			passwordCase[i] = str;
		};
    
		for (int i=0; i<t; i++) { //테스트 케이스 크기만큼 반복문을 돈다.
			System.out.println("Case #" + (i+1));
			System.out.println(passwordCase[i]);
		}
	}
	
}
