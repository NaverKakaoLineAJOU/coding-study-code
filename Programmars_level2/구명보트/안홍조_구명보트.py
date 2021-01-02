def solution(people, limit):
    answer = 0

    people.sort(reverse=True)

    for j in range(len(people)):
        if people[j] == 0:
            continue
        elif people[j] > limit - 40:
            people[j] = 0
            answer += 1
            continue
        else:
            boat = people[j]

        for i in range(len(people) - 1, j, -1):
            if people[i] == 0:
                continue
            else:
                if boat + people[i] > limit:
                    break
                else:
                    people[i]=0
                    break
        answer += 1

    return answer

