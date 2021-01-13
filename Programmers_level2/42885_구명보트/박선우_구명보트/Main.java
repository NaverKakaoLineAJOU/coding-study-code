
public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int res = sol.solution(people, limit);
		System.out.println("정답: 3," + "내답: " + res);
		System.out.println();
		
		
		int[] people2 = {70, 80, 50};
		int limit2 = 100;
		int res2 = sol.solution(people2, limit2);
		System.out.println("정답: 3," + "내답: " + res2);
		System.out.println();
		
		
		return;
	}

}
