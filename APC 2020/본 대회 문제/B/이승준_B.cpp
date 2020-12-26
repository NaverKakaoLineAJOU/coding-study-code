#include <iostream>
using namespace std;

int getMaxMoney(char grade, int s, int g, int p, int d);

int main(void){
    int n = 0;
    int s, g, p, d = 0;
    cin >> n;
    cin >> s >> g >> p >> d;
    char* gradeList = new char[n];

    for(int i = 0; i < n; i ++){
        char c;
        cin >> c;
        gradeList[i] = c;
    }

    int lastMonthMoney = 0;
    int moneySum = 0;
    for(int i = 0; i < n; i++){
        int twoMonthMoney = getMaxMoney(gradeList[i], s, g, p, d);
        int thisMonthMoney = twoMonthMoney - lastMonthMoney;
        if(thisMonthMoney > d){
            thisMonthMoney = d;
        }
        moneySum += thisMonthMoney;
        lastMonthMoney = thisMonthMoney;
    }

    cout << moneySum << endl;

    return 0;
}

int getMaxMoney(char grade, int s, int g, int p, int d){
    if(grade == 'D'){
        return 2*d;
    }

    if(grade == 'P'){
        return d-1;
    }

    if(grade == 'G'){
        return p-1;
    }

    if(grade == 'S'){
        return g-1;
    }

    //B
    return s-1;
}