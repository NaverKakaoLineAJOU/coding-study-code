def sol():
    msx1x2 = list(map(int, input().split()))

    m = msx1x2[0]
    seed = msx1x2[1]
    x1 = msx1x2[2]
    x2 = msx1x2[3]

    for a in range(m):
        for c in range(m):
            if (a * seed + c) % m == x1 and (a * x1 + c) % m == x2:
                print(a, c)
                return


sol()
