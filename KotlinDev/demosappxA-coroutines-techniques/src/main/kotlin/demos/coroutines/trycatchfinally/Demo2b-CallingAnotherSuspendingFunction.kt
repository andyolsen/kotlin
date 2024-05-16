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

            // If you need to call a suspending function in a possibly-cancelled coroutine, this is how:
            withContext(NonCancellable) {
                MyUtil.display("Child coroutine, start of 'finally' block")
                delay(1000L)
                MyUtil.display("Child coroutine, end of 'finally' block")
            }
        }
    }

    MyUtil.display("Main coroutine, delaying for 10 secs...")
    delay(10_000)

    MyUtil.display("Main coroutine, cancelling child coroutine and waiting for it to terminate...")
    job.cancelAndJoin()

    MyUtil.display("Main coroutine, all done!")
}

