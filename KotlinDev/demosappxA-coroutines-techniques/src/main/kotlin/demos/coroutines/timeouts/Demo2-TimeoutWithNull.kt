package demos.coroutines.timeouts

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch a child coroutine.
    val job = launch(Dispatchers.Default) {

        // Set an arbitrary timeout, from 0 to 15 seconds.
        val timeout = (Math.random() * 15_000).toLong()
        val result = withTimeoutOrNull(timeout) {
            try {
                repeat(10) { i ->
                    delay(1000L)
                    MyUtil.display("Child coroutine, iteration $i")
                }
                "Success"
            } finally {
                MyUtil.display("Child coroutine, in 'finally' block")
            }
        }
        MyUtil.display("Child coroutine result is $result")
    }

    // Wait for child coroutine to terminate.
    job.join()
    MyUtil.display("Main coroutine, all done!")
}

