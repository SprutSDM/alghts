package segmentTree

fun getMaxLine(q: Int, p: Int): Pair<Int, Int> {
    var l = q + base
    var r = p + base
    var ans: Pair<Int, Int> = dp[l]
    while (l <= r) {
        if (dp[l].first > ans.first)
            ans = dp[l]
        else if (dp[l].first == ans.first)
            ans = Pair(dp[l].first, Math.min(ans.second, dp[l].second))
        if (dp[r].first > ans.first)
            ans = dp[r]
        else if (dp[r].first == ans.first)
            ans = Pair(dp[r].first, Math.min(ans.second, dp[r].second))

        if (l % 2 == 1)
            l = (l + 1) / 2
        else
            l /= 2
        if (r % 2 == 0)
            r = (r - 1) / 2
        else
            r /= 2
    }
    return ans
}

var base = 0
lateinit var dp: Array<Pair<Int, Int>>

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var line = readLine()!!.split(" ").map { it.toInt() }
    base = Math.pow(2.0, Math.ceil(Math.log(n.toDouble()) / Math.log(2.0))).toInt()
    dp = Array(base * 2 + 1) { Pair(0, 0) }
    for (i in 0 until base)
        if (i < n)
            dp[i + base] = Pair(line[i], i + 1)
        else
            dp[i + base] = Pair(0, i + 1)

    for (i in base - 1 downTo 1)
        if (dp[i * 2].first >= dp[i * 2 + 1].first)
            dp[i] = dp[i * 2]
        else
            dp[i] = dp[i * 2 + 1]

    val k = readLine()!!.toInt()
    var ans = ArrayList<String>()
    for (i in 0 until k) {
        var (l, r) = readLine()!!.split(" ").map { it.toInt() }
        ans.add(getMaxLine(l - 1, r - 1).second.toString())
    }
    print(ans.joinToString(" "))
}