/*
 * ���α׷��ӽ�
 * ����: H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */

public class Solution {
	
    public int solution(int[] citations) {
        int answer = 0;
        int hIndex=0;
        
        int biggest = getBiggestNumInArr(citations);
        
        for(int h = 0; h <= biggest; h++) {
        	hIndex = getCitationCountBiggerThan(citations, h);
        	if(hIndex < h) {
        		break;
        	}
        	else {
        		answer = h; 
        	}
        }
        
        return answer;
    }
    
    public int getCitationCountBiggerThan(int[] citations, int h) {
    	int hIndex = 0;
    	
    	for(int i = 0; i < citations.length; i++) {
    		if(citations[i] >= h) {
    			hIndex++;
    		}
    	}
    	return hIndex;
    }

    public int getBiggestNumInArr(int[] arr) {
    	int biggest = 0;
    	
    	for(int i=0; i < arr.length; i++) {
    		if(arr[i] > biggest) {
    			biggest = arr[i];
    		}
    	}
    	return biggest;
    }
}


/*
 * H-index: h. �������� �����
 * ��ü n �� ��, h�� �̻� �ο�� ���� h�̻��̰�
 * n-h�� ���� h�� ���� �ο�Ǿ���.
 * �̶��� h�� �ִ밪 == H-Index
 * 
 * �Է�: citations �� ���� �ο� Ƚ���� ���� �迭
 * ��ȯ: H-Index
 */


