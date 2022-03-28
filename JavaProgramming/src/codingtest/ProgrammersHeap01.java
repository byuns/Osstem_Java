package codingtest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProgrammersHeap01 {
	public static void main(String[] args) {
		int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};

		int result = solution(jobs);
		System.out.println("답 : " + result);
	} 

	 public static int solution(int[][] jobs) {
		 
		 int answer = 0;
	
		 Arrays.sort(jobs, new Comparator<int[]>() { 
			 public int compare(int[] o1, int[] o2) { 
					 return o1[0] - o2[0]; 
				 }
			 });
		 
		 Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() { 
			 public int compare(int[] o1, int[] o2) { 
					return o1[1] - o2[1]; 
			 }});
		 int count = 0;
		 int time = 0;
		 

		 for(int i = 0; i<jobs.length;i++) {
			 queue.add(jobs[i]);
		 }
		 
		 while(count < jobs.length) {
			if(queue.isEmpty()) {
				time = jobs[queue.size()][0];
			}
			else {
				int[] tmp = queue.poll();
				answer += (tmp[1] + time) - tmp[0];
				count++;
			}
		 }

	        return answer;

	 }

}