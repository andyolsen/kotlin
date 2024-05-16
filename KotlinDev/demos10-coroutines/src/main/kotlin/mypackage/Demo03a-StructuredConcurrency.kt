package mypackage

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    // Launch a "child" coroutine in the background. This won't block.
    launch {
        delay(5000L)
        MyUtil.display("After 5")
    }

    launch {
        delay(2000L)
        MyUtil.display("After 2")
    }

    // The parent coroutine continues immediately, while the child coroutine does its delay().
    MyUtil.display("Hello")

    // Non-blocking delay on the parent coroutine.
    delay(10_000L)
    MyUtil.display("After 10")
}
