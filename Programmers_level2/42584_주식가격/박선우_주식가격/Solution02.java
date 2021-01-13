
public class Solution02 {
	 public int[] solution(int[] prices) {
	    	int[] answer = new int[prices.length];
	    	
	    	for(int i = 0; i < answer.length; i++) {
	    		answer[i] = calculatePeriod(prices, i);
	    	}
	        return answer;
	    }

		private int calculatePeriod(int[] prices, int start) {
			int result = 0;
			
			if(start == prices.length - 1) {
				return 0;
			}
			
			for(int i = start; i < prices.length; i++) {
				if(prices[start] <= prices[i]) {
					result++;
					continue;
				}
				else {
					return result;
				}
			}
			
			result = result - 1;		
			return result;
		}
}








