package main;

import java.util.ArrayList;

//네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
//예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
//따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

//컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

//제한사항
//컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
//각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
//i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
//computer[i][i]는 항상 1입니다.


public class Solution {
	
	//로직은 bfs로 따라감. bfs를 거치면서 checkComputer로 들렀는지 안들렀는지 체크, 안들른곳은 bfs를 다시 적용하여 새로운 네트워크로 계산.
	//check가 이미 1이라면 그 이후 연결은 이미 다 연결된것들이 체크 되었으므로 굳이 확인 안해도 됨
	public int solution(int n, int[][] computers) {
        int answer = 0;
        int targetComputer;
        int[] checkComputer = new int[n];
        ArrayList<Integer> queueComputer = new ArrayList<>();
        
        //배열확인
        //this.checkMatrix(n, computers);
        
        for(int sur = 0 ; sur < n ; sur++){
        	if(checkComputer[sur] == 0){
        		checkComputer[sur] = 1;
        		
        		for(int roop = 0 ; roop < n ; roop++){
        			//check가 이미 1이라면 그 이후 연결은 이미 다 체크가 되어있으므로 굳이 확인 안해도 됨
        			if(computers[sur][roop] == 1 && checkComputer[roop] == 0){
        				checkComputer[roop] = 1;
        				queueComputer.add(roop);
        			}
        		}
        		        		
        		while(!queueComputer.isEmpty()){
        			targetComputer = queueComputer.get(0);
        			queueComputer.remove(0);
        			
        			for(int roop = 0 ; roop < n ; roop++){
        				if(roop == targetComputer){
        					//computer[i][i]인 경우 체크 안하고 패스
        				}
        				else if(computers[targetComputer][roop] == 1 && checkComputer[roop] == 0){
            				checkComputer[roop] = 1;
            				queueComputer.add(roop);
            			}
            		}
        		}
        		
        		answer++;
        	}
        }
        return answer;
    }
	
	//입력된 배열 확인
	public void checkMatrix(int n, int[][] computers){
		for(int sur = 0 ; sur < n ; sur++){
        	for(int roop = 0 ; roop < n ; roop++){
        		System.out.print(computers[sur][roop]+" ");
        	}
        	System.out.println();
        }
	}
}
