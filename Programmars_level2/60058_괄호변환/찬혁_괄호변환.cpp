#include <string>
#include <vector>
#include <iostream>

using namespace std;

string fix(string p) {
    // 1.
    if (p == "") return "";

    string u = "";
    string v = "";
    int vflag = 0;
    int l = 0;
    int r = 0;

    // 2. u ,v 로 나누기
    for (int i = 0; i<p.size(); i++) {

        if (!vflag) {
            if (p[i] == '(') 
                l++;
            else 
                r++;

            if (l == r) 
                vflag = 1;
            
            u += p[i];
        }
        else 
            v += p[i];
    }

    // 3. 올바른 괄호 문자열 일 때
    if ( u[0] == '(' && u[u.size() - 1] == ')' ) {
        return u + fix(v);
    }
    // 4.
    else {
        string newstring = '(' + fix(v) + ')';

        for (int i = 1; i <= u.size() - 2; i++) {
            if ( u[i] == '(' ) 
                newstring += ')';
            else 
                newstring += '(';
        }
        return newstring;
    }

}

string solution(string p) {
    string answer = "";

    answer = fix(p);

    return answer;
}

int main() {
    string s;
    cin >> s;
    s = solution(s);
    cout << s<<"\n";

    return 0;
}