package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main about to call getFlow()")
    val data: Flow<Int> = getFlow()

    MyUtil.display("main pondering the meaning of life, the universe, and everything...")
    delay(10_000)

    MyUtil.display("main about to collect results")
    data.collect { println(it) }

    MyUtil.display("main doing a bit more pondering...")
    delay(10_000)

    MyUtil.display("main about to collect results again")
    data.collect { println(it) }

    MyUtil.display("main says goodbye")
}

private fun getFlow(): Flow<Int> = flow {
    MyUtil.display("getFlow started")
    for (i in 1..5) {
        emit(i*i)     // Emit next value immediately (no need to collate into list first).
        delay(100) // Pretend we are doing something useful here.
    }
}


