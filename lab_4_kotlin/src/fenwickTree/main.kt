package fenwickTree

fun change(q: Int, ds: Int) {
    var i = q
    while (i <= n) {
        fv[i] += ds
        i = (i or (i - 1)) + 1
    }
}

fun get_sum(q: Int): Int {
    var i = q
    var s = 0
    while (i != 0) {
        s += fv[i]
        i = (i and (i - 1))
    }
    return s
}

var n = 0
lateinit var fv: Array<Int>

fun main(args: Array<String>) {
    n = readLine()!!.toInt()
    var line = Array(n) {0}
    var line_1 = readLine()!!.split(" ").map { it.toInt() }
    fv = Array(n + 1) {0}
    for (i in 0 until n) {
        change(i + 1, line_1[i])
        line[i] = line_1[i]
    }
    var k = readLine()!!.toInt()
    for (i in 1 until k) {
        var (s, _q, _p) = readLine()!!.split(" ")
        var q = _q.toInt()
        var p = _p.toInt()
        if (s == "s")
            print("${get_sum(p) - get_sum(q - 1)} ")
        else {
            change(q, p - line[q - 1])
            line[q - 1] = p
        }
    }
}