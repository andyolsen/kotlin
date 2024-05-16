package demos.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.IllegalArgumentException

fun main() = runBlocking<Unit> {

    println("Collected flow:")
    getFlow().collect { println(it) }

    val count = getFlow().count()
    println("\nCount of items: $count")

    val list = mutableListOf<Int>()
    getFlow().toList(list)
    println("\nFlow as list:")
    list.forEach { println(it) }

    val set = mutableSetOf<Int>()
    getFlow().toSet(set)
    println("\nFlow as set:")
    set.forEach { println(it) }

    val first = getFlow().first()
    println("\nFirst item: $first")

    val firstGradeA = getFlow().first { it >= 70 }
    println("First grade A: $firstGradeA")

    val firstGradeAStar = getFlow().first { it >= 85 }
    println("First grade A*: $firstGradeAStar")

    val firstFailOrNull = getFlow().firstOrNull { it < 50 }
    println("First fail: ${firstFailOrNull ?: "[none]"}")

    try {
        val single = getFlow().single()
        println("Single element in flow: $single")
    } catch (e : IllegalArgumentException) {
        println("Caught exception $e")
    }

    println("\nUsing reduce() to calculate sum of exam marks...")
    val sum = getFlow().reduce { accumulator, value ->
        println("  accumulator=$accumulator, value=$value")
        accumulator + value
    }
    println("Sum: $sum")

    println("\nUsing fold() to fold marks into a string...")
    val str = getFlow().fold("EXAM MARKS:"){ initial, value ->
        println("  initial=$initial, value=$value")
        "$initial $value"
    }
    println(str)
}


private fun getFlow(): Flow<Int> = flow {
    listOf(65, 72, 79, 87, 99, 87).forEach {
        emit(it)
    }
}