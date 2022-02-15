package confirm;

public class Ch04_Ex04 {

	public static void main(String[] args) {//4x + 5y = 60
		int x,y; 
		for(x = 1; x <= 10; x++) {
			for(y = 1; y<= 10; y++) {
				if((4*x) + (5*y) == 60) {
					System.out.println("("+x+","+y+")");
				}
			}
		}

	}

}
