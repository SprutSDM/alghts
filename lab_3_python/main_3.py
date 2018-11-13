#Heap sort
def heappush(heap, q):
    heap.append(q)
    i = len(heap) - 1
    while i != 1 and heap[i] < heap[i // 2]:
        heap[i], heap[i // 2] = heap[i // 2], heap[i]
        i //= 2

def heappop(heap):
    value = heap[1]
    if len(heap) == 2:
        return heap.pop()
    heap[1] = heap.pop()
    i = 1
    while i * 2 < len(heap):
        j = i * 2
        if i * 2 + 1 < len(heap) and heap[i * 2 + 1] < heap[i * 2]:
            j = i * 2 + 1
        if heap[i] <= heap[j]:
            break
        heap[i], heap[j] = heap[j], heap[i]
        i = j
    return value


n = int(input())
heap = [0]
for elem in input().split():
    heappush(heap, int(elem))
print(*[heappop(heap) for i in range(n)])