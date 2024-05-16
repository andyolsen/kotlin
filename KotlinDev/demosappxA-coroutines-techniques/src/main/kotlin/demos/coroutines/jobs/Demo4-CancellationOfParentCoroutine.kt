package demos.coroutines.jobs

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch a coroutine to do some long-running work in the background.
    val job = launch(CoroutineName("COROUTINE A")) {

        // Launch child coroutine B1.
        launch(CoroutineName("COROUTINE B1")) {
            repeat(20) { i ->
                delay(1000L)
                MyUtil.display("${this.coroutineContext[CoroutineName]}, value $i")
            }
        }

        // Launch child coroutine B2.
        launch(CoroutineName("COROUTINE B2")) {
            repeat(20) { i ->
                delay(1000L)
                MyUtil.display("${this.coroutineContext[CoroutineName]}, value ${i * 10}")
            }
        }

        // Launch child coroutine B3.
        launch(CoroutineName("COROUTINE B3")) {
            repeat(20) { i ->
                delay(1000L)
                MyUtil.display("${this.coroutineContext[CoroutineName]}, value ${i * 100}")
            }
        }
    }

    MyUtil.display("Main coroutine, delaying for 10 secs...")
    delay(10_000)

    MyUtil.display("Cancel COROUTINE A (will also cancel its child coroutines B1, B2, B3")
    job.cancelAndJoin()

    MyUtil.display("Main coroutine, all done!")
}
