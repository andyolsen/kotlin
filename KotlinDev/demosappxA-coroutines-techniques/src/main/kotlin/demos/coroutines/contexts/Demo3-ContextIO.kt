package demos.coroutines.contexts

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // This coroutine uses the "IO" dispatcher, to offload blocking-IO tasks to a shared pool of threads.
    // Threads in this pool are created and shutdown on demand.
    val job = launch(Dispatchers.IO) {
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
