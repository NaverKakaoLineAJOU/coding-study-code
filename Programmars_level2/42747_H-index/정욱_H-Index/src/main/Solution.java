package main;

/*
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 *어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 */

public class Solution {
	public int solution(int[] citations) {
        int answer = 0;
        int count1;             //h번이상 인용된 논문 카운트
        int count2;             //h번이하 인용된 논문 카운트
        
        //target을 1부터 대입
        for(int target = 1 ; target < citations.length + 1 ; target++){
        	count1 = 0;
        	count2 = 0;
        	
        	//target번이상 인용됬는지 카운트
        	for(int roop = 0 ; roop < citations.length ; roop++){
        		if(target <= citations[roop]){
        			count1++;
        		}
        		else{
        			count2++;
        		}
        	}
        	
        	//target번이상 인용된 논문의 수가 target과 같거나 크고, target번이하 인용된 논문의 수가 target과 같거나 작은경우 answer에 대입
        	if(count1 >= target && count2 <= target){
        		answer = target;
        		
        	}
        }
        
        return answer;
    }
}
