
public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		String[] data1 = {"N~F=0", "R~T>2"};
		int n = 2;
		int res = sol.solution(n, data1);
		System.out.println("정답: 3648, " + "내답: " + res);
		System.out.println();
		
		n = 2;
		String[] data2 = {"M~C<2", "C~M>1"};
		res = sol.solution(n, data2);
		System.out.println("정답: 0, " + "내답: " + res);
		System.out.println();

	}

}
