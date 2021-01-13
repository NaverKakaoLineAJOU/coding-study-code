/*
 * ���α׷��ӽ� - Heap 
 * ����: �� �ʰ�
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

import java.util.*;

public class Solution {
	
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        initializeHeap(minHeap, scoville);
        
        int answer = 0;
        // repeat until heapSize become 1.
        while(minHeap.peek() < K && minHeap.size() >= 2) {
        	int weakest = minHeap.remove();
        	int secondWeakest = minHeap.remove();
        	int mixed = weakest + (secondWeakest * 2);
        	minHeap.add(mixed);
        	answer++;
        }
        
        // see if last one is valid.
        if(minHeap.size() <= 1 && minHeap.peek() < K) {
        	return -1;
        }
        return answer;
    }

	private void initializeHeap(PriorityQueue<Integer> minHeap, int[] scoville) {
		for(int i : scoville) {
			minHeap.add(i);
		}
		return;
	}
}


/* ��� ������ K �̻��� ���ں��� �ǵ��� �����.
 * ���ں��� ���̱� ���ؼ� ���ĵ��� ���´�.
 * ��� ������ K�̻��� �ɶ����� ���� Ƚ���� ��ȯ�Ѵ�.
 * �Ұ����ϴٸ� -1�� ��ȯ�Ѵ�.
 */
