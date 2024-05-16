package demos.coroutines.jobs

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // When you launch a coroutine, you get back a Job that enables you to manage it.
    val job: Job = launch {
        delay(5000L)
        MyUtil.display("World")
    }

    // The main coroutine continues immediately...
    MyUtil.display("Hello")

    // Wait for child coroutine to complete (better than delaying for a fixed time for it to complete).
    job.join()

    MyUtil.display("That's all folks!")
}
