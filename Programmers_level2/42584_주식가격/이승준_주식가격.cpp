#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    const int length = prices.size();

    for(int startIndex = 0; startIndex < length - 1; startIndex++){
        int testNumber = prices[startIndex];
        bool findFalg = false;
        for(int testIndex = startIndex + 1; testIndex < length; testIndex++){
            if(prices[testIndex] < testNumber){
                answer.push_back(testIndex - startIndex);
                findFalg = true;
                break;
            }
        }
        if(findFalg == false){
            answer.push_back(length-startIndex-1);
        }
    }
    answer.push_back(0);
    return answer;
}

int main(void){
    solution({1,2,3,2,3});
}