import heapq

def solution(scoville, K):

    heapq.heapify(scoville)
    num=0

    while scoville[0]<K and len(scoville)>1:
        min1=heapq.heappop(scoville)
        min2=heapq.heappop(scoville)
        heapq.heappush(scoville,min1+min2*2)
        num+=1

    if scoville[0]<K:
        return -1

    return num

print(solution([1, 2, 3, 9, 10, 12], 7))