#include <iostream>
using namespace std;

long long getR(long long a, long long m, long long* gcd);
long long positiveNum(long long num, long long m);

int main(void){
    long long m, seed, x1, x2 = 0;
    cin >> m >> seed >> x1 >> x2;

    //a를 구하는 과정
    long long r, gcd = 0;
    long long a = 0;
    if(seed-x1 < 0){
        r = getR(x1-seed, m, &gcd);
        long long e = positiveNum(x1-x2, m) / gcd;
        a = positiveNum(r*e, m);
    }
    else if(seed-x1 > 0){
        r = getR(seed-x1, m, &gcd);
        long long e = positiveNum(x1-x2, m) / gcd;
        a = positiveNum(r*e, m);
    }
    else {
        a = 1;
    }


    long long c = positiveNum(x1-a*seed, m);

    cout << a << " " << c << endl;

    return 0;
}



long long positiveNum(long long num, long long m){
    while(num < 0){
        num += m;
    }

    while(num >= m){
        num -= m;
    }

    return num;
}

long long getR(long long a, long long m, long long* gcd){
    long long numA, numB;
    long long x_2, x_1, x_0 = 0;

    if(a > m){
        numA = a;
        numB = m;
        x_2 = 1;
        x_1 = 0;

    }
    else {
        numA = m;
        numB = a;
        x_2 = 0;
        x_1 = 1;
    }

    long long q = 0;
    long long remainder = 0;

    while(true){
        q = numA / numB;
        remainder = numA % numB;
        x_0 = x_2 - (q*x_1);

        if(remainder == 0){
            break;
        }

        //다음 스텝 준비
        numA = numB;
        numB = remainder;
        remainder = 0;
        x_2 = x_1;
        x_1 = x_0;
        x_0 = 0;
    }

    *gcd = numB;

    return x_1;
}