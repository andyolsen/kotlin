package demos.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    val flow = listOf("Huey", "Louie", "Dewey").asFlow()
    flow.collect { println(it) }
}
