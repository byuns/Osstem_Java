package codingtest;



public class ProgrammersQueueStack04 {
	public static void main(String[] args) {
		int[] prices = new int[] {1, 2, 3, 2, 3};
		int[] result = solution(prices);
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	} 
	


	 public static int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        for(int i=0; i<prices.length-1; i++) {
	        	int count = 0;
	        	int time = 0;
	        	for(int j = i+1; j < prices.length; j++) {
	        		time++;
	        		if(prices[i] > prices[j]) {
	        			break;
	        		}
	        	}
	        	answer[i] = time;
	        }
	        return answer;
	    }

}