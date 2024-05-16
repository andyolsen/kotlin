package demos.coroutines.trycatchfinally

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch a child coroutine.
    val job = launch {

        try {
            repeat(20) { i ->
                delay(1000L)
                MyUtil.display("Child coroutine, iteration $i")
            }
        }
        catch (ex: CancellationException) {
            MyUtil.display("Child coroutine, in 'catch' block")
        }
        finally {
            MyUtil.display("Child coroutine, start of 'finally' block")

            // Let's attempt to call a suspending function inside the 'finally' block.
            // If the current coroutine has been cancelled, then this will cause a CancellationException!
            delay(1000L)

            // We'll never get this far!
            MyUtil.display("Child coroutine, end of 'finally' block")
        }
    }

    MyUtil.display("Main coroutine, delaying for 10 secs...")
    delay(10_000)

    MyUtil.display("Main coroutine, cancelling child coroutine and waiting for it to terminate...")
    job.cancelAndJoin()

    MyUtil.display("Main coroutine, all done!")
}

