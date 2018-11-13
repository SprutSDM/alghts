package mergeSort

fun sort(l: Int, r: Int) {
    if (l + 1 == r)
        return
    var middle = (r - l) / 2 + l
    sort(l, middle)
    sort(middle, r)
    var lp = l
    var rp = middle
    var buf = ArrayList<Int>()
    while (lp != middle && rp != r) {
        if (line[rp] < line[lp]) {
            buf.add(line[rp])
            rp++
        } else {
            buf.add(line[lp])
            lp++
        }
    }
    if (lp == middle)
        for (i in rp until r)
            buf.add(line[i])
    else
        for (i in lp until middle)
            buf.add(line[i])
    for (i in l until r)
        line[i] = buf[i-l]
}

lateinit var line: ArrayList<Int>


fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    line = readLine()!!.trim().split(" ").map{it.toInt()} as ArrayList<Int>
    sort(0, line.size)
    println(line.joinToString(" "))
}