package mypackage

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    // Launch a coroutine in the background.
    GlobalScope.launch {
        // Do a non-blocking delay, then print a message after the delay.
        MyUtil.display("Delay 1 start")
        delay(5000L)
        MyUtil.display("Delay 1 end")
    }

    // The main thread continues immediately, while the coroutine does its delay().
    MyUtil.display("Hello")

    // Block the main thread until the coroutine inside runBlocking completes.
    runBlocking {
        MyUtil.display("Delay 2 start")
        delay(10_000L)
        MyUtil.display("Delay 2 end")
    }

    MyUtil.display("That's all folks!")
}
