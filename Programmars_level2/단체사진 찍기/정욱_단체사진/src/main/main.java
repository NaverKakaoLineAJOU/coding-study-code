package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		String[] input = {"N~F=0", "R~T>2"};
		System.out.println(test.solution(2, input)+" = 3648");
		
		String[] input2 = {"M~C<2", "C~M>1"};
		System.out.println(test.solution(2, input2)+" = 0");
	}

}
