package mypackage

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    // Launch a lot of coroutines.
    repeat(100_000) {
        launch {
            delay(100L)
            val id = Thread.currentThread().id
            val count = Thread.activeCount()
            print("Thread id ${id}, active threads ${count}\n")
        }
    }
}