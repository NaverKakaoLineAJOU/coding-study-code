import copy

def sol():
    NMT = list(map(int, input().split()))
    kab = list(map(int, input().split()))

    life = [[0 for j in range(NMT[1] + 2 * kab[0])] for i in range(NMT[0] + 2 * kab[0])]

    for N in range(NMT[0]):
        tmp = input()
        for M in range(NMT[1]):
            if tmp[M] == "*":
                life[kab[0] + N][kab[0] + M] = 1

    new = copy.deepcopy(life)

    for t in range(NMT[2]):
        for i in range(kab[0], kab[0] + NMT[0]):
            for j in range(kab[0], kab[0] + NMT[1]):
                around = sum_list([row[j - kab[0]:j + kab[0] + 1] for row in life[i - kab[0]:i + kab[0] + 1]])
                if life[i][j] == 1:
                    if around < kab[1]:
                        new[i][j] = 0
                    elif around > kab[2]:
                        new[i][j] = 0
                else:
                    if around > kab[1] and around <= kab[2]:
                        new[i][j] = 1

        life = copy.deepcopy(new)

    for i in range(kab[0], kab[0] + NMT[0]):
        str = ""
        for j in range(kab[0], kab[0] + NMT[1]):
            if life[i][j] == 0:
                str += "."
            else:
                str += "*"
        print(str)


def sum_list(lst):
    sum = 0
    for l in lst:
        for i in l:
            sum += i

    mid = len(lst) // 2
    sum = sum - lst[mid][mid]
    return sum


sol()
