#include <iostream>
using namespace std;

const int aNumber = 97;

int convertCharToNum(char c);
long long bigMode(long long base, long long e, long long m);

int main(void){
    int strLen = 0;
    cin >> strLen;

    string str;
    cin >> str;


    int* numberList = new int[strLen];

    for(int i = 0; i < strLen; i++){
        numberList[i] = convertCharToNum(str.at(i));
    }

    long long H = 0;
    long long r = 31;
    long long m = 1234567891;

    for(int i = 0; i < strLen; i++){
        H = (H + ((long long)numberList[i])*bigMode(r, (long long)i, m)) % m;
    }

    cout << H << endl;

    return 0;
}

int convertCharToNum(char c){
    int temp = (int) c;
    return temp - aNumber + 1;
}

long long bigMode(long long base, long long e, long long m){
    long long nowE = 1;
    long long nowResidual = base % m;

    if(e == 0){
        return 1;
    }

    for(long long i = 2; i <= e; i++){
        nowResidual = nowResidual * base;
        nowResidual = nowResidual % m;
    }

    return (unsigned int) nowResidual;
}