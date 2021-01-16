#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

void merge(priority_queue<int, vector<int>, greater<int>>& minHeap);
bool check(priority_queue<int, vector<int>, greater<int>>& minHeap, int k);

int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>> minHeap;
    int mergeCount = 0;

    for(auto iter = scoville.begin(); iter != scoville.end(); iter++){
        minHeap.push(*iter);
    }

    while(check(minHeap, K) == false){
        if(minHeap.size() <= 1){
            return -1;
        }

        merge(minHeap);
        mergeCount++;
    }

    return mergeCount;
}

void merge(priority_queue<int, vector<int>, greater<int>>& minHeap){
    int num1 = minHeap.top();
    minHeap.pop();
    int num2 = minHeap.top();
    minHeap.pop();
    
    int newValue = num1 + (num2*2);
    minHeap.push(newValue);

    return;
}

bool check(priority_queue<int, vector<int>, greater<int>>& minHeap, int k){
    if(minHeap.top() >= k){
        return true;
    }

    return false;
}