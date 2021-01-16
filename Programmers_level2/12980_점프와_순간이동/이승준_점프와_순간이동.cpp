#include <iostream>
using namespace std;

int m(int index);

int solution(int n) {
    return m(n);
}

int m(int index){
    if(index == 0){
        return 0;
    }
    if(index == 1){
        return 1;
    }

    if(index % 2 == 0){
        return m(index/2);
    }

    return m(index-1)+1;
}
