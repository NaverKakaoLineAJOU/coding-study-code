package main;

import java.util.ArrayList;

public class Solution {
	public int solution(String[][] clothes) {
        int answer = 0;
        
        ArrayList<String[]> sortClothes = new ArrayList<>();
        
        sortClothes = sorting(clothes,sortClothes);
        
        answer = calNumCase(sortClothes, 0) - 1;
        
        return answer;
    }

	private ArrayList<String[]> sorting(String[][] clothes,ArrayList<String[]> sortClothes) {
		int check = 0;
        
        for(int sur = 0 ; sur < clothes.length ; sur++){
        	check = 0;
        	
        	for(int sur1 = 0; sur1 < sortClothes.size(); sur1++){
        		if(clothes[sur][1].equals(sortClothes.get(sur1)[0])){
        			sortClothes.get(sur1)[1] = Integer.toString(Integer.parseInt(sortClothes.get(sur1)[1]) + 1);
        			
        			check = 1;
        			
        			break;
        		}
        	}
        	if(check == 0){
        		String[] input = {clothes[sur][1], "1"};
        		sortClothes.add(input);
        	}
        }
		return sortClothes;
	}

	private int calNumCase(ArrayList<String[]> sortClothes, int index) {
		if(sortClothes.size() <= index){
			return 1;
		}
		
		return (Integer.parseInt(sortClothes.get(index)[1])+1) * calNumCase(sortClothes, index + 1);
	}
}
