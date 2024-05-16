package demos.coroutines.jobs

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch a child coroutine to do some long-running work in the background.
    val job = launch {
        repeat(20) { i ->
            delay(1000L)
            MyUtil.display("Child coroutine, iteration $i")
        }
    }

    MyUtil.display("Main coroutine, delaying for 10 secs...")
    delay(10_000)

    MyUtil.display("Main coroutine, cancelling child coroutine and waiting for it to terminate...")
    job.cancelAndJoin()

    MyUtil.display("Main coroutine, all done!")
}
