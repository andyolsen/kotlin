package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    // Create a Flow<Int>
    val flow1 = (1..5).asFlow().onEach { delay(3_000) }

    // For each element in the flow, call map() and get back a Flow<String>.
    // The overall effect is to create a Flow<Flow<String>>.
    MyUtil.display("Calling map()---------------------------------------------------------")
    flow1.map { getFlow(it) }
        .collect { MyUtil.display(it.toString()) }

    // For each element in the flow, call flatMapMerge().
    // This merges values from the subflows as soon as they arrive, into a single Flow<String>.
    MyUtil.display("Calling flatMapMerge()------------------------------------------------")
    flow1.flatMapMerge { getFlow(it) }
         .collect { MyUtil.display(it) }

}

// This function takes a single Int and returns a Flow<String>.
private fun getFlow(n: Int): Flow<String> = flow {

    for (i in 1..3) {
        emit("Value $n, string $i")
        delay(5_000)
    }
}