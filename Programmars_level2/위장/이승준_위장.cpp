#include <string>
#include <vector>
#include <map>

using namespace std;

void backtracking(int depth, bool* flagList, int typeCount, int* clothList, int* sum);
int numberOfCases(bool* flagList, int typeCount, int* clothList);

int solution(vector<vector<string>> clothes) {
    int clotheCount = clothes.size();
    map<string, int> clothMap;

    for(int i=0; i<clotheCount; i++){
        vector<string> cloth = clothes[i];
        string type = cloth[1];

        if(clothMap.find(type) == clothMap.end()){
            //map에 없음
            clothMap.insert(pair<string, int>(type, 1));
        }
        else {
            //map에 있음
            int count = clothMap[type];
            clothMap[type] = count + 1;
        }
    }

    int typeCount = clothMap.size();
    int* clothList = new int[typeCount];
    int index = 0;
    map<string, int>::iterator it = clothMap.begin();

    for(it; it != clothMap.end(); it++){
        clothList[index] = it->second;
        index++;
    }

    int countSum = 0; //경우의 수 합
    bool* flagList = new bool[typeCount];
    for(int i=0; i<typeCount; i++){
        flagList[i] = false;
    }

    backtracking(0, flagList, typeCount, clothList, &countSum);

    return countSum;
}

void backtracking(int depth, bool* flagList, int typeCount, int* clothList, int* sum){
    if(depth >= typeCount){
        *sum += numberOfCases(flagList, typeCount, clothList);
        return;
    }

    flagList[depth] = false;
    backtracking(depth+1, flagList, typeCount, clothList, sum);
    flagList[depth] = true;
    backtracking(depth+1, flagList, typeCount, clothList, sum);
}

int numberOfCases(bool* flagList, int typeCount, int* clothList){
    int sum = 0;

    for(int i=0; i < typeCount; i++){
        if(flagList[i]){
            if(sum == 0){
                sum = clothList[i];
            }
            else{
                sum *= clothList[i];
            }
        }
    }

    return sum;
}

int main(void){
    vector<vector<string>> input;
    vector<string> v1{"yellow_hat", "headgear"};
    vector<string> v2{"blue_sunglasses", "eyewear"};
    vector<string> v3{"green_turban", "headgear"};
    input.push_back(v1);
    input.push_back(v2);
    input.push_back(v3);
    solution(input);
}