package ch13.sec01.exam04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("Vue.js");
		
		int size = set.size();
		System.out.println("size = "+size);
		
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String el = iterator.next();
			System.out.println("\t" + el);
		}
		
		set.remove("JDBC");
		set.remove("Vue.js");
		
		System.out.println("size = " + set.size());
		
		iterator = set.iterator();
		for(String str : set) {
			System.out.println("\t" + str);	
		}
		set.clear();
		if(set.isEmpty()) {System.out.println("비어 있음");}
	}

}
