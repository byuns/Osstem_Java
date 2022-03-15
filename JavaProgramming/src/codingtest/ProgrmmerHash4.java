package codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProgrmmerHash4 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] playes = {500, 600, 150, 800, 2500};
		int[] answer = {};
		

		// 장르별 순위 저장
		Map<String, Integer> mapCount = new HashMap();
		for(int i=0; i<genres.length; i++) {
			mapCount.put(genres[i],mapCount.getOrDefault(genres[i], 0)+playes[i]);
		}
		
		Set<String> keySet = mapCount.keySet();
		Iterator<String> keyIterator = keySet.iterator();

		Map<Integer, String> mapCount02 = new HashMap();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = mapCount.get(key);
			mapCount02.put(value, key);
		}
		
		ArrayList<Integer> mapKey = new ArrayList<>(mapCount02.keySet());
		Collections.sort(mapKey);
		Collections.reverse(mapKey);
		ArrayList<String> top = new ArrayList();
		for(Integer key: mapKey) {
			top.add(mapCount02.get(key));
		}
		
		for(int i=0; i<top.size(); i++) {
			
			ArrayList<ArrayList<Integer>> list = new ArrayList();
			ArrayList<Integer> list2 = new ArrayList();
			for(int j = 0; j < genres.length; j++) {
				if(genres[j].equals(top.get(i))) {
					list2.add(j);
					list2.add(playes[j]);
					list.add(list2);
					
				}
			}
			for(int j = 0; j<list.size(); j++) {
				System.out.println(list.get(j));
			}

			
		}
		
	}
}
