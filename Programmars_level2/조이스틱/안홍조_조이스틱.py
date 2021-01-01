def solution(name):
    length=len(name)
    sub = []
    for i in name:
        if ord(i) >= ord("N"):
            sub.append(ord("Z") + 1 - ord(i))
        else:
            sub.append(ord(i) - ord("A"))

    print(sub)
    answer=0
    position=0

    while True:

        answer+=sub[position]
        sub[position]=0
        if sum(sub)==0:
            break

        #left
        left_count=0
        left=position
        while True:
            left-=1
            left_count+=1
            if sub[left]!=0:
                break

        #right
        right=position
        right_count =0
        while True:
            right+=1
            right_count+=1
            if right>=length:
                right-=1
                right_count-=1
                break

            if sub[right]!=0:
                break

        if right_count<=left_count:
            answer+=right_count
            position=right
        else:
            answer+=left_count
            position=left

    return answer

print(solution("BBBAAAB"))