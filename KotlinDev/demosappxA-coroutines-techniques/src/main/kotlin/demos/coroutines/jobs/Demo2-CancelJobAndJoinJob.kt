package demos.coroutines.jobs

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

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

    MyUtil.display("Main coroutine, cancelling child coroutine...")
    job.cancel()

    MyUtil.display("Main coroutine, waiting for child coroutine to terminate")
    job.join()

    MyUtil.display("Main coroutine, all done!")
}
