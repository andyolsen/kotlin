package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main says hello")

    val data: Flow<Int> = getFlow()
    data.collect {
        delay(3_000)
        MyUtil.display("$it")
    }

    MyUtil.display("main says goodbye")
}

private fun getFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(5_000)
        emit(i*i)
    }
}