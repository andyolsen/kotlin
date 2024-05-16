package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main says hello")

    val flow1 = listOf("ant", "bat", "cat", "dog", "elk", "fox").asFlow().onEach { delay(3_000) }
    val flow2 = listOf(111, 222, 333, 444).asFlow().onEach { delay(7_000) }

    flow1.combine(flow2) { a, b -> "$a -> $b" }
        .collect { MyUtil.display(it) }

    MyUtil.display("main says goodbye")
}