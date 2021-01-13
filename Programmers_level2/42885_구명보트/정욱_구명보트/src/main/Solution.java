package main;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	//시간복잡도가 n제곱인것으로 풀음
//	public int solution(int[] people, int limit) {
//        int answer = 0;
//        int weight = 0;
//        
//        ArrayList<Integer> sortPeople = new ArrayList<>();
//        
//        for(int sur = 0; sur < people.length ; sur++){
//        	sortPeople.add(people[sur]);
//        }
//        
//        sortPeople.sort(Collections.reverseOrder());
//        
//        for(int sur = 0 ; sur < sortPeople.size() ; sur++){
//        	weight = sortPeople.get(0);
//        	sortPeople.remove(0);
//        	sur--;
//        	
//        	for(int roop = 0 ; roop < sortPeople.size() ; roop++){
//        		if((weight + sortPeople.get(roop)) <= limit){
//        			sortPeople.remove(roop);
//        			
//        			break;
//        		}
//        	}
//        	answer++;
//        }
//        
//        return answer;
//    }
	
	
	//시간복잡도가 200n인것으로 풀음
	public int solution(int[] people, int limit) {
        int answer = 0;
        int weight = 0;
        
        int[] hashWeight = new int[241];
        
        for(int sur = 0 ; sur < people.length ; sur++){
        	hashWeight[people[sur]] += 1;
        }
        
        for(int sur = 240 ; sur > 0 ; sur--){
        	if(hashWeight[sur] > 0) {
        		weight = sur;
        		hashWeight[sur] -= 1;
        		
        		for(int roop = (limit - weight); roop > 0 ; roop--){
        			if(hashWeight[roop] > 0){
        				hashWeight[roop] -= 1;
        				
        				break;
        			}
        		}
        		answer++;
        		
        		sur = 240;
			}
        }
        
        return answer;
    }
}
