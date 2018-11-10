package week_1

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(args: Array<String>) {
    var fin = Scanner(File("input.txt"))
    var fout = PrintWriter(File("output.txt"))
    fout.print(fin.nextInt() + fin.nextInt())
    fin.close()
    fout.close()
}