package confirm;

public class Ch04_Ex03 {

	public static void main(String[] args) {
		int dice_f,dice_s;
		while(true) {
			int sum = 0;
			dice_f = (int)(Math.random()*6) + 1;
			dice_s = (int)(Math.random()*6) + 1;
			sum = dice_f + dice_s;
			System.out.println("("+dice_f+","+dice_s+")");
			if(sum == 5) {
				System.out.println("합이 5가 되었습니다. 프로그램을 종료합니다.");
				break;
			}
			
		}

	}

}
