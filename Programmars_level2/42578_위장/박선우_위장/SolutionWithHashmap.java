/*
 * ���α׷��ӽ�
 * ����: �ؽ� - ����
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */

import java.util.HashMap;
import java.util.Map.Entry;

public class SolutionWithHashmap {

	public int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> closet = new HashMap<String, Integer>(clothes.length);
		
		for(int i = 0; i < clothes.length; i++) {
			String clothType = clothes[i][1];
			int clothNum;
			
			if(closet.containsKey(clothType)) {
				clothNum = closet.get(clothType) + 1;
				closet.put(clothType, clothNum);
			}
			else {
				clothNum = 1;
				closet.put(clothType, clothNum);
			}
		}

		answer = calculateAllCombinations(closet);
		System.out.println("����: " + answer);
		return answer;
	}

	private int calculateAllCombinations(HashMap<String, Integer> closet) {
		if(closet.size() == 0) {
			return 0;
		}
		
		int result = 1;
		for(Entry<String, Integer> entry : closet.entrySet()) {
			result *= (entry.getValue() + 1);
		}
		return result - 1;
	}
}



// HashMap
// https://coding-factory.tistory.com/556
// https://d2.naver.com/helloworld/831311
/*
 * Map �������̽��� ������ Map �÷���.
 * Java 8 HashMap������ Separate Chaining�� �̿��Ѵ�. �ؽ� �浹�ÿ� ��ũ�� ����Ʈ�� �̿�. 
 * �����Ͱ� �������� ȿ���� �������⿡ Ʈ���� ��� ����Ѵ�.
 */

