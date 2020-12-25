def sol():
    l = int(input())
    str = input()
    answer = 0
    r = 1

    for i in range(l):
        answer += (ord(str[i]) - 96) * r
        r *= 31
        r = r % 1234567891
        answer = answer % 1234567891

    print(answer)

sol()
