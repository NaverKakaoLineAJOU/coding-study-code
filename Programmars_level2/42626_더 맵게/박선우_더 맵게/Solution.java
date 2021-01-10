/*
 * 프로그래머스 - Heap 
 * 제목: 더 맵게
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


/* 모든 음식이 K 이상의 스코빌이 되도록 만든다.
 * 스코빌을 높이기 위해서 음식들을 섞는다.
 * 모든 음식이 K이상이 될때까지 섞는 횟수를 반환한다.
 * 불가능하다면 -1을 반환한다.
 */
