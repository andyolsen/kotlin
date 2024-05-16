package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    listOf(7.5, 8.25, 9.0, 10.0, 6.5).asFlow()
        .filter { isLongDay(it) }
        .map { calcOvertime(it) }
        .collect { displayOvertime(it) }

    MyUtil.display("main says goodbye")
}

private suspend fun isLongDay(hours: Double): Boolean {
    MyUtil.display("isLongDay with value $hours")
    delay(5_000)
    return hours > 7.5
}

private suspend fun calcOvertime(hours: Double): Double {
    MyUtil.display("calcOvertime with value $hours")
    delay(500)
    return hours - 7.5
}

private suspend fun displayOvertime(hours: Double) {
    MyUtil.display("displayOvertime with value $hours")
    delay(500)
    println("Hours overtime: $hours")
}