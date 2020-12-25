#include <iostream>
using namespace std;

void printMap(bool** map, int height, int width);
bool** makeMap(int height, int width);
void deleteMap(bool** map, int height, int width);
int countSurroundLife(bool** map, int height, int width, int row, int col, int k);
bool lifeRule(int a, int b, int lifeCount, bool current);

int main(void){
    int height, width, seekTime = 0;
    cin >> height >> width >> seekTime;
    int seekRange, a, b = 0;
    cin >> seekRange >> a >> b;

    bool** map = makeMap(height, width);

    //맵 로딩
    for(int row = 0; row < height; row++){
        for(int col = 0; col < width; col++){
            char c;
            cin >> c;
            if(c == '.'){
                map[row][col] = false;
            }
            else {
                map[row][col] = true;
            }
        }
    }

    for(int nowTime = 0; nowTime < seekTime; nowTime++){
        bool** newMap = makeMap(height, width);

        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                int lifeCount = countSurroundLife(map, height, width, row, col, seekRange);
                bool isAlive = lifeRule(a, b, lifeCount, map[row][col]);
                newMap[row][col] = isAlive;
            }
        }

        deleteMap(map, height, width);
        map = newMap;
    }

    printMap(map, height, width);

    return 0;
}

void printMap(bool** map, int height, int width){
    for(int row = 0; row < height; row++){
        for(int col = 0; col < width; col++){
            if(map[row][col]){
                cout << "*";
            }
            else {
                cout << ".";
            }
        }
        cout << endl;
    }
}

bool** makeMap(int height, int width){
    bool** map = new bool*[height];
    for(int h=0; h < height; h++){
        map[h] = new bool[width];
    }

    return map;
}

void deleteMap(bool** map, int height, int width){
    for(int h=0; h < height; h++){
        delete map[h];
    }

    delete map;
}

int countSurroundLife(bool** map, int height, int width, int row, int col, int k){
    int rowStart = row - k;
    int colStart = col - k;
    int rowEnd = row + k;
    int colEnd = col + k;
    int lifeCount = 0;

    for(int exRow = rowStart; exRow <= rowEnd; exRow++){
        for(int exCol = colStart; exCol <= colEnd; exCol++){
            if(exRow < 0 || exRow >= height || exCol < 0 || exCol >= width){
                continue;
            }
            if(map[exRow][exCol]){
                lifeCount++;
            }
        }
    }

    if(map[row][col]){
        lifeCount--;
    }

    return lifeCount;
}

bool lifeRule(int a, int b, int lifeCount, bool current){
    if(current){
        if(a<=lifeCount && lifeCount <= b){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        if(a<lifeCount && lifeCount <= b){
            return true;
        }
        else {
            return false;
        }
    }
}