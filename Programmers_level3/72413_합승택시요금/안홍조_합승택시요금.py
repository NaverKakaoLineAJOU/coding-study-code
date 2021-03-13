import copy

def solution(n, s, a, b, fares):
    maps=[[1000000 for i in range(n)]for i in range(n)]
    distances=[]

    for fare in fares:
        row=fare[0]
        col=fare[1]
        maps[row-1][col-1]=fare[2]
        maps[col-1][row-1]=fare[2]

    for i in range(n):
        maps[i][i]=0

    for i in range(n):
        check_table=[False for j in range(n)]
        check_table[i] = True
        distance=copy.deepcopy(maps[i])
        for j in range(n-1):
            choose=choose_one(distance,check_table)
            check_table[choose]=True
            for k in range(n):
                if not check_table[k]:
                    if distance[k]>distance[choose]+maps[choose][k]:
                        distance[k]=distance[choose]+maps[choose][k]
        distances.append(distance)

    for dist in distances:
        print(dist)
    print()

    min_dis=[]

    for i in range(n):
        min_dis.append(distances[s-1][i])
    print(min_dis)
    print()

    for i in range(n):
        min_dis[i] = min_dis[i] + distances[i][a - 1] + distances[i][b - 1]
    print(min_dis)
    answer = min(min_dis)
    return answer

def choose_one(dist,table):
    min_value=1000000
    min_pos=-1
    for i in range(len(dist)):
        if min_value>dist[i] and not table[i]:
            min_value=dist[i]
            min_pos=i

    return min_pos


print(solution(6,4,6,2,[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))