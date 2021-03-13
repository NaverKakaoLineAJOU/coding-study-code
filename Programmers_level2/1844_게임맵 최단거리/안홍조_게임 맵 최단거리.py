from queue import PriorityQueue

def solution(maps):
    row = len(maps)
    col = len(maps[0])
    map_padding = [[0 for i in range(col + 2)] for j in range(row + 2)]

    for i in range(row):
        for j in range(col):
            map_padding[i + 1][j + 1] = maps[i][j]
    que = PriorityQueue()
    map_padding[1][1] = 0
    que.put((row + col - 2, (1, 1), map_padding, 1))

    while not que.empty():
        tmp = que.get()
        print(tmp)
        pos = tmp[1]
        tmp_map = tmp[2]
        if pos[0] == row and pos[1] == col:
            return tmp[3]

        if tmp_map[pos[0] - 1][pos[1]] == 1:
            que.put(move(pos[0] - 1, pos[1], tmp_map, tmp[3]))
        if tmp_map[pos[0]][pos[1] - 1] == 1:
            que.put(move(pos[0], pos[1] - 1, tmp_map, tmp[3]))
        if tmp_map[pos[0] + 1][pos[1]] == 1:
            que.put(move(pos[0] + 1, pos[1], tmp_map, tmp[3]))
        if tmp_map[pos[0]][pos[1] + 1] == 1:
            que.put(move(pos[0], pos[1] + 1, tmp_map, tmp[3]))

    return -1


def move(i, j, maps, length):
    n = len(maps)
    m = len(maps[0])
    maps[i][j] = 0
    return (n+m-i-j+length, (i, j), maps, length + 1)


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
