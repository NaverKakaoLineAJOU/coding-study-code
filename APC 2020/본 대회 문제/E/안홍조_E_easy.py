def sol():
    a = input()
    a = list(a)
    mirror = {"A": "A", "E": "3", "H": "H", "I": "I", "M": "M", "O": "O", "S": "2", "T": "T", "U": "U", "V": "V",
              "W": "W", "X": "X", "Y": "Y", "Z": "5", "b": "d", "d": "b", "i": "i", "l": "l", "m": "m", "n": "n",
              "o": "o", "p": "q", "q": "p", "r": "7", "u": "u", "v": "v", "w": "w", "x": "x", "0": "0", "1": "1",
              "2": "S", "3": "E", "5": "Z", "7": "r", "8": "8"}

    length = len(a)
    for i in range(length // 2):
        if a[i] in mirror:
            if mirror[a[i]] == a[length - i - 1]:
                continue
            else:
                if a[length - i - 1].isupper():
                    a[length - i - 1] = a[length - i - 1].lower()
                elif a[length - i - 1].islower():
                    a[length - i - 1] = a[length - i - 1].upper()

                if mirror[a[i]] == a[length - i - 1]:
                    continue
                else:
                    print(-1)
                    return

        elif a[i].isalpha():
            if a[i].isupper():
                a[i] = a[i].lower()
            elif a[i].islower():
                a[i] = a[i].upper()

            if a[i] in mirror:
                if mirror[a[i]] == a[length - i - 1]:
                    continue
                else:
                    if a[length - i - 1].isalpha():
                        if a[length - i - 1].isupper():
                            a[length - i - 1] = a[length - i - 1].lower()
                        elif a[length - i - 1].islower():
                            a[length - i - 1] = a[length - i - 1].upper()

                        if mirror[a[i]] == a[length - i - 1]:
                            continue
                        else:
                            print(-1)
                            return
                    else:
                        print(-1)
                        return
            else:
                print(-1)
                return
        else:
            print(-1)
            return

    a = ''.join(a)
    print(a)

sol()
