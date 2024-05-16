package demos.coroutines.nonsuspendingcode

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // Launch a child coroutine to do some long-running work in the background.
    // The coroutine uses a thread from the thread pool (i.e. not the "main" thread).
    val job = launch(Dispatchers.Default) {
        MyUtil.display("Coroutine start")
        for (i in 1..500_000) {

            if (!this.isActive) {
                MyUtil.display("Coroutine quitting cooperatively")
                break
            }
            
            if (isPrime(i))
                MyUtil.display("Prime number: $i")
        }
        MyUtil.display("Coroutine end")
    }

    MyUtil.display("Main coroutine, delaying for 2 secs...")
    delay(2_000)

    MyUtil.display("Main coroutine, cancelling child coroutine and waiting for it to terminate...")
    job.cancelAndJoin()

    MyUtil.display("Main coroutine, all done!")
}

private fun isPrime(n: Int) : Boolean {
    for (i in 2 until n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}