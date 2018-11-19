package zFunction

fun main(args: Array<String>) {
    var s = readLine()!!
    var line = ArrayList<Int>()
    line.add(s.length)
    var l = 0
    var r = 0
    for (i in 1 until s.length) {
        if (i <= r)
            line.add(Math.min(line[i - l], r - i + 1))
        else
            line.add(0)
        while (i + line[i] < s.length && s[line[i]] == s[line[i] + i])
            line[i] += 1
        if (i + line[i] - 1 > r) {
            l = i
            r = i + line[i] - 1
        }
    }
    print(line.joinToString(" "))
}