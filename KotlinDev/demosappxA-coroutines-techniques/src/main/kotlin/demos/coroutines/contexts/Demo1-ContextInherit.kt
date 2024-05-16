package demos.coroutines.contexts

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // When you use launch { ... } without parameters, it inherits the context (and thus dispatcher) from the CoroutineScope it's launched from.
    // So in our example, it inherits the context of the main runBlocking coroutine, which runs in the main thread.
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
