package codingtest;

import java.util.HashMap;
import java.util.Map;

public class ProgrammersHash3 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int answer = 1;
		Map<String, Integer> map = new HashMap();
		
		for(String[] c : clothes) {
			map.put(c[1], map.getOrDefault(c[1], 0) + 1); 
		}
		for(String key : map.keySet()) {
			answer *= map.get(key)+1;
		}
		answer--;
		System.out.println(answer);
		
	}

}
