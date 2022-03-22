package codingtest;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProgrammersQueueStack02 {
	public static void main(String[] args) {
		int[] priorities = new int[] {2,1,3,2};
		int location = 2;
		int result = solution(priorities, location);
		System.out.println("결과 : " + result);
		
	} // 3,2,2,1
	


    public static int solution(int[] priorities, int location) {
    	int answer = 0;
    	// 우선순위 큐 : 가장 큰 값이 앞으로 온다. (reverseOrder()로 역순 정렬)
    	Queue<Integer> q = new PriorityQueue(Collections.reverseOrder());
    	
    	for(int p : priorities) {
    		q.add(p);
    	}
    	
    	boolean flag = true;
    	
    	while(flag) {
    		for(int i = 0; i< priorities.length; i++) {
    			if(q.peek() == priorities[i]) { 
    				// 현재 큐에서 우선순위가 가장 높은 값과 priorities의 값이 같을 때, 해당 값을 꺼낸 뒤 횟수를 증가시킨다.
    				q.poll();
    				answer++;
    				if(location == i) {//요청 문서와 꺼낸 문서의 위치가 동일하면 종료
    					flag = false;
    					break;
    				}
    			}
    		
    		}
    		
    		if(q.isEmpty())	break;
    	}
    	
        return answer;
    }

}