#include <iostream>
using namespace std;

int main(void){
    int sampleTestCaseCount = 0;
    int systemTestCaseCount = 0;
    int yourAnwser = 0;
    int correctAnwser = 0;

    cin >> sampleTestCaseCount >> systemTestCaseCount;

    for(int i = 0; i < sampleTestCaseCount; i++){
        cin >> correctAnwser >> yourAnwser;
        if(correctAnwser != yourAnwser){
            cout << "Wrong Answer" << endl;
            return 0;
        }
    }

    for(int i = 0; i < systemTestCaseCount; i++){
        cin >> correctAnwser >> yourAnwser;
        if(correctAnwser != yourAnwser){
            cout << "Why Wrong!!!" << endl;
            return 0;
        }
    }

    cout << "Accepted" << endl;

    return 0;
}