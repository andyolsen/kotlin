package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    listOf(7.5, 8.25, 9.0, 10.0, 6.5).asFlow()
        .transform {
            emit("\nRaw value $it")
            if (it > 7.5)
                emit("Overtime: ${it - 7.5}")
            else
                emit("No overtime")
        }
        .collect { println(it) }

    MyUtil.display("main says goodbye")
}
