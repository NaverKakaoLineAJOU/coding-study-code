#include <string>
#include <vector>
#include <list>
#include <cstdlib>
#include <iostream>

using namespace std;

struct condition {
    int oderer;
    char conditionType;
    int operand;
    int distance;
};

list<list<int>> permitationListList;
int validCount = 0;

int char2int(char person){
    switch (person) {
        case 'A':
            return 0;
        case 'C':
            return 1;
        case 'F':
            return 2;
        case 'J':
            return 3;
        case 'M':
            return 4;
        case 'N':
            return 5;
        case 'R':
            return 6;
        case 'T':
            return 7;
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
    }
}

condition conditionParser(string conditionString){
    condition parsedCondition;
    parsedCondition.oderer = char2int(conditionString[0]);
    parsedCondition.conditionType = conditionString[3];
    parsedCondition.operand = char2int(conditionString[2]);
    parsedCondition.distance = char2int(conditionString[4]);

    return parsedCondition;
}

bool stateValidater(list<int> permitationList, condition conditionList[], int conditionCount){
    int positionList[8];
    int index = 0;
    for(auto iter = permitationList.begin(); iter != permitationList.end(); iter++){
        positionList[*iter] = index;//위치->사람 배열인 state에서 사람->위치 배열로 변환
        index++;
    }

    for(int i=0; i<conditionCount; i++){
        int person1Position = positionList[conditionList[i].oderer];
        int person2Position = positionList[conditionList[i].operand];
        int distance = abs(person1Position-person2Position) - 1;
        if(conditionList[i].conditionType == '=' && distance != conditionList[i].distance){
            return false;
        }
        else if(conditionList[i].conditionType == '>' && distance <= conditionList[i].distance){
            return false;
        }
        else if(conditionList[i].conditionType == '<' && distance >= conditionList[i].distance){
            return false;
        }
    }

    return true;
}

bool preStateValidater(list<int> permitationList, condition conditionList[], int conditionCount){
    int positionList[8];
    for(int i=0; i<8; i++){
        positionList[i] = -1;
    }
    int index = 0;
    for(auto iter = permitationList.begin(); iter != permitationList.end(); iter++){
        positionList[*iter] = index;//위치->사람 배열인 state에서 사람->위치 배열로 변환
        index++;
    }

    for(int i=0; i<conditionCount; i++){
        int person1Position = positionList[conditionList[i].oderer];
        int person2Position = positionList[conditionList[i].operand];
        if(person1Position == -1 || person2Position == -1){
            continue;
        }
        int distance = abs(person1Position-person2Position) - 1;
        if(conditionList[i].conditionType == '=' && distance != conditionList[i].distance){
            return false;
        }
        else if(conditionList[i].conditionType == '>' && distance <= conditionList[i].distance){
            return false;
        }
        else if(conditionList[i].conditionType == '<' && distance >= conditionList[i].distance){
            return false;
        }
    }

    return true;
}

void permitation(list<int> permitationList, list<int> leftItemList, condition conditionList[], int conditionCount){
    if(leftItemList.size() == 0){
        if(preStateValidater(permitationList, conditionList, conditionCount)){
            validCount++;
        };
        return;
    }

    for(auto it = leftItemList.begin(); it != leftItemList.end(); it++){
        list<int> newPermitationList = permitationList;
        newPermitationList.push_back(*it);
        list<int> newLeftItemList = leftItemList;
        newLeftItemList.remove(*it);
        if(preStateValidater(permitationList, conditionList, conditionCount) == false){
            return;
        }
        permitation(newPermitationList, newLeftItemList, conditionList, conditionCount);
    }
}

int solution(int n, vector<string> data) {
    permitationListList.clear();
    validCount = 0;
    condition conditionList[100];

    for(int i=0; i<n; i++){
        conditionList[i] = conditionParser(data[i]);
    }

    list<int> permitationList;
    list<int> leftItemList = {0, 1, 2, 3, 4, 5, 6, 7};

    permitation(permitationList, leftItemList, conditionList, n);

    return validCount;
}

int main(void){
    vector<string> condi;

    for(int i=0; i<100; i++){
        condi.push_back("A~T>1");
    }

    cout << solution(100, condi) << endl;

    return 0;
}