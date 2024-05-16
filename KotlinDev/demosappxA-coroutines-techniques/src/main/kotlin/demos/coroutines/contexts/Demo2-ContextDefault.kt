package demos.coroutines.contexts

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // This coroutine uses the "default" dispatcher, which allocates threads from a shared background thread-pool.
    // This is also the dispatcher that's used when coroutines are launched in GlobalScope, i.e. via GlobalScope.launch {...}.
    val job = GlobalScope.launch(Dispatchers.Default) {
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
