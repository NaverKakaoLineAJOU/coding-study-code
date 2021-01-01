package main;

import java.util.ArrayList;

//'(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
//그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.

/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
4-3. ')'를 다시 붙입니다. 
4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
4-5. 생성된 문자열을 반환합니다.
*/

public class Solution {
	 public String solution(String p) {
	        String answer = "";
	                
	        if(p.length() == 0){
	        	return answer;
	        }
	        answer = fixString(p);
	        
	        return answer;
	    }

	private String fixString(String input) {
		int countLeft = 0;
		int countRight = 0;		
		int check = 0;
		int sur;
		int devide;
		String u = "";
		String v = "";
		String result = "";
		
		if(input.length() == 0){
    		return "";
    	}
    	
		u += input.charAt(0);
		
		if(input.charAt(0) == '('){
			countLeft++;
		}
		else {
			countRight++;
			
			check = 1;
		}
		
    	for(sur = 1 ; sur < input.length() ; sur++){
    		u += input.charAt(sur);
    		
    		if(input.charAt(sur) == '('){
    			countLeft++;
    		}
    		else {
				countRight++;
			}
    		if(countLeft < countRight){
    			check = 1;
    		}
    		else if(countLeft == countRight){
    			break;
    		}
    	}
    	
    	devide = sur + 1;
    	
    	for(sur++ ;sur < input.length() ; sur++){
    		v += input.charAt(sur);
    	}
    	
    	if(check == 1){
    		result += '(';
    		result += this.fixString(v);
    		result += ')';
    		
    		ArrayList<Character> target = new ArrayList<>();
    		
    		for(int roop = 0 ; roop < devide; roop++){
        		target.add(input.charAt(roop));
        	}
    		
    		target.remove(0);
    		target.remove(target.size() - 1);
    		
    		for(int roop = 0 ; roop < target.size(); roop++){
        		if(target.get(roop) == '('){
        			result += ')';
        		}
        		else {
        			result += '(';
    			}
        	}
    	}
    	
    	else{
    		result += u;
    		result += this.fixString(v);
    	}
		
		return result;
	}
}
