/*
 * 프로그래머스
 * 제목: 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
*/
import java.util.*;

public class Solution {
	
	public int solution(String name) {
		int answer = 0;
		int len = name.length();
		int move = 0;	
		move += countUpDownMove(name, len);
		move += countLeftRightMove(name, len);
		
		answer = move;
		return answer;
	}
	
	
	// for문을 돌면서 돌아갈 최적의 위치를 찾는다.
	// 각 위치에서 돌아갔을 때, 전체 걸리는 횟수를 각각 계산
	private int countLeftRightMove(String name, int len) {
		
		int minMove = len - 1;
		for(int i = 0; i < len; i++) {
		
			if(name.charAt(i) == 'A') {
				int nextIndex = i+1;
				int aNum = 1;
				while(nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
					aNum++;
					nextIndex++;
				}		
				// 처음에서 현재까지, 현재에서 처음까지 + 오른쪽끝으로 넘어가 A의 다음까지
				int calculatedMove = 2*(i-1) + ((len-1) - (aNum+1) - (i-1) + 1);
				minMove = (calculatedMove < minMove) ? calculatedMove : minMove;
			}	
		}
		return minMove;
	}

	// 각 자리에서의 필요한 위아래 움직임 계산.
	private int countUpDownMove(String name, int len) {
		int move = 0;
		int val = 0;
		
		for(int i = 0; i < len; i++) {
			val  = name.charAt(i) - 65;
			int cUp = countUp(val);
			int cDown = countDown(val);
			move += (cUp < cDown) ? cUp : cDown;
		}
		return move;
	}

	private int countUp(int val) {
		return val;
	}
	
	private int countDown(int val) {
		if(val == 0) {
			return 0;
		}
		int move = (25 - val) + 1;
		return move;
	}
}

/*
 * 위: 다음
 * 아래: 이전. A에서 아래로하면 Z로 간다
 * 왼쪽: 커서 왼쪽으로. (맨 왼쪽에서 왼쪽하면 마지막문자로)
 * 오른쪽: 커서 오른쪽으로
 * 
 * name은 알파벳 대문자만
 * 1 <= name.length <= 20
 */

/*
 * ABCDE FGHIJ KLMNO PQRST UVWXY Z
 * 65                           90
 */

/*
 *  name	return
	JEROEN	56
	JAN		23
*/


/*
 * for문을 돌면서 돌아갈 위치를 찾는다.
 * i=1, i=2, i=3 위치까지 이동한 후 돌아간다고 했을 때의 전체 움직임을 계산한다.
 * */
 