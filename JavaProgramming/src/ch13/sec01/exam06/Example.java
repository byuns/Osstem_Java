package ch13.sec01.exam06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Example {

	public static void main(String[] args) {
		String[] input1 =  {"leo", "kiki", "eden"};
		String[] input2 = {"eden", "kiki"};
		String a = solution(input1, input2);
		System.out.println(a);

	}
	    public static String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Map<String, Integer> map = new HashMap();
	        for(String str : participant) {
	        	map.put(str,map.getOrDefault(str, 0) + 1);
	        }
	        for(String str : completion) {
	        	map.put(str,map.getOrDefault(str, 0) - 1);
	        }
	        
	        Set<String> keySet = map.keySet();
			Iterator<String> keyIterator = keySet.iterator();
			
			while(keyIterator.hasNext()) {
				String key = keyIterator.next();
				Integer value = map.get(key);
				if(value == 1) {
					answer = key;
				}
			}
	        return answer;
	    }
	

}
