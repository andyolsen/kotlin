package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main about to call getFlow()")
    val data: Flow<Int> = getFlow()

    MyUtil.display("main about to collect results, will timeout with exception after 3 seconds...")
    try {
        withTimeout(3_000L) {
            data.collect { println(it) }
        }
    }
    catch (e: TimeoutCancellationException) {
            MyUtil.display("Caught exception: $e")
    }

    MyUtil.display("main about to collect results, will timeout with null after 3 seconds...")
    withTimeoutOrNull(3_000L) {
        data.collect { println(it) }
    }

    val job = launch {
        MyUtil.display("main about to collect results, user will cancel...")
        data.collect { println(it) }
    }
    delay(3_000)
    job.cancel()

    MyUtil.display("main says goodbye")
}

private fun getFlow(): Flow<Int> = flow {
    for (i in 1..200) {
        emit(i*i)     // Emit next value immediately (no need to collate into list first).
        delay(100) // Pretend we are doing something useful here.
    }
}


