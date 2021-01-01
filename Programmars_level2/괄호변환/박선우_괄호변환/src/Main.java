
public class Main {

	public static void main(String[] args) {
		String p = "())(";
		Solution sol = new Solution();
		System.out.println("원래 문자열: " + p);
		System.out.println("수정된 문자열: " + sol.solution(p));
		System.out.println("균형=====");
		
		p = "())(()()()";
		System.out.println("원래 문자열: " + p);
		System.out.println("수정된 문자열: " + sol.solution(p));
		System.out.println("균형=====");
		System.out.println();
		
		p = "(()())()";
		System.out.println("원래 문자열: " + p);
		System.out.println("수정된 문자열: " + sol.solution(p));
		System.out.println("올바=====");
		System.out.println();
		
		p = ")())((";
		System.out.println("원래 문자열: " + p);
		System.out.println("수정된 문자열: " + sol.solution(p));
		System.out.println("균형=====");
		System.out.println();
	}

}
