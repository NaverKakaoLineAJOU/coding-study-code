#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int personCountByWeight[200];

int findPersonWeight(int targetWeight);

int solution(vector<int> people, int limit) {
    const int peopleCount = people.size();

    //personCountByWeight 초기화
    for(int w = 0; w < limit; w++){
        personCountByWeight[w] = 0;
    }

    //personCountByWeight 전처리
    for(int i=0; i < peopleCount; i++){
        personCountByWeight[people[i]-40] += 1;
    }

    int leftPeopleCount = peopleCount;
    int boatCount = 0;
    int boatLeftWeight = 0;
    int peopleOnBoatCount = 0;

    while(leftPeopleCount > 0){
        if(peopleOnBoatCount == 2){
            boatCount++;
            boatLeftWeight = limit;
            peopleOnBoatCount = 0;
        }

        int personToBoatWeight = findPersonWeight(boatLeftWeight);

        if(personToBoatWeight == 0){
            boatCount++;
            boatLeftWeight = limit;
            peopleOnBoatCount = 0;
        }
        else {
            peopleOnBoatCount++;
            boatLeftWeight -= personToBoatWeight;
            leftPeopleCount--;
        }
    }

    return boatCount;
}

int findPersonWeight(int targetWeight){
    if(targetWeight < 40){
        return 0;
    }

    for(int testWeight = targetWeight-40; testWeight >= 0; testWeight--){
        if(personCountByWeight[testWeight] > 0){
            personCountByWeight[testWeight] -= 1;
            return testWeight + 40;
        }
    }

    return 0;
}

int main(void){
    vector<int> v = {40, 40, 40, 40, 40, 40};
    solution(v, 120);
}