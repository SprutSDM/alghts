import java.util.TreeSet
import kotlin.math.min

// 7 Informatics
fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var p = readLine()!!.trim().split(" ").map{it.toInt()}
    var k = readLine()!!.toInt()
    var line = Array(k, {ArrayList<Int>()})
    for (i in 0 until k) {
        var (x, y) = readLine()!!.split(" ").map{it.toInt()}
        x--
        y--
        line[x].add(y)
        line[y].add(x)
    }
    var heap = TreeSet<Pair<Int, Int>>({a, b -> a.first.compareTo(b.first)})
    var b = Array(n, {false})
    heap.add(Pair(0, 0))
    var ans = -1
    while (heap.size != 0) {
        var (c, v) = heap.pollFirst()
        if (b[v])
            continue
        b[v] = true
        for (u in line[v]) {
            if (!b[u])
                heap.add(Pair(c + p[v], v))
            if (u == n - 1)
                if (ans == -1)
                    ans = c + p[v]
                else
                    ans = min(ans, c + p[v])
        }
    }
    if (n == 1)
        print(0)
    else
        print(ans)
}