import java.util.ArrayList

// 163 Informatics
fun main(args: Array<String>) {
    var (s1, s2) = readLine()!!.split(" ")
    var hrs1 = Pair(s1[0].toInt() - 97, s1[1].toInt() - 49)
    var hrs2 = Pair(s2[0].toInt() - 97, s2[1].toInt() - 49)
    var c = Array(8, { Array(8, {false}) })
    var step = arrayOf(Pair(2, 1), Pair(-2, -1), Pair(-2, 1), Pair(2, -1),
            Pair(1, 2), Pair(-1, -2), Pair(1, -2), Pair(-1, 2))
    var queue = ArrayList<Triple<Int, Int, Int>>()
    queue.add(Triple(hrs1.first, hrs1.second, 0))
    c[hrs1.first][hrs1.second] = true
    var ind = 0
    while (ind < queue.size) {
        var (x, y, k) = queue[ind]
        ind++
        if (x == hrs2.first && y == hrs2.second) {
            if (k % 2 == 0)
                println(k / 2)
            else
                println(-1)
            break
        }
        for ((i, j) in step) {
            if (0 <= x + i && x + i < 8 && 0 <= y + j && y + j < 8 && !c[x + i][y + j]) {
                c[x + i][y + j] = true
                queue.add(Triple(x + i, y + j, k + 1))
            }
        }
    }
}