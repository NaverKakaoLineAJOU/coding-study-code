/*
 * 프로그래머스 - 탐욕법
 * 제목: 구명보트
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
			if(people[back] + people[front] <= limit) { // 2인 탑승
				front++;
				boatNum++;
			}
			else {	// 1인 탑승
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
 * 보트는 한번에 최대 2명씩, 무게 제한 limit
 * 무게 제한을 초과하지 않게 
 * 필요한 보트의 최솟값. 

 * 큰큰, 큰작, 작작 3 경우 모두 2인이다. 꽉채우는 것보다
 * 1명을 보내냐 2명을 보내냐의 문제
 */
