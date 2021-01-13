def solution(people, limit):
    answer = 0

    people.sort()

    front=0
    end=len(people)-1

    while front<=end:
        if people[front] + people[end] <= limit:
            answer += 1
            front += 1
            end -= 1
        else:
            answer += 1
            end-= 1

    return answer


