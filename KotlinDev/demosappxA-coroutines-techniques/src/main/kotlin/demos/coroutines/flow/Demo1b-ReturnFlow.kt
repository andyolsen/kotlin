package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main about to call getFlow()")
    val data: Flow<Int> = getFlow()

    MyUtil.display("main about to collect results")
    data.collect { println(it) }
}

// The flow() function is a "flow builder"
private fun getFlow(): Flow<Int> = flow {
    for (i in 1..200) {
        emit(i*i)     // Emit next value immediately (no need to collate into list first).
        delay(100) // Pretend we are doing something useful here.
    }
}