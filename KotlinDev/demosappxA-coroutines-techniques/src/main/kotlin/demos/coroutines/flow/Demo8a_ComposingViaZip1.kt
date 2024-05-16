package demos.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {

    val countriesFlow = listOf("UK", "NO", "SG", "SA").asFlow()
    val dialCodesFlow = listOf("44", "47", "65", "27").asFlow()

    countriesFlow.zip(dialCodesFlow) { c, d -> "$c -> +$d" }
        .collect { println(it) }
}