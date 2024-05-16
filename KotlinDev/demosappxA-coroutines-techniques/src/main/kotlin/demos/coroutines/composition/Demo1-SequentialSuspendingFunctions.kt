package demos.coroutines.composition

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Start main coroutine.
fun main() = runBlocking<Unit> {

    // We can call suspending functions sequentially...

    MyUtil.display("main calling func1")
    val res1 = func1()

    MyUtil.display("main calling func2")
    val res2 = func2()

    MyUtil.display("main about to calculate sum")
    val sum = res1 + res2
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