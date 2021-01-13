import java.util.*;

/*
 * 제목: 괄호 변환
 * 프로그래머스
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */

public class Solution {

	public String solution(String p) {
		String answer = "";

		if (p.isEmpty()) { // 빈 문자열
			System.out.println("빈 문자열입니다.");
			answer = p;
		}

		else if (isRight(p)) { // 올바름
			answer = p;
		}

		else { // 균형
			answer = toCorrectString(p);
		}

		return answer;
	}

	public String toCorrectString(String p) {
		if(p.length() == 0) {
			return "";
		}
		
		String[] arr = new String[2];
		arr = splitString(p);
		String u = arr[0];
		String v = arr[1];

		
		if(isRight(u)) {
			// v에 대해 1부터.
			return u + toCorrectString(v);
		}
		else {
			String answer = "("; 
			// v에 대해 1단계부터 한걸 붙임
			answer += toCorrectString(v) + ")";
			
			String temp = u.substring(1, u.length()-1);
			temp = reversParen(temp);
			answer += temp;
			return answer;
		}
	}
	
	


	// 가장 작은 u를 만드는 지점 계산. (u의 가장 오른쪽값. 리턴값까지 포함해서 자르기)	
	private String[] splitString(String p) {
		String arr[] = {p, ""};
		
		for(int i = 0; i < p.length(); i = i+2) {
			String u = p.substring(0, i+2);
			String v = p.substring(i+2);
			
			if(isBalanced(u)) {
				arr[0] = u;
				arr[1] = v;
				break;
			}
		}
		return arr;
	}


	private boolean isBalanced(String u) {
		int leftCount = 0;	// (
		int rightCount = 0; // )
		
		for(int i = 0; i < u.length(); i++) {
			if(u.charAt(i) == '(') {
				leftCount++;
			}
			else if(u.charAt(i) == ')') {
				rightCount++;
			}
		}
		
		if(leftCount == rightCount) {
			return true;
		}
		return false;
	}


	// 스택에 ()를 순서대로 쌓는다. ) 추가시 스택의 맨위가 (이면 ()를 삭제.
	// 마지막에 스택이 비어있으면 올바름, 남아있으면 안올바름(균형)
	private boolean isRight(String p) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < p.length(); i++) {
			char top;
			char val = p.charAt(i);
			
			if (val == '(') {
				stack.push(val);
			} 
			
			else {
				try {
					top = stack.peek();
				} catch (Exception e) {
					stack.push(val);
					continue;
				}

				if (top == '(') {
					stack.pop();
				} 
				else {
					stack.push(val);
				}
			}
		}

		if (stack.empty()) {
			return true;
		} else {
			return false;
		}

	}
	
	private String reversParen(String temp) {
		String res = "";
		
		for(int i = 0; i<temp.length();i++) {
			if(temp.charAt(i) == '(') {
				res += ')';
			}
			else {
				res += '(';
			}
		}
		return res;
	}

}

/*
 * 균형잡힌: 문자열에 ()만이 존재 +()의 수가 같다. 항상 균형임. 올바른: 균형잡힌 + ()짝이 전부 맞다. 균형잡힌 문자열은 올바른
 * 문자열로 변환할 수 있다.
 */
