package heapSort

fun heappush(heap: ArrayList<Int>, q: Int) {
    heap.add(q)
    var i = heap.size - 1
    var b = 0
    while (i != 1 && heap[i] < heap[i / 2]) {
        b = heap[i]
        heap[i] = heap[i / 2]
        heap[i / 2] = b
        i /= 2
    }
}

fun heappop(heap: ArrayList<Int>): Int {
    var value = heap[0]
    heap[0] = heap.last()
    heap.remove(heap.lastIndex)
    var i = 1
    var b = 0
    while (i * 2 < heap.size) {
        var j = i * 2
        if (i * 2 + 1 < heap.size && heap[i * 2 + 1] < heap[i * 2])
            j = i * 2 + 1
        if (heap[i] <= heap[j])
            break
        b = heap[i]
        heap[i] = heap[j]
        heap[j] = b
        i = j
    }
    return value
}

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var heap = ArrayList<Int>()
    heap.add(0)
    readLine()!!.trim().split(" ").map{heappush(heap, it.toInt())}
    for (i in 1..n)
        print("${heappop(heap)} ")
}