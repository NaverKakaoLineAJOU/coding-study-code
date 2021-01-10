package main;

public class main {

	public static void main(String[] args) {
		Solution test = new Solution();
		
		int[] input = {70, 50, 80, 50};
		System.out.println(test.solution(input, 100) + " = 3");
		
		int[] input2 = {70, 50, 80};
		System.out.println(test.solution(input2, 100) + " = 3");
		
		int[] input3 = {40, 40, 40, 40, 40, 40};
		System.out.println(test.solution(input3, 120) + " = 3");
		
		int[] input4 = {240};
		System.out.println(test.solution(input4, 240) + " = 1");
		
		int[] input5 = {240, 230, 200, 100, 140, 150, 40, 20, 10};
		System.out.println(test.solution(input5, 240) + " = 5");
	}

}
