package ch05.sec02;

public class ArrayReferenveObjectExample {

	public static void main(String[] args) {
		String[] array = new String[3];
		
		array[0] = "Java";
		array[1] = "Java";
		array[2] = new String("Java");
		
		System.out.println(array[0] == array[1]);
		System.out.println(array[0] == array[2]);
		System.out.println(array[0].equals(array[2]));

	}

}
