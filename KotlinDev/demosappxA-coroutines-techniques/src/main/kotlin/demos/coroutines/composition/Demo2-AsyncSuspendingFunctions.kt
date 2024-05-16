package demos.coroutines.composition

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.async

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // We can call suspending functions concurrently via async.
    // async starts a separate coroutine, similar to launch...
    //   - async returns a Deferred, a lightweight non-blocking future that will eventually hold the result.
    //   - launch just returns a Job.
    // Note that Deferred inherits from Job, so it can be cancelled etc.

    MyUtil.display("main calling func1")
    val res1 = async { func1() }

    MyUtil.display("main calling func2")
    val res2 = async { func2() }

    MyUtil.display("main doing some other work in the meantime...")
    delay(2_000)

    // When you want to get the result from a Deferred, call await().
    MyUtil.display("main about to calculate sum")
    val sum = res1.await() + res2.await()
    MyUtil.display("main sum is $sum")
}

private suspend fun func1(): Int {
    MyUtil.display("func1 start")
    delay(10_000L)
    MyUtil.display("func1 end")
    return 30
}

private suspend fun func2(): Int {
    MyUtil.display("func2 start")
    delay(5_000L)
    MyUtil.display("func2 end")
    return 12
}