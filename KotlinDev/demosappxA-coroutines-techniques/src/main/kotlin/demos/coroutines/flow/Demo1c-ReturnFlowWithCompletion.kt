package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    val data: Flow<Int> = getFlow()

    MyUtil.display("main about to collect results, with try/finally")
    try {
        data.collect { println(it) }
    }
    finally {
        MyUtil.display("finally block")
    }

    MyUtil.display("main about to collect results, with declarative completion handler")
    data.onCompletion { MyUtil.display("onCompletion handler") }
        .collect { println(it) }

}

private fun getFlow(): Flow<Int> = flow {
    for (i in 1..10) {
        emit(i*i)
        delay(100)
    }
}


