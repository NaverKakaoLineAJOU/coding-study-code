#include <string>
#include <vector>
#include <iostream>

using namespace std;

const int zMax = 26;
const int initLetterNumber = 1;

int looper(int position, int size);
int getLastNotAPoint(string name, int checkStartPoint, int checkEndPoint, int direction);
int move(int size, int from, int to, int direction);

int solution(string name) {
    const int nameLength = name.size();
    int letterChangeControllCount = 0;
    for(int i=0; i<nameLength; i++){
        char letter = name[i];
        int targetLetterNumber = letter - 'A' + initLetterNumber;

        int upDirectionJoystictInputCount = targetLetterNumber - initLetterNumber;
        int downDirectionJoystictInputCount = zMax - upDirectionJoystictInputCount;
        letterChangeControllCount += upDirectionJoystictInputCount > downDirectionJoystictInputCount ? downDirectionJoystictInputCount : upDirectionJoystictInputCount;
    }

    int minMoveCount = nameLength + 10;
    for(int direction = 1; direction >= -1; direction -= 2){
        for(int turnPoint = 0; turnPoint < nameLength; turnPoint++){
            int moveCount = 0;
            int realTurnPoint = getLastNotAPoint(name, 0, turnPoint, direction);
            moveCount += move(nameLength, 0, realTurnPoint, direction);

            //turn

            int finalPosition = getLastNotAPoint(name, realTurnPoint, looper(realTurnPoint + direction, nameLength),  -direction);
            moveCount += move(nameLength, realTurnPoint, finalPosition, -direction);
            if(moveCount < minMoveCount){
                minMoveCount = moveCount;
            }
        }
    }

    return minMoveCount + letterChangeControllCount;
}

int getLastNotAPoint(string name, int checkStartPoint, int checkEndPoint, int direction){
    int lastPoint = checkStartPoint;
    int i = checkStartPoint;
    while(true){
        if(name[i] != 'A'){
            lastPoint = i;
        }

        if(i == checkEndPoint){
            break;
        }

        i = looper(i+direction, name.size());
    }

    return lastPoint;
}

int looper(int position, int size){
    if(position >= 0){
        return position % size;
    }

    while(position < 0){
        position += size;
    }

    return position;
}

int move(int size, int from, int to, int direction){
    if(direction > 0){
        if(from > to){
            to += size;
        }
        return to - from;
    }
    else {
        if(to > from){
            from += size;
        }

        return from - to;
    }
}

int main(void){
    cout << solution("CANAAAAANAN") << endl;
}