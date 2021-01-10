
public class Main {

	public static void main(String[] args) {
		String[][] clothes1 = {
				{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"}};
		
		Solution sol = new Solution();
		sol.solution(clothes1);
		System.out.println();

		
		String[][] clothes2 = {
				{"crow_mask", "face"},
				{"blue_sunglasses", "face"},
				{"smoky_makeup", "face"}};
		sol.solution(clothes2);
		System.out.println();
		
		
		String[][] clothes3 = {
				{"crow_mask", "2"},
				{"blue_sunglasses", "1"},
				{"smoky_makeup", "1"}};
		sol.solution(clothes3);
		System.out.println();
	
		
		System.out.println("======HashMap======");
		SolutionWithHashmap sol2 = new SolutionWithHashmap();
		
		String[][] clothes4 = {
				{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"}};
		sol2.solution(clothes4);
				
		String[][] clothes5 = {
				{"crow_mask", "face"},
				{"blue_sunglasses", "face"},
				{"smoky_makeup", "face"}};
		sol2.solution(clothes5);
		
		String[][] clothes6 = {
				{"crow_mask", "2"},
				{"blue_sunglasses", "1"},
				{"smoky_makeup", "1"}};
		sol2.solution(clothes6);

	
	
	}
}
