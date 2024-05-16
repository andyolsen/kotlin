package demos.coroutines.composition

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

// Start main coroutine.
fun main() = runBlocking<Unit> {
    val sum = calcSum()
    MyUtil.display("main sum is $sum")

    val difference = calcDifference()
    MyUtil.display("main difference is $difference")
}

private suspend fun calcSum(): Int {

    val result = coroutineScope {

        MyUtil.display("calcSum calling func1")
        val res1 = async { func1() }

        MyUtil.display("calcSum calling func2")
        val res2 = async { func2() }

        MyUtil.display("calcSum doing some other work in the meantime...")
        delay(2_000)

        MyUtil.display("calcSum about to calculate sum")
        res1.await() + res2.await()
    }
    return result
}

// Call async() inside a suspending function.
// You can only call async() in a "coroutine scope".
// The coroutineScope() function creates a "coroutine scope" and invokes the specified block within this scope.
private suspend fun calcDifference(): Int = coroutineScope {

    MyUtil.display("calcDifference calling func1")
    val res1 = async { func1() }

    MyUtil.display("calcDifference calling func2")
    val res2 = async { func2() }

    MyUtil.display("calcDifference doing some other work in the meantime...")
    delay(2_000)

    MyUtil.display("calcDifference about to calculate difference")
    res1.await() - res2.await()
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
