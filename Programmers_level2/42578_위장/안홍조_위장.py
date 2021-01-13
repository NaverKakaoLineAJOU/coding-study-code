def solution(clothes):
    cloth_dict=dict()

    for i in clothes:
        if i[1] in cloth_dict:
            cloth_dict[i[1]]+=1
        else:
            cloth_dict[i[1]]=1

    answer=1
    for i in cloth_dict.values():
        answer*=(i+1)
    return answer-1