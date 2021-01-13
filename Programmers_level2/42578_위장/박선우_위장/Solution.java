/*
 * 프로그래머스
 * 제목: 해시 - 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */

public class Solution {

    public int solution(String[][] clothes) {
    	int closetSize = 11111;
    	int[] closet = new int[closetSize];
        
        for(int i = 0; i < clothes.length; i++) {
        	String clothesType = clothes[i][1];
        	int index = hashCategoryToIndex(clothesType, closetSize);
        	closet[index]++;
        }
        
        int combinations = calculateAllPossibilities(closet);
        System.out.println("조합: " + combinations);
        return combinations;
    }

	private int calculateAllPossibilities(int[] closet) {
		int res = 1;
		
		for(int i=0; i < closet.length; i++) {
			res *= (closet[i] + 1);
		}
		return res - 1;
	}

	public int hashCategoryToIndex(String category, int closetSize) {
    	int index = 0;
    	int sum = 0;
    	int count = 1;
    	
    	for(int i = 0; i < category.length(); i++) {
    		sum += category.charAt(i) * count;
    		count *= 2;
    	}
    	
    	index = sum % closetSize;
    	System.out.println("해시값: " + index);
    	
    	return index;
    }
}
