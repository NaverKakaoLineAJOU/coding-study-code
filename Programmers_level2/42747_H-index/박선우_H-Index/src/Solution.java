/*
 * 프로그래머스
 * 제목: H-Index
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
 * H-index: h. 과학자의 영향력
 * 전체 n 편 중, h번 이상 인용된 논문이 h이상이고
 * n-h의 논문이 h번 이하 인용되었다.
 * 이때의 h의 최대값 == H-Index
 * 
 * 입력: citations 각 논문의 인용 횟수를 담은 배열
 * 반환: H-Index
 */


