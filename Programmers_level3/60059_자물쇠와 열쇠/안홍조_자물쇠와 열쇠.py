def solution(key, lock):
    key_1 = []
    lock_0 = []
    for i in range(len(key)):
        for j in range(len(key)):
            if key[i][j] == 1:
                key_1.append((i, j))

    for i in range(len(lock)):
        for j in range(len(lock)):
            if lock[i][j] == 0:
                lock_0.append((i, j))

    print("key 튀어나온 부분:",key_1)
    print("자물쇠 들어간 부분:",lock_0)
    if len(lock_0) == 0:
        return True
    for i in range(4):
        #90도 돌리는 부분 위에 포문을 4번 돌리는이유는 90도 180도 270도 360도 네번이기 때문
        key_1 = rotate90(key_1)

        for key_one in key_1:

            #자물쇠 위치에 맞게 키의 위치를 이동한다.
            key_1_trans = trans(key_1, lock_0[0][0] - key_one[0], lock_0[0][1] - key_one[1])

            check = len(lock_0)
            for key_loc in key_1_trans:

                #이건 키가 자물쇠 밖으로 튀어나간 부분 그냥 넘어간다.
                if key_loc[0] < 0 or key_loc[0] >= len(lock) or key_loc[1] < 0 or key_loc[1] >= len(lock):
                    continue

                else:
                    #자물쇠랑 키가 들어어맞는지 확인하는 부분
                   if lock[key_loc[0]][key_loc[1]]==0:
                        check-=1

                    #얘는 키 부분에 자물쇠도 튀어나와있어서 안맞는 부분 break로 넘어가면 이상하게 틀려서 이렇게 둠
                   else:
                        check+=1

            if check == 0:
                return True

    return False


def rotate90(loc):
    res = []
    for i in loc:
        res.append((-1 * i[1], i[0]))

    return res

def trans(loc, x, y):
    res = []
    for i in loc:
        res.append((i[0] + x, i[1] + y))

    return res

solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]],[[1, 1, 1], [1, 1, 0], [1, 0, 1]])
