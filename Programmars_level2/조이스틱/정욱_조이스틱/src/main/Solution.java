package main;

//시작은 모두 A로 초기화되어있음

/*
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
*/

/*
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 */

class Solution {
    public int solution(String name) {
    	char[] nameArray = name.toCharArray();
    	
        int answer = 0;				//return 값
        int checkTriger = 0;        //연속된 A인지 확인하는 인자. 1이면 연속중, 0이면 연속중이 아님
        int returnCheck = 0;        //왼쪽으로 되돌아 가는것이 더 빠를 때 A가 어디까지 이어져있는지 index를 체크
        int countHold = 0;          //A가 몇번 연달아 나왔는지 저장하는 변수
        int countA = 0;             //A가 몇번 연달아 나왔는지 체크하는 변수
        int sur = 0;                //index 확인
        
        for(char checkChar : nameArray){
        	answer += this.calChar(checkChar);
        	
        	//-----------------조이스틱 좌우 횟수 계산---------
        	if(checkChar == 'A' && checkTriger < 2){
        		checkTriger = 1;
        		countA++;
        	}
        	else if(checkChar != 'A' && checkTriger == 1){
        		checkTriger = 0;
        		
        		if(countA >= sur - countA){
					returnCheck = sur - 1;
					
					countHold = countA;
				}
        		
        		countA = 0;
        	}
        	//--------------------------------------
        	
        	
        	sur++;
        }
       
        answer += name.length() - 1 - countHold + (returnCheck - countHold);
        
        return answer;
    }
    
    //조이스틱 위아래 횟수 계산
    public int calChar(char checkChar){
    	int answer = 0;
    	
    	if(checkChar < 79){
			answer = (checkChar - 65);
		}
		else{
			answer = (90 - checkChar) + 1;
		}
    	
    	return answer;
    }
}

/*
 대문자A = 65
 중간값 = 77.5
 대문자Z = 90
 */

/*
 
 baab
 
 
 */

