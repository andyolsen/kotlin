package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    MyUtil.display("main about to call getData()")
    val data: List<Int> = getData()

    MyUtil.display("main about to display result")
    data.forEach { MyUtil.display("Value $it") }
}

private suspend fun getData(): List<Int> {
    val data = mutableListOf<Int>()
    for (i in 1..200) {
        data.add(i*i)        // Add next value to list.
        delay(100)  // Pretend we are doing something useful here.
    }
    return data              // Return list all at once, at the end.
}