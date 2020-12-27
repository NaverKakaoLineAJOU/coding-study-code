def sol():
    num = input()

    bound = list(map(int, input().split(" ")))
    rank_bound = {}
    rank_bound["B"] = bound[0]
    rank_bound["S"] = bound[1]
    rank_bound["G"] = bound[2]
    rank_bound["P"] = bound[3]

    rank = input()
    month = []

    for i in range(len(rank)):
        if rank[i] == "D":
            month.append(rank_bound["P"])
        elif i == 0:
            month.append(rank_bound[rank[i]] - 1)
        else:
            month.append(rank_bound[rank[i]] - month[i - 1] - 1)
    print(sum(month))
sol()
