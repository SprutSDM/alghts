package prefixFunction

fun main(args: Array<String>) {
    var line = readLine()!!
    var pref = ArrayList<Int>()
    pref.add(0)
    for (i in 1 until line.length) {
        var j = pref[i - 1]
        while (line[j] != line[i] && j != 0)
            j = pref[j - 1]
        if (line[i] == line[j])
            j += 1
        pref.add(j)
    }
    print(line.length - pref.last())
}