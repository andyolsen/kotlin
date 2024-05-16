package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    MyUtil.display("main says hello")

    val data: Flow<Int> = getFlow()

    // This collector is randomly slow.
    // The collectLatest() function means we abandon the current emitted element if another is emitted midflight.
    data.collectLatest {
        MyUtil.display("Starting consuming $it")
        delay((Math.random() * 8_000).toLong())
        MyUtil.display("Finished consuming $it")
    }

    MyUtil.display("main says goodbye")
}

private fun getFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(3_000)
        emit(i*i)
    }
}