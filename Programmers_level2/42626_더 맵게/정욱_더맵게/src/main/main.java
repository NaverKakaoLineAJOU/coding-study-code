package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int[] input = {1, 2, 3, 9, 10, 12};
		System.out.println(test.solution(input,7)+" = 2");
		System.out.println("----------------------------------------------");
		
		int[] input2 = {0, 0, 0, 0};
		System.out.println(test.solution(input2,3)+" = -1");
		System.out.println("----------------------------------------------");
	}

}
