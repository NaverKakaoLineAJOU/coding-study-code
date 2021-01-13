package Level2;

import java.util.ArrayList;
import java.util.List;

public class groupPhoto {
	public int solution(int n, String[] data) {
		
		char[] friends= {'A','C','F','J','M','N','R','T'};
        makeCondition[] checkCond = new makeCondition[n];
        int cnt=0;
        for(String str :data) {
        	makeCondition test=new makeCondition(str.charAt(0), str.charAt(2),str.charAt(3), str.charAt(4)-48);
        	checkCond[cnt]=test;
        	cnt++;
        }
        
        String[] totalPhoto = {"A","C","F","J","M","N","R","T"};
        List<String> photo = new ArrayList<String>(); 
        
        for(int i=0;i<7;i++) {
        	for(String tmp:totalPhoto) {
        		for(char friend:friends) {
        			
        			if(tmp.contains(""+friend))
        				continue;
        			
        			String checkString=tmp+friend;
        					
        			int checking=0;
        			for(makeCondition chk:checkCond) {
        				if(!chk.check(checkString)) {
        					checking=-1;
        					break;
        				}
        			}
        			
        			if(checking ==-1) {
        				continue;
        			}
        			
        			else {
        				photo.add(checkString); 				
        			}
        		}
        		
        	}
        	totalPhoto = new String[photo.size()];
        	
        	for(int pos=0;pos<photo.size();pos++) {
        		totalPhoto[pos]=photo.get(pos);
        	}
        	System.out.println(totalPhoto.length);
        	photo = new ArrayList<String>(); 
        	
        }

        return totalPhoto.length;
    }
}

class makeCondition{
	char person1;
	char person2;
	char cond;
	int condNum;
	
	public makeCondition(char p1,char p2, char cond, int condNum) {
		this.person1=p1;
		this.person2=p2;
		this.cond=cond;
		this.condNum=condNum;
	}
	
	public Boolean check(String nowStr) {
		int p1Pos =nowStr.indexOf(this.person1);
		int p2Pos= nowStr.indexOf(this.person2);
		if(p1Pos==-1 || p2Pos==-1) {
			return true;
		}
		
		else if(this.cond=='<') {
			return Math.abs(p1Pos-p2Pos)-1 < this.condNum;
		}
		
		else if(this.cond=='>') {
			return Math.abs(p1Pos-p2Pos)-1 > this.condNum;
		}
		
		else if (this.cond=='=') {
			return Math.abs(p1Pos-p2Pos)-1 == this.condNum;
		}
			
		return true;
	}
}

