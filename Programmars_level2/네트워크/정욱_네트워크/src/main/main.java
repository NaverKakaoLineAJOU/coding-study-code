package main;

public class main {

	public static void main(String[] args) {
		Solution test = new Solution();
		
		int[][] input = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(test.solution(3, input)+" = 2");
		System.out.println("----------------------------------------------");
		
		int[][] input2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(test.solution(3, input2)+" = 1");
		System.out.println("----------------------------------------------");
		
		int[][] input3 = {{1, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
		System.out.println(test.solution(5, input3)+" = 2");
		System.out.println("----------------------------------------------");
		
		int[][] input4 = {{1, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}};
		System.out.println(test.solution(4, input4)+" = 1");
		System.out.println("----------------------------------------------");
		
		int[][] input5 = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
		System.out.println(test.solution(4, input5)+" = 4");
		System.out.println("----------------------------------------------");
	}

}
