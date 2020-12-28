/*
 * ���α׷��ӽ�
 * ����: ���̽�ƽ
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
	
	
	// for���� ���鼭 ���ư� ������ ��ġ�� ã�´�.
	// �� ��ġ���� ���ư��� ��, ��ü �ɸ��� Ƚ���� ���� ���
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
				// ó������ �������, ���翡�� ó������ + �����ʳ����� �Ѿ A�� ��������
				int calculatedMove = 2*(i-1) + ((len-1) - (aNum+1) - (i-1) + 1);
				minMove = (calculatedMove < minMove) ? calculatedMove : minMove;
			}	
		}
		return minMove;
	}

	// �� �ڸ������� �ʿ��� ���Ʒ� ������ ���.
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
 * ��: ����
 * �Ʒ�: ����. A���� �Ʒ����ϸ� Z�� ����
 * ����: Ŀ�� ��������. (�� ���ʿ��� �����ϸ� ���������ڷ�)
 * ������: Ŀ�� ����������
 * 
 * name�� ���ĺ� �빮�ڸ�
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
 * for���� ���鼭 ���ư� ��ġ�� ã�´�.
 * i=1, i=2, i=3 ��ġ���� �̵��� �� ���ư��ٰ� ���� ���� ��ü �������� ����Ѵ�.
 * */
 