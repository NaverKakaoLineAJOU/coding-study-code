#include <string>
#include <vector>
#include <stack>

using namespace std;

string parser(string w);
void spliter(string w, string* u, string* v);
bool isCorrect(string w);
string trimer(string w);
string reverser(string w);

string solution(string p) {
    return parser(p);
}

string parser(string w){
    if(w.size() == 0){
        return "";
    }

    string u, v;
    spliter(w, &u, &v);

    if(isCorrect(u)){
        string result = parser(v);
        return u + result;
    }

    string result = "(" + parser(v) + ")";

    return result + reverser(trimer(u));
}

void spliter(string w, string* u, string* v){
    int openCount = 0;
    int closeCount = 0;

    const int length = w.size();

    int point = 0;
    do{
        char c = w[point];

        if(c == '('){
            openCount++;
        }
        else {
            closeCount++;
        }

        point++;
    }while(openCount != closeCount);
    point--;

    //이 시점에서 point는 u의 끝 지점을 가리키고 있다

    *u = w.substr(0, point+1);
    *v = w.substr(point+1, length-point-1); //point+1부터 끝까지
}

bool isCorrect(string w){
    const int length = w.size();
    stack<char> s;

    for(int point = 0; point < length; point++){
        char c = w[point];

        if(s.size() == 0){
            s.push(c);
        }
        else if(c == ')' && s.top() == '('){
            s.pop();
        }
        else {
            s.push(c);
        }
    }

    return s.size() == 0;
}

string trimer(string w){
    const int length = w.size();

    return w.substr(1, length-2);
}

string reverser(string w){
    const int length = w.size();

    for(int point = 0; point < length; point++){
        if(w[point] == '('){
            w[point] = ')';
        }
        else {
            w[point] = '(';
        }
    }

    return w;
}