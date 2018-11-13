package quickSort

import java.util.*


fun sort(l: Int, r: Int) {
    if (r - l <= 1)
        return
    var key = line[rndm.nextInt(r - l) + l]
    var ll = l
    var rr = r - 1
    while (ll <= rr) {
        //println("$ll, $rr")
        while (line[ll] < key)
            ll++
        while (line[rr] > key)
            rr--
        if (ll >= rr)
            break
        swap(ll, rr)
        ll++
        rr--
    }
    sort(l, ll)
    sort(ll, r)
}

fun swap(q: Int, p: Int) {
    var o = line[q]
    line[q] = line[p]
    line[p] = o
}

lateinit var line: ArrayList<Int>
var rndm = Random()

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    line = readLine()!!.trim().split(" ").map{it.toInt()} as ArrayList<Int>
    sort(0, line.size)
    println(line.joinToString(" "))
}