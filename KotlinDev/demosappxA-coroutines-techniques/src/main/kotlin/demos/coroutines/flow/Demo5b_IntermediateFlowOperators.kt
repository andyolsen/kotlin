package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    listOf(7.5, 8.25, 9.0, 10.0, 6.5).asFlow()
        .filter { it > 7.5 }
        .map { it - 7.5}
        .collect { println("Hours overtime: $it") }

    MyUtil.display("main says goodbye")
}
