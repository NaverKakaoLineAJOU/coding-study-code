/*
 * ���α׷��ӽ� - Ž���
 * ����: ����Ʈ
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */

import java.util.Arrays;

public class Solution {
    
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		
		int boatNum = 0;
		int front = 0;
		int back = people.length - 1;
		for(; front < back; back--) {
			if(people[back] + people[front] <= limit) { // 2�� ž��
				front++;
				boatNum++;
			}
			else {	// 1�� ž��
				boatNum++;
			}
		}
		
		if(back == front) {
			boatNum++;
		}
		return boatNum;
    }
}


/*
 * ��Ʈ�� �ѹ��� �ִ� 2��, ���� ���� limit
 * ���� ������ �ʰ����� �ʰ� 
 * �ʿ��� ��Ʈ�� �ּڰ�. 

 * ūū, ū��, ���� 3 ��� ��� 2���̴�. ��ä��� �ͺ���
 * 1���� ������ 2���� �������� ����
 */
