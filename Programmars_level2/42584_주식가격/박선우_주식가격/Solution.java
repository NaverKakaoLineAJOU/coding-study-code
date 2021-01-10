/*
 * ���α׷��ӽ� - ����/ť
 * ����: �ֽİ���
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

/* �� ������ �ֽİ����� ���
 * ������ �������� ���� �Ⱓ�� ��������?
 * �Է�: [1, 2, 3, 2, 3]
 * ���: [4, 3, 1, 1, 0]
 * 
 * 1�� ���������� �������� �ʴ´�. 4
 * 2�� ���������� �������� �ʴ´�. 3
 * 3�� 2���� �������� �ʴ´�. 1
 * 2�� ���������� �������� �ʴ´�. 1
 * 3�� ���̹Ƿ� 0.
 */
