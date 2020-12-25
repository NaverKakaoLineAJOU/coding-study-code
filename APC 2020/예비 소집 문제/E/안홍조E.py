def sol():
    num=int(input())

    ask=[]
    for i in range(num):
        tmp=list(map(str, input().split(" ")))
        ask.append(tmp)

    S=input().split()
    S=S[1]

    start_min=len(S)
    end_max=0

    for i in ask:
        start=S.find(i[1])
        end=start+int(i[0])

        if start_min>start:
            start_min=start

        if end_max<end:
            end_max=end
        print(start,end)

    print(end_max-start_min)

sol()