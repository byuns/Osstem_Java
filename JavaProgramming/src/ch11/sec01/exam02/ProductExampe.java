package ch11.sec01.exam02;

import java.util.*;

public class ProductExampe {
	public static void main(String[] args) {
		
		Product p1 = new Product(1,"mycompany","TV",1000000);
		Product p2 = new Product(2,"yourcompany","TV",2000000);
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p1.equals(p2));
		
		HashSet<Product> hashSet = new HashSet<>();
		hashSet.add(p1);
		hashSet.add(p2);
		System.out.println("저장한 수 : " + hashSet.size());
	}
	
	

}
