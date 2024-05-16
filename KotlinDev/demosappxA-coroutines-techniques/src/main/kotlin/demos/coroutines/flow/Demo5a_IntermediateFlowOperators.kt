package demos.coroutines.flow

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    listOf("huey", "louie", "dewey").asFlow()
        .onEach { println("delaying on $it"); delay(1_000) }
        .collect { println(it) }

    MyUtil.display("main says goodbye")
}
