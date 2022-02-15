package ch04.verify;

public class Ex03 {
	public static void main(String args[]) {
		for(int i = 1; i<11;i++) {
			if( i < 6) {
				for(int j = 0; j<i; j++) {
					System.out.print("*");
				}
				System.out.println("");
			}
			else {
				for(int k = 5;k>i-5;k--) {
					System.out.print("*");
				}
				
				System.out.println("");
				
			}
		}
	}

}
