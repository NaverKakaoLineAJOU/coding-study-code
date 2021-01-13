package main;

import java.util.ArrayList;

public class Solution {
	public int solution(int n, String[] data) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        answer = arrayData(0, list, n, data);
        
        return answer;
    }
	
	//case분류함수 '='인경우 0, '<'인경우 1, '>'인경우 2, 아무것도 아닌경우 -1 반환
	public int categorizeCase(String data){
		if(data.charAt(3) == '='){
			return 0;
		}
		else if(data.charAt(3) == '<'){
			return 1;
		}
		else if(data.charAt(3) == '>'){
			return 2;
		}
		else{
			return -1;
		}
	}
		
	public int arrayData(int count,ArrayList<Integer> list, int n, String[] data){
		int result = 0;
		
		if(count == 8){
			ArrayList<Character> resultArray = new ArrayList<>();
			int caseNum = 0;
			int index1 = -1;
			int index2 = -1;
			
			for(int sur = 0 ; sur < 8 ; sur++){
				if(list.get(sur) == 0){
					resultArray.add('A');
				}
				else if(list.get(sur) == 1){
					resultArray.add('C');
				}
				else if(list.get(sur) == 2){
					resultArray.add('F');
				}
				else if(list.get(sur) == 3){
					resultArray.add('J');
				}
				else if(list.get(sur) == 4){
					resultArray.add('M');
				}
				else if(list.get(sur) == 5){
					resultArray.add('N');
				}
				else if(list.get(sur) == 6){
					resultArray.add('R');
				}
				else if(list.get(sur) == 7){
					resultArray.add('T');
				}
			}
			for(int sur = 0 ; sur < n ; sur++){
				index1 = resultArray.indexOf(data[sur].charAt(0));
				index2 = resultArray.indexOf(data[sur].charAt(2));
				
				caseNum = categorizeCase(data[sur]);
				
				if(caseNum == 0){
					if(index1 > index2){
						if((index1-index2) != Character.getNumericValue(data[sur].charAt(4)) + 1){
							return 0;
						}
					}
					else{
						if((index2-index1) != Character.getNumericValue(data[sur].charAt(4)) + 1){
							return 0;
						}
					}
				}
				else if(caseNum == 1){
					if(index1 > index2){
						if(!((index1-index2) < Character.getNumericValue(data[sur].charAt(4)) + 1)){
							return 0;
						}
					}
					else{
						if(!((index2-index1) < Character.getNumericValue(data[sur].charAt(4)) + 1)){
							return 0;
						}
					}
				}
				else if(caseNum == 2){
					if(index1 > index2){
						if(!((index1-index2) > Character.getNumericValue(data[sur].charAt(4)) + 1)){
							return 0;
						}
					}
					else{
						if(!((index2-index1) > Character.getNumericValue(data[sur].charAt(4)) + 1)){
							return 0;
						}
					}
				}
			}
			return 1;
		}
		
		for(int sur = 0 ; sur < 8 ; sur++){
			if(count == 0){
				list.clear();
			}
			
			if(!list.contains(sur)){
				list.add(sur);
				
				result += arrayData(count + 1, list, n, data);
				
				list.remove((Integer)sur);
				
			}			
		}
		
		return result;
	}
}
