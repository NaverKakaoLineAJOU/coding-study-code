
public class Main {

	public static void main(String[] args) {
		String p = "())(";
		Solution sol = new Solution();
		System.out.println("���� ���ڿ�: " + p);
		System.out.println("������ ���ڿ�: " + sol.solution(p));
		System.out.println("����=====");
		
		p = "())(()()()";
		System.out.println("���� ���ڿ�: " + p);
		System.out.println("������ ���ڿ�: " + sol.solution(p));
		System.out.println("����=====");
		System.out.println();
		
		p = "(()())()";
		System.out.println("���� ���ڿ�: " + p);
		System.out.println("������ ���ڿ�: " + sol.solution(p));
		System.out.println("�ù�=====");
		System.out.println();
		
		p = ")())((";
		System.out.println("���� ���ڿ�: " + p);
		System.out.println("������ ���ڿ�: " + sol.solution(p));
		System.out.println("����=====");
		System.out.println();
	}

}
