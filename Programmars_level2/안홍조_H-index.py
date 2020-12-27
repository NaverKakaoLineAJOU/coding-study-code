def solution(citations):
    cit_dict = dict()
    max=0
    total_len=len(citations)


    for i in citations:
        if max<i:
            max=i
        if i in cit_dict:
            cit_dict[i]+=1
        else:
            cit_dict[i] =1

    cit_list=[]
    for i in range(max+1):
        cit_list.append(0)

    for key,value in cit_dict.items():
        cit_list[key]=value

    now = 0
    for i in range(max+1):
        if i<=total_len-now:
            now+=cit_list[i]
            continue
        else:
            return i-1

    answer = 0
    return answer
