package stringHashes

fun main(args: Array<String>) {
    var text = readLine()!!
    var word = readLine()!!
    var tl = text.length
    var wl = word.length

    var power = Array(wl + 1){1L}
    var textHash = Array(tl + 1){0L}
    var wordHash = Array(wl + 1){0L}

    var b = 29L
    var m = 1000000003L

    for (i in 1 until wl + 1)
        power[i] = (power[i - 1] * b) % m
    for (i in 1 until tl + 1)
        textHash[i] = ((textHash[i - 1] * b + (text[i - 1].toInt() - 96)) % m + m) % m
    for (i in 1 until wl + 1)
        wordHash[i] = ((wordHash[i - 1] * b + (word[i - 1].toInt() - 96)) % m + m) % m

    for (i in wl until tl + 1) {
        var hashSegment = ((textHash[i] - textHash[i - wl] * power[wl]) % m + m) % m
        if (hashSegment == wordHash[wl])
            print("${i - wl} ")
    }
}