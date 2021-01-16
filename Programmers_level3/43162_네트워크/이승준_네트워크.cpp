#include <string>
#include <vector>

using namespace std;

void mark(vector<vector<int>>* graph, vector<bool>* isVisit, int nowNodeId);

int solution(int n, vector<vector<int>> computers) {
    vector<bool> isVisit(n, false);
    int networkCount = 0;

    for(int i = 0; i < n; i++){
        if(isVisit[i] == true){
            continue;
        }

        networkCount++;
        mark(&computers, &isVisit, i);
    }

    return networkCount;
}

void mark(vector<vector<int>>* graph, vector<bool>* isVisit, int nowNodeId){
    isVisit->at(nowNodeId) = true;

    vector<int> neighorbor = graph->at(nowNodeId);
    for(int i = 0; i < neighorbor.size(); i++){
        if(i == nowNodeId || neighorbor[i] != 1){
            continue;
        }

        if(isVisit->at(i) == true){
            continue;
        }

        mark(graph, isVisit, i);
    }
}