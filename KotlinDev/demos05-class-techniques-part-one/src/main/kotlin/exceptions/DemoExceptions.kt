package exceptions

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.lang.IllegalArgumentException

fun main() {
    demoExceptions1()
    demoExceptions2()
}

fun demoExceptions1() {
    val path = "C:\\KotlinDev\\temp\\message.txt"
    try {
        val bw = BufferedWriter(FileWriter(path))
        bw.use {
            bw.write("Bonjour tout le monde")
            bw.newLine()
            bw.write("Bonne journée")
            bw.newLine()
            bw.write("Au revoir")
            bw.newLine()
        }
        println("Written data to $path")
    }
    catch (ex: IOException) {
        System.err.println("IOException occurred: $ex")
    }
}

class X

fun demoExceptions2() {
    var result = try {
        someFuncThatMightThrowException(42)
    } catch (e: IllegalArgumentException) {
        0
    }
    result++
    println(result)
}

fun someFuncThatMightThrowException(i: Int): Int {
    if (i == 42)
        throw IllegalArgumentException("eek")
    else
        return 142
}