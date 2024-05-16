package mypackage

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    MyUtil.display("MESSAGE A **************************************")

    runBlocking {
        launch { func("Child coroutine #1", 5000L) }
        launch { func("Child coroutine #2", 2000L) }
    }

    MyUtil.display("MESSAGE B **************************************")

    runBlocking {
        launch { func("Child coroutine #3", 5000L) }
        launch { func("Child coroutine #4", 2000L) }
    }

    MyUtil.display("MESSAGE C **************************************")
}

private suspend fun func(message: String, delayMs: Long) {
    MyUtil.display("$message - start")
    delay(delayMs)
    MyUtil.display("$message - end")
}
