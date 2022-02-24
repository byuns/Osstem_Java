package ch11.sec01.exam04;
import java.util.*;

public class ToStringExample {
	public static void main(String[] args) {
		Member m = new Member("winter");
		Product p = new Product(1,"company","노트북",2500000);
		Date d = new Date();
		
		System.out.println(m);
		System.out.println(p);
		System.out.println(d);
	}

}
