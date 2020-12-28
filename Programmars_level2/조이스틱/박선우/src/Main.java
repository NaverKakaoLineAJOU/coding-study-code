

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		String name = "AABAAAAAAAAABBB";
		System.out.println(name+": 11");
		System.out.println(sol.solution(name));

		name = "BBAAABA";
		System.out.println(name+": 7");
		System.out.println(sol.solution(name));
		
		name = "CANAAAAANAN";
		System.out.println(name+": 48");
		System.out.println(sol.solution(name));
		
		name = "BAABAAAAAB";
		System.out.println(name+": 10");
		System.out.println(sol.solution(name));
		
	}

}
