package ch11.sec01;

public class StringSplitExample {

	public static void main(String[] args) {
		String scores = "83,90,87,94,96";
		String[] array = scores.split(",");
		int sum = 0;
		
		for(int i = 0; i<array.length; i++) {
			sum += Integer.parseInt(array[i]);
		}
		
		System.out.println(sum);
		System.out.println((double)sum/array.length);

	}

}
