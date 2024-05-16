package mypackage

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

fun main() {

    // Launch a coroutine in the background.
    GlobalScope.launch {
        MyUtil.display("Coroutine start")
        // Do a non-blocking delay, then print a message after the delay.
        delay(5000L)
        MyUtil.display("Coroutine end")
    }

    // The main thread continues immediately, while the coroutine does its delay().
    MyUtil.display("Hello!")

    // Thread.sleep() is a blocking function. It blocks the main thread for a while, to keep the JVM alive :-)
    Thread.sleep(10_000L)
    MyUtil.display("That's all folks!")
}
