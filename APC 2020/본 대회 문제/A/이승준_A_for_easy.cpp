#include <iostream>
using namespace std;

long long positiveNum(long long num, long long m);

int main(void){
    long long m, seed, x1, x2 = 0;
    cin >> m >> seed >> x1 >> x2;

    //a를 구하는 과정
    long long r, gcd = 0;
    long long a = 0;
    for(long long testA = 0; testA < m; testA++){
        for(long long testC = 0; testC < m; testC++){
            long long testX1 = (testA*seed+testC) % m;
            if(testX1 != x1){
                continue;
            }
            long long testX2 = (testA*testX1+testC) % m;
            if(testX2 != x2){
                continue;
            }

            cout << testA << " " << testC << endl;
            return 0;
        }
    }

    return 0;
}