def sol():
    s1s2 = map(int, input().split())
    s1s2=list(s1s2)

    for i in range(s1s2[0]):
        s1= map(int, input().split())
        s1=list(s1)
        if s1[0]!=s1[1]:
            print("Wrong Answer")
            return

    for i in range(s1s2[1]):
        s2 = map(int, input().split())
        s2 = list(s2)
        if s2[0] != s2[1]:
            print("Why Wrong!!!")
            return

    print("Accepted")

sol()

