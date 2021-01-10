#include <string>
#include <vector>
#include <iostream>

using namespace std;

struct info{
    int num;
    string kind;
};
vector<info> clothes_list; //의상 종류별 갯수 저장하는 벡터

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    info clothinfo;
    int same = 0;
    
    for(int i=0; i<clothes.size(); i++){
    
        same = 0;
        clothinfo.num = 1;
        clothinfo.kind = clothes[i][1];
        
        for(int j=0; j<clothes_list.size(); j++){
            //같은 종류가 있으면 갯수 +1
            if(clothes_list[j].kind == clothinfo.kind){
                clothes_list[j].num++;
                same = 1;
                break;
            }    
        }
        
        //새로운 종류라면 벡터에 추가
        if(!same){
            clothes_list.push_back(clothinfo);
        }
        
    }
    
    for(info f : clothes_list)
        answer *= f.num+1;
    
    return answer-1;
}