/*
 * 프로그래머스 - 2017 카카오코드 본선
 * 제목: 단체사진 찍기
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */

import java.util.*;
import java.util.Map.Entry;

class Solution {

	static int[] seats; 	// seats been taken. empty seats -1
	static boolean[] used;	// whether friends set.
	static LinkedHashMap<Character, Integer> friends;	// LinkedHashMap follows the order
	static int answer;

	public int solution(int n, String[] data) {
		//initialize===============================
		answer = 0;
		int memberNum = 8;
	
		seats = new int[memberNum];	
		Arrays.fill(seats, -1);
		
		used = new boolean[memberNum];
		
		friends = new LinkedHashMap<Character, Integer>(memberNum);
		initializeFriends();
		//initialize===============================
		
	
		int index = 0;
		search(index, memberNum, data);
		
		return answer;
	}

	private void search(int index, int memberNum, String[] data) {
		// seats are full
		if(index == memberNum) {
			answer++;
			return;
		}
		
		// check before moving
		//  check every childs node whether it is promising
		for(Entry<Character, Integer> entry : friends.entrySet()) {	
			int newGuy = entry.getValue();
		
			if(isPromising(index, newGuy, data)) {
				used[newGuy] = true; 	// check as used
				seats[index] = newGuy;	// check the  seats
				search(index + 1, memberNum, data); // move to next level
				used[newGuy] = false;
				seats[index] = -1;
			}	
		}
	}
	
	private boolean isPromising(int index, int newGuy, String[] data) {
		// already set
		if(used[newGuy]) {
			return false;
		}
		// put newGuy and start test.
		seats[index] = newGuy;
		
		for(String condition : data) {
			int start = friends.get(condition.charAt(0));
			int end = friends.get(condition.charAt(2));
			char operand = condition.charAt(3);
			int requestedSpace = condition.charAt(4) - '0';
			
			int seatA = -1;
			int seatB = -1;
			for(int i = 0; i <seats.length; i++) {
				if(seats[i] == start) {
					seatA = i;
				}
				if(seats[i] == end) {
					seatB = i;
				}
			}
			
			if(seatA < 0 || seatB < 0) {
				continue;	// true 
			}
			
			int space = Math.abs(seatA - seatB) - 1;
			switch(operand) {
			case '>':
				if(space <= requestedSpace) {
					seats[index] = -1;
					return false;
				}
				break;
				
			case '=':
				if(space != requestedSpace) {
					seats[index] = -1;
					return false;
				}
				break;
				
			case '<':
				if(space >= requestedSpace) {
					seats[index] = -1;
					return false;
				}
				break;
			}
		}
		seats[index] = -1;
		return true;
	}

	private void initializeFriends() {
		friends.put('A', 0);
		friends.put('C', 1);
		friends.put('F', 2);
		friends.put('J', 3);
		friends.put('M', 4);
		friends.put('N', 5);
		friends.put('R', 6);
		friends.put('T', 7);
		return;
	}
}

/*
 * 원하는 조건을 입력으로 받았을 때, 가능한 경우의 수를 계산. data는 5글자 문자열. 
 * 1. 첫글자 = A, C, F, J, M, N, R, T 
 * 2. 두글자 = ~ 
 * 3. 세글자 = 상대방 
 * 4. 네글자 = ><= 
 * 5. 오글자: 둘 사이에 있는 사람 수
 */
