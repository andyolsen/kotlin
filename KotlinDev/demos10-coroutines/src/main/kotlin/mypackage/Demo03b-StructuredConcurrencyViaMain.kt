package mypackage

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch a child coroutine in the background. This won't block.
    launch {
        delay(5000L)
        MyUtil.display("World")
    }

    // The main coroutine continues immediately, while the child coroutine does its delay().
    MyUtil.display("Hello")

    // Non-blocking delay on the main coroutine, to keep JVM alive.
    delay(10_000L)
}
