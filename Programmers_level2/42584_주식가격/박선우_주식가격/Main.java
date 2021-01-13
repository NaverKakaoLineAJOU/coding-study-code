
public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] prices = {1, 2, 3, 2, 3};
		System.out.print("정답: 4 3 1 1 0\n" +  "내답: ");
		int[] arr = sol.solution(prices);
		
		for(int i:arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] prices2 = {1, 2, 3, 2, 3, 3, 1};
		System.out.print("정답: 6 5 1 3 2 1 0\n" +  "내답: ");
		int[] arr2 = sol.solution(prices2);
		
		for(int i:arr2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		return;
	}

}
