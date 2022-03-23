package codingtest;

import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersQueueStack03 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = new int[]{7,4,5,6};
		
		int result = solution(bridge_length,weight, truck_weights);
		
		System.out.println("답 : " + result);
	} 
	


    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	int answer = 0;
    	Queue<Integer> q = new LinkedList();
    	
    	int time = 0;
    	int tmp = 0;
    	
    	for(int i : truck_weights) {
    		while(true) {
    			if(q.isEmpty()) {
    				q.add(i);
    				tmp += i;
    				time++;
    				break;
    			}
    			else if(q.size() == bridge_length) {
    				tmp -= q.poll();
    			}
    			else {
    				if(tmp + i > weight) {
    					q.add(0);
    					time++;
    				}
    				else {
    					q.add(i);
    					tmp += i;
    					time++;
    					break;
    				}
    			}
    		}
    		
    	}
    	answer = time + bridge_length;
    	
        return answer;
    }

}