package codingtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProgrammersQueueStack01 {
	public static void main(String[] args) {
		int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
		int[] speeds = new int[] {1, 1, 1, 1, 1, 1};
		int[] answer = solution(progresses,speeds);

		for(int i : answer) {
			System.out.println(i);
		}
		
	}
	


    public static int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, Integer> map = new HashMap();
    	
        int[] arr = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++) { // 올림으로 날짜 계산 
        	arr[i] = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        	if(i > 0) { 
        		if(arr[i] < arr[i-1]) arr[i] = arr[i-1]; // 이전 값보다 작으면 해당 값으로 변경
        	}
        }
        for(int i = 0; i<arr.length; i++) { //값들을 key로, 동일한 값이 있으면 +1 인 value로 설정
        	map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
       
        Set<Integer> keySet = map.keySet();
        Object[] tmp = keySet.toArray();
        Arrays.sort(tmp); // 해시맵으로 저장된 값들을 오름차순 정렬
		
		
		int[] answer = new int[keySet.size()];
		
		for(int i=0; i<answer.length; i++) { // 해당 키를 가진 값을 answer에 삽입.
				int value = map.get(tmp[i]);
				answer[i] = value;
		}

        return answer;
    }

    
}