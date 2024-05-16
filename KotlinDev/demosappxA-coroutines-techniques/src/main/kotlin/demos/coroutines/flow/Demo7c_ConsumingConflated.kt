package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main says hello")

    val data: Flow<Int> = getFlow()

    // This collector is slower than the producer flow.
    // The conflate() function means we drop emitted elements that we missed.
    data.conflate().collect {
        delay(10_000)
        MyUtil.display("$it")
    }

    MyUtil.display("main says goodbye")
}

private fun getFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(3_000)
        emit(i*i)
    }
}