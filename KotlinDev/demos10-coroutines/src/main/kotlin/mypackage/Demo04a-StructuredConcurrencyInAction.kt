package mypackage

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch child coroutine #1 inside the scope of the main coroutine.
    launch {
        MyUtil.display("Child coroutine #1 - start")
        delay(5000L)
        MyUtil.display("Child coroutine #1 - end")
    }

    // Launch child coroutine #2 inside the scope of the main coroutine.
    launch {
        MyUtil.display("Child coroutine #2 - start")
        delay(2000L)
        MyUtil.display("Child coroutine #2 - end")
    }

    // The main coroutine continues immediately...
    MyUtil.display("Hello")
}
