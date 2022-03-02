package ch13.sec01.exam04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Spring");
		set.add("Vue.js");
		
		for(String item : set) {
			System.out.println(item);
		}
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			System.out.println(item);
		}
		System.out.println();
		
		/*for(String item : set) {
			if(item.equals("Vue.js")) {
				set.remove(item);
			}else
				System.out.println(item);
		}
		System.out.println();*/
		
		Iterator<String> iterator2 = set.iterator();
		while(iterator2.hasNext()) {
			String item = iterator2.next();
			if(item.equals("Vue.js")) {
				iterator2.remove();
			}else
				System.out.println(item);
		}
		
	}

}
