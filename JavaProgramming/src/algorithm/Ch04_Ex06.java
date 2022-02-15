package algorithm;
import java.util.Scanner;

public class Ch04_Ex06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.println("*******************************");
			System.out.println("1.메뉴 | 2. 메뉴 | 3. 메뉴 | 4. 종료");
			System.out.println("*******************************");
			System.out.print("선택 : ");
			select = Integer.parseInt(scan.nextLine());
			if(select == 4) {
				System.out.println("프로그램이 종료됩니다.");
				System.exit(0);
			}
			else {
				System.out.println(select + "번이 선택되었습니다.");
			}
		}
		

	}

}
