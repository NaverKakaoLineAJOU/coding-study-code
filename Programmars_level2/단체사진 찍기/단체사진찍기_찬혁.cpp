#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string friends = "ACFJMNRT";
vector<char> line;
vector<int> visited(8,0);
int answer;

bool checkSatisfy(int diff, char c, int gap){
    if(c == '=')
        return diff == gap+1;
    else if(c == '>')
        return diff > gap+1;
    else
        return diff < gap+1;
}


//각 줄마다 모든 조건을 만족하는지
void isSatisfy(string line, vector<string> data){
    
    bool correct;
    
    //각 조건 체크
    for(int i=0; i<data.size(); i++){
        
        int f1, f2;
        f1 = line.find(data[i][0]);
        f2 = line.find(data[i][2]);
        
        correct = 
            checkSatisfy(f1 - f2 > 0 ? f1-f2 : f2-f1, data[i][3], data[i][4]-'0');
        
        if(!correct) break;
    }

    if(correct)
        answer++;
}

//nPr
void perm(int n, int r, int cnt, vector<char> line, vector<string> data){
    if(cnt == r){
        string strline;
        for(int i=0; i<8; i++)
            strline +=line[i];
        isSatisfy(strline, data);
        return;
    }
    
    for(int i=0; i<n; i++){
        if(!visited[i]){
            visited[i] = 1;
            line.push_back(friends[i]);
            
            perm(n, r, cnt+1, line, data);
            
            visited[i] = 0;
            line.pop_back();
        }
    }
    
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    
    answer = 0;
    
    //8! = 8P8 검증-> 시간초과
    //perm(8, 8, 0, line, data);
    
    //next_permutation 사용
    do{
        bool correct;
    
        //각 조건 체크
        for(int i=0; i<data.size(); i++){

            int f1, f2;
            f1 = friends.find(data[i][0]);
            f2 = friends.find(data[i][2]);

            correct = 
                checkSatisfy(f1 - f2 > 0 ? f1-f2 : f2-f1, data[i][3], data[i][4]-'0');

            if(!correct) break;
        }

        if(correct)
            answer++;
        
    }while(next_permutation(friends.begin(), friends.end()));
    
    return answer;
}