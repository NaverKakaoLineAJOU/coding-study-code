import java.util.*;

/*
 * ����: ��ȣ ��ȯ
 * ���α׷��ӽ�
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */

public class Solution {

	public String solution(String p) {
		String answer = "";

		if (p.isEmpty()) { // �� ���ڿ�
			System.out.println("�� ���ڿ��Դϴ�.");
			answer = p;
		}

		else if (isRight(p)) { // �ùٸ�
			answer = p;
		}

		else { // ����
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
			// v�� ���� 1����.
			return u + toCorrectString(v);
		}
		else {
			String answer = "("; 
			// v�� ���� 1�ܰ���� �Ѱ� ����
			answer += toCorrectString(v) + ")";
			
			String temp = u.substring(1, u.length()-1);
			temp = reversParen(temp);
			answer += temp;
			return answer;
		}
	}
	
	


	// ���� ���� u�� ����� ���� ���. (u�� ���� �����ʰ�. ���ϰ����� �����ؼ� �ڸ���)	
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


	// ���ÿ� ()�� ������� �״´�. ) �߰��� ������ ������ (�̸� ()�� ����.
	// �������� ������ ��������� �ùٸ�, ���������� �ȿùٸ�(����)
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
 * ��������: ���ڿ��� ()���� ���� +()�� ���� ����. �׻� ������. �ùٸ�: �������� + ()¦�� ���� �´�. �������� ���ڿ��� �ùٸ�
 * ���ڿ��� ��ȯ�� �� �ִ�.
 */
