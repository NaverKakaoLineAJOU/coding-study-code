#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> citations) {
    const int length = citations.size();

    sort(citations.begin(), citations.end(), greater<int>());

    int initSuccessH = 0;
    int initSuccessPosition = -1;
    int lastFailH = 0;
    for(int i = 0; i < length; i++){
        int testH = citations[i];
        if((i+1) >= testH){
            initSuccessH = testH;
            initSuccessPosition = i;
            break;
        }
        lastFailH = testH;
    }

    if(initSuccessPosition == 0){
        return initSuccessH;
    }

    int upperHIndex = initSuccessPosition;
    if(initSuccessPosition < 0){
        upperHIndex = length;
    }
    else {
        upperHIndex = initSuccessPosition;
    }

    return initSuccessH > upperHIndex ? initSuccessH : upperHIndex;
}

int main(void){
    vector<int> v;
    v.push_back(9);
    v.push_back(4);
    v.push_back(4);
    v.push_back(1);
    cout << solution(v) << endl;
}