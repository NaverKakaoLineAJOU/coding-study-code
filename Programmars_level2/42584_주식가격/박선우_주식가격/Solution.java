/*
 * 프로그래머스 - 스택/큐
 * 제목: 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */

import java.util.*;

public class Solution {
	
    public int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	
    	for(int i = 0; i < answer.length; i++) {
    		answer[i] = calculatePeriod(prices, i);
    	}
        return answer;
    }

	private int calculatePeriod(int[] prices, int start) {
		int result;
		
		if(start == prices.length - 1) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = start; i < prices.length; i++) {
			// add first value
			if(stack.isEmpty()) {
				stack.add(prices[i]);
				continue;
			}
			// add equal+bigger values to the stack
			if(prices[start] <= prices[i]) {
				stack.add(prices[i]);
				continue;
			}
			// if smaller, return stack.size
			else {
				result = stack.size();
				return result;
			}
		}
		// all values are equal+bigger
		result = stack.size() - 1;		
		return result;
	}
}

/* 초 단위로 주식가격이 기록
 * 가격이 떨어지지 않은 기간은 몇초인지?
 * 입력: [1, 2, 3, 2, 3]
 * 출력: [4, 3, 1, 1, 0]
 * 
 * 1은 끝날때까지 떨어지지 않는다. 4
 * 2은 끝날때까지 떨어지지 않는다. 3
 * 3은 2까지 떨어지지 않는다. 1
 * 2는 끝날때까지 떨어지지 않는다. 1
 * 3은 끝이므로 0.
 */
