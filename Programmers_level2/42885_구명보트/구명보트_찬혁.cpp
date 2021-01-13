#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {

    sort(people.begin(), people.end());
    
    int l=0;
    int r=people.size()-1;
    int moved =0;
    
    while(true){
        if(l > r) 
            break;
        if(l == r){
            moved++;
            break;
        }

        if(people[l] + people[r] <= limit){
            l++;
            r--;
            moved++;
        }
        else{
            r--;
            moved++;
        }

    }
    
    return moved;
}