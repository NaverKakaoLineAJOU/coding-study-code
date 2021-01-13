def solution(n, computers):
    global check
    global network

    check = [[True] * n for i in range(n)]
    network = [0] * n
    for i in range(len(check)):
        for j in range(len(check)):
            if i == j:
                check[i][j] = False

    network_num = 1
    pos = 0
    while 0 in network:
        if network[pos] != 0:
            pos += 1
            continue

        find_network(pos, network_num, computers)
        print(network)
        network_num += 1
    answer = max(network)
    return answer


def find_network(pos, network_num, computers):
    if network[pos] == 0:
        network[pos] = network_num

    for i in range(len(computers)):
        if check[pos][i]:
            check[pos][i] = False
            if computers[pos][i] == 1:
                find_network(i, network_num, computers)

    return