package ch11.sec01.exam03;

import java.util.*;

public class KeyExample {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		/*
		String key1 = "m1";
		String key2 = new String("m1");
		
		map.put(key1,"홍길동");
		map.put(key2,"눈송이");
		
		System.out.println(map.size());
		
		System.out.println(key1.hashCode());
		System.out.println(key2.hashCode());
		
		System.out.println(key1.equals(key2));
		*/
		// --------------
		HashMap<Key,String> map2 = new HashMap<>();
		
		Key myKey = new Key(1,"winter");
		Key yourKey = new Key(1,"winter");
		
		map2.put(myKey, "홍길동");
		map2.put(yourKey, "눈송이");
		System.out.println(map2.size());
		
		System.out.println(myKey.hashCode());
		System.out.println(yourKey.hashCode());
		
		System.out.println(myKey.equals(yourKey));
	}

}
